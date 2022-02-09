package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.enemies.Creature;
import com.CambrianAdventure.app.exploration.Scenario;
import com.CambrianAdventure.app.exploration.Scenarios.*;

import java.util.*;

public class Player extends Creature {
    public Integer biomeCount = 1;
    public Integer roomCount = 1;
    public Integer globalRoomCount = 1;
    public Environment Current = null;
    public Integer evolutionLevel = 0;
    public Integer playerClass;
    public Integer inventory = 0;
    public boolean combat = false;
    // classes.
    // 0 = Shelled, 1 = Finned, 2 = Spiked

    public Player(Integer PC){
        super("Player");
        this.playerClass = PC;
    }

    public void Move(Integer input) {
        if (Current.scenario.completed || !Current.completed) {
            if (Objects.equals(input, 1)) {
                Current.scenario = Current.scenario.middlePath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
                this.foodLevel(-1);
            }
            else if (Objects.equals(input, 2) && Current.scenario.leftPath != null) {
                Current.scenario = Current.scenario.leftPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
                this.foodLevel(-1);
            }
            else if (Objects.equals(input, 3) && Current.scenario.rightPath != null) {
                Current.scenario = Current.scenario.rightPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
                this.foodLevel(-1);
            }
            else{
                System.out.println("Invalid input for movement between rooms");
            }
        }
        else {
            if (Objects.equals(input, 1)) {
                Current = Current.middlePath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                Current.LoadBiomes();
            } else if (Objects.equals(input, 2) && Current.scenario.rightPath != null) {
                Current = Current.rightPath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                Current.LoadBiomes();
            } else if (Objects.equals(input, 3) && Current.scenario.leftPath != null) {
                Current = Current.leftPath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                Current.LoadBiomes();
            }
            else{
                System.out.println("Invalid input for movement between biomes");
            }
        }
    }

    public void WorldLevel() {
        System.out.println(biomeCount + "-" + roomCount);
    }

    public void characterInfo() {
        System.out.println("");
        System.out.println("You are at " + health + " HP." + "\tYou have " + food + " food left.");
        if (health == 3) {
            System.out.println("You are feeling healthy.");
        } else if (health == 2) {
            System.out.println("You feel weak.");
        } else if (health == 1) {
            System.out.println("Your vision clouds. You will not last much longer.");
        }
        if (food <= 5) {
            System.out.println("Hunger pangs.");
        } else if (food >= 15) {
            System.out.println("You are feeling well fed.");
        }
        System.out.println("");
        // see the comment on line 67
    }

    public void Eat(){
        if (this.inventory > 0) {
            this.foodLevel(this.inventory*5);
            System.out.println("You ate the food you've been carrying around with you.");
            this.inventory = 0;
        } else {
            System.out.println("You have no food to eat.");
        }
    }
    public void EventAction(){}

    public void foodLevel(Integer foodChange) {
        this.food += foodChange;
        if (this.food <= 0) {
            this.food = 0;
            this.health -= 1;
            System.out.println("You desperately need to find food. You are starving.");
            System.out.println("You now have " + health + " health remaining.");
        } else if (this.food > 100) {
            this.food = 100;
        }
        System.out.println("You now have " + food + " food remaining.");
    }

    public void Wait() {
        // this will be changing to draining food, and a chance at an encounter happening,
        // thus the trade-off is you might get more food, but you are wasting food by staying still
        Random rand = new Random();
        int encounter_chance = rand.nextInt(10); // 0-9 is 10 numbers so <3 is 30% of range
        // Thinking 30% encounter chance on wait but I'm flexible
        if (encounter_chance < 3) {
            System.out.println("After a period of waiting, you notice an enemy closing in on you.");
            System.out.println("You have no choice but to fight.");
            Encounter enemy = new Encounter();
        }
        this.foodLevel(-3);
    }

    public void Inspect() {
        // 30% chance each to trigger event, puzzle or encounter
        // 10% to just find food
        // No matter the outcome, drains food
        Random rand = new Random();
        int inspection_chance = rand.nextInt(10);
        if (inspection_chance > 3 && inspection_chance <= 6) {
            System.out.println("Your interactions with the environment revealed a puzzle.");
            Scenario puzzle = new Puzzle();
        } else if (inspection_chance  >= 1 && inspection_chance <= 3) {
            System.out.println("Your inspections drew the attention of a bigger creature.");
            System.out.println("You will have to fight.");
            Scenario enemy = new Encounter();
        } else if (inspection_chance < 1){
            System.out.println("After inspecting the entire area, you find a small amount of food.");
            int food_found = rand.nextInt(4);
            if (this.inventory > 0){
                this.Eat();
            }
            System.out.println("You started carrying the food you just found.");
            this.inventory = food_found;
        } else {
            System.out.println("You triggered an event.");
            Scenario event = new Event();
        }
        this.foodLevel(-3);
    }

    public void Hide() {
        System.out.println("You quickly find a rock to hide under in the environment.");
        this.foodLevel(-10);
    }
}
