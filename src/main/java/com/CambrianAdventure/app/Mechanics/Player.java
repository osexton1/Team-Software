package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.enemies.Creature;

import java.util.Objects;

public class Player extends Creature {
    public Integer biomeCount = 1;
    public Integer roomCount = 1;
    public Integer globalRoomCount = 1;
    public Environment Current;
    public Integer evolutionLevel;
    public Integer playerClass;
    public boolean combat;
    // this can just be an integer thinking about it as opposed to 3 seperate
    // classes.
    // 0 = Shelled, 1 = Finned, 2 = Spiked

    public Player(Integer PC){
        super("Player");
        evolutionLevel = 0;
        playerClass = PC;
        Current = null;
    }

    public void Move(String input) {
        Integer inputting = Integer.parseInt(input) - 4;
        if (Current.scenario.completed || !Current.completed) {
            if (Objects.equals(inputting, 1)) {
                Current.scenario = Current.scenario.middlePath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
            }
            else if (Objects.equals(inputting, 2) && Current.scenario.leftPath != null) {
                Current.scenario = Current.scenario.leftPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
            }
            else if (Objects.equals(inputting, 3) && Current.scenario.rightPath != null) {
                Current.scenario = Current.scenario.rightPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
            }
            else{
                System.out.println("Invalid input for movement between rooms");
            }
        }
        else {
            if (Objects.equals(inputting, 1)) {
                Current = Current.middlePath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                Current.LoadBiomes();
            } else if (Objects.equals(inputting, 2) && Current.scenario.rightPath != null) {
                Current = Current.rightPath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                Current.LoadBiomes();
            } else if (Objects.equals(inputting, 3) && Current.scenario.leftPath != null) {
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
        System.out.println("You are at " + health + " HP." + "\tYou have " + food + " food left.");
        if (health == 3) {
            System.out.println("You are feeling healthy.");
        } else if (health == 2) {
            System.out.println("You feel weak.");
        } else if (health == 1) {
            System.out.println("Your vision clouds. You will not last much longer.");
        }
        if (food <= 25) {
            System.out.println("Hunger pangs.");
        } else if (food >= 75) {
            System.out.println("You are feeling well fed.");
        }
        // see the comment on line 67
    }
    public void Hide(){}
    public void Inspect(){}
    public void Eat(){}
    public void EventAction(){}

    public void Wait() {
        // this will be changing to draining food, and a chance at an encounter happening,
        // thus the trade-off is you might get more food but you are wasting food by staying still
        if (this.health < 3) {
            this.health += 1;
            System.out.println("After taking a well deserved break, you feel rejuvenated and enjoy a burst of energy.");
            System.out.println("You now have " + health + " health remaining.");
        } else {
            System.out.println(
                    "Although you have rested, you feel no different. It's as if you were already full of vitality.");
            System.out.println("You still have 3 health remaining");
        }
    }
}
