package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.enemies.Creature;
import com.CambrianAdventure.app.exploration.Scenario;
import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.exploration.Scenarios.*;

import java.util.*;

import static com.CambrianAdventure.app.Main.*;


public class Player extends Creature {
    public Integer biomeCount = 1;
    public Integer roomCount = 1;
    public Integer globalRoomCount = 1;
    public boolean hidden;
    public Environment Current = null;
    public Integer evolutionLevel = 0;
    public Integer maxFood = 20;
    public Integer maxCombatHealth = 20;

    public Player(){
        super("Player");
    }

    public void setPlayerClass(String PC){
        this.playerClass = PC;
        if (PC == "Finned") {
            Speed += 1;
        }
        else if (PC == "Shelled") {
            Speed -= 1;
            armorLevel = 1;
        }
        else if(PC == "Spiked"){
            spikeDamage = 1;
        }
    }

    public void charDisplay(){
        Layout.setCharText("Health: " + health + "/3\n");
        Layout.addCharText("Food: " + food + "/" + maxFood + "\n");
        Layout.addCharText("Combat Health: " + combatHealth + "/" + maxCombatHealth + "\n");
        Layout.addCharText("Class: " + playerClass + "\n");
        Layout.addCharText("Biome: " + Current.Name + "\n");
        Layout.addCharText("Biome number: " + biomeCount + "\n");
        Layout.addCharText("Room number: " + roomCount + "\n");
        Layout.addCharText("Global room total: " + globalRoomCount + "\n");
    }

    public void Move(Integer input) {
        if (Current.scenario.completed && !Current.completed) {
            if (Objects.equals(input, 1)) {
                Current.scenario = Current.scenario.middlePath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
                this.combatHealth = this.maxCombatHealth;
                this.foodLevel(-1);
            }
            else if (Objects.equals(input, 2) && Current.scenario.leftPath != null) {
                Current.scenario = Current.scenario.leftPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
                this.combatHealth = this.maxCombatHealth;
                this.foodLevel(-1);
            }
            else if (Objects.equals(input, 3) && Current.scenario.rightPath != null) {
                Current.scenario = Current.scenario.rightPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
                this.combatHealth = this.maxCombatHealth;
                this.foodLevel(-1);
            }
            else{
               Layout.setError("Invalid input for movement between rooms");
               LevelUp = false;
            }
        }
        else {
            if (Objects.equals(input, 1)) {
                Current = Current.middlePath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                this.combatHealth = this.maxCombatHealth;
                Current.LoadBiomes();
                if (hunterPresent){
                    if (Current.scenario == null){
                        Current.scenario = new Encounter();
                    }
                    if (Current.scenario.numPaths > 2){
                        Current.scenario.rightPath = new Encounter();
                    }
                    if (Current.scenario.numPaths > 1){
                        Current.scenario.leftPath = new Encounter();
                    }
                    Current.scenario.middlePath = new Encounter();
                }
                else {
                    Current.LoadRoom();
                }
            } else if (Objects.equals(input, 2) && Current.leftPath != null) {
                Current = Current.leftPath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                this.combatHealth = this.maxCombatHealth;
                Current.LoadBiomes();
                if (hunterPresent){
                    if (Current.scenario == null){
                        Current.scenario = new Encounter();
                    }
                    if (Current.scenario.numPaths > 2){
                        Current.scenario.rightPath = new Encounter();
                    }
                    if (Current.scenario.numPaths > 1){
                        Current.scenario.leftPath = new Encounter();
                    }
                    Current.scenario.middlePath = new Encounter();
                }
                else {
                    Current.LoadRoom();
                }
            } else if (Objects.equals(input, 3) && Current.rightPath != null) {
                Current = Current.rightPath;
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
                this.combatHealth = this.maxCombatHealth;
                Current.LoadBiomes();
                if (hunterPresent){
                    if (Current.scenario == null){
                        Current.scenario = new Encounter();
                    }
                    if (Current.scenario.numPaths > 2){
                        Current.scenario.rightPath = new Encounter();
                    }
                    if (Current.scenario.numPaths > 1){
                        Current.scenario.leftPath = new Encounter();
                    }
                    Current.scenario.middlePath = new Encounter();
                }
                else {
                    Current.LoadRoom();
                }
            }
            else{
                Layout.setError("Invalid input for movement between biomes");
                LevelUp = false;
            }
        }
        charDisplay();
    }

//            Layout.addDesText("\nSomething noticed you, get ready for a fight");
//

    public void combatInput(String input){
        try{
            int inputting = Integer.parseInt(input);
            if (inputting >= 1 && inputting <= 5){
                String action = this.Current.scenario.enemy.AICalculate();
                boolean Turn = false;
                String Action = "";
                switch(inputting){
                    case 1: comInspect(Current.scenario.enemy); break; //gives indications of weaknesses/other stuff
                    case 2: Action = "Advance"; Turn = true; break; //advance
                    case 3: Action = "Flee"; Turn = true; break; //retreat/ replaced with hide once disToFlee == 0, should break out of the combat
                    case 4: Action = "Wait"; Turn = true; break; //skip a turn
                    case 5: Action = "Attack";
                        Turn = true;
                        break;
                }
                if( Turn && this.Current.scenario.enemy.combatHealth > 0){
                    if (this.Current.scenario.enemy.Speed > this.Speed) {
                        this.Current.scenario.enemy.AIDo(action, this);
                        this.doAction(Action);
                    }
                    else{
                        this.doAction(Action);
                        this.Current.scenario.enemy.AIDo(action, this);
                    }
                }
            }
            else{
                Layout.setError("Invalid Input");
            }
            if (Current.scenario.enemy.combatHealth <= 0){ //if creature dies
                foodLevel(+3);
                Current.scenario.completed = true;
                Current.scenario.changeState();
            }
            if (combatHealth <= 0){ //if Player dies
                foodLevel(-6);
                if (health != 0) {
                    Layout.setError("You lost the fight, and barely escaped with your life");
                }
                Current.scenario.completed = true;
                Current.scenario.changeState();
            }
        }
        catch(Throwable Error){
            Layout.setError("Invalid Input invali");
        }
    }

    public void doAction(String Action){
        if (Action == "Advance"){
            if(this.Current.scenario.enemy.disPlay > 0){this.disToFlee += 1; this.Current.scenario.enemy.disPlay -= 1;}
            else{Layout.setError("Unable to move forward");} //advance
            }
        else if (Action == "Flee") {
            if (this.disToFlee > 0) {
                this.disToFlee -= 1;
                this.Current.scenario.enemy.disPlay += 1;
            } else {
                Layout.setError("You are fleeing");
                Current.scenario.completed = true;
                Current.scenario.changeState();
            } //retreat/ replaced with hide once disToFlee == 0, should break out of the combat
        }
        else if (Action == "Wait"){ comWait();} //skip a turn
        else if (Action == "Attack") {
            if(this.Current.scenario.enemy.disPlay == 0){attack(this, this.Current.scenario.enemy);}
            else{Current.scenario.enemy.Threaten();}
        }
        charDisplay();
    }

    public void puzzleInput(String Action){
        switch(Current.scenario.Path){
            case 0: Current.scenario.Path = Integer.parseInt(Action)+2; break;
            case 3: Current.scenario.Path = Integer.parseInt(Action)+8;break;
            case 4: Current.scenario.Path = Integer.parseInt(Action)+10;break;
        }
    }

//                GSMF - gain 2 food
//                GBGF - gain 4 food
//                LSMF - lose 4 food
//                LBGF - lose 8 food
//                LOHP - lose 1 hp
//                NTHN - nothing
//                FSMM - fight small mob
//                FMEM - fight med mob
//                FBGM - fight boss
//                DEAD - death

    public void genPuzOut(String out){
        switch (out){
            case "GSMF": foodLevel(2);
                Current.scenario.completed = true;
                Layout.setError("You gained a small amount of food");
                break;
            case "GBGF": foodLevel(4);
                Current.scenario.completed = true;
                Layout.setError("You gained a large amount of food");break;
            case "LSMF": foodLevel(-4);
                Current.scenario.completed = true;
                Layout.setError("You lost a small amount of food");break;
            case "LBGF": foodLevel(-8);
                Current.scenario.completed = true;
                Layout.setError("You lost a large amount of food");break;
            case "LOHP": this.health -= 1; charDisplay();
                Current.scenario.completed = true;
                Layout.setError("You lost a health point"); break;
            case "NTHN":
                Layout.setError("Nothing happened");break;
            case "FSMM":
                Encounter enemy = new Encounter();
                enemy.enemy = new Generate().GenSmall();
                enemy.numPaths = Current.scenario.numPaths;
                enemy.leftPath = Current.scenario.leftPath;
                enemy.middlePath = Current.scenario.middlePath;
                enemy.rightPath = Current.scenario.rightPath;
                disToFlee = 2;
                Current.scenario = enemy;
                Current.scenario.completed = false;
                Current.scenario.State = "During";
                Layout.setError("A small creature appeared");break;
            case "FMEM": enemy = new Encounter();
                enemy.enemy = new Generate().GenLarge();
                enemy.numPaths = Current.scenario.numPaths;
                enemy.leftPath = Current.scenario.leftPath;
                enemy.middlePath = Current.scenario.middlePath;
                enemy.rightPath = Current.scenario.rightPath;
                disToFlee = 2;
                Current.scenario = enemy;
                Current.scenario.completed = false;
                Current.scenario.State = "During";
                Layout.setError("A Large creature appeared");
                break;
            case "FBGM":
                enemy = new Encounter();
                enemy.enemy = new Generate().GenBoss();
                enemy.numPaths = Current.scenario.numPaths;
                enemy.leftPath = Current.scenario.leftPath;
                enemy.middlePath = Current.scenario.middlePath;
                enemy.rightPath = Current.scenario.rightPath;
                disToFlee = 2;
                Current.scenario = enemy;
                Current.scenario.completed = false;
                Current.scenario.State = "During";
                Layout.setError("A boss creature appeared");
            case "DEAD": this.health = 0;
                Current.scenario.completed = true;
                charDisplay();
                Layout.setError("You died");
                break;
        }
    }

    public void genEveOut(String out){
        switch (out){
            case "GSMF": foodLevel(2);
                Layout.setError("You gained a small amount of food");break;
            case "GBGF": foodLevel(4);
                Layout.setError("You gained a large amount of food");break;
            case "LSMF": foodLevel(-4);
                Layout.setError("You lost a small amount of food");break;
            case "LBGF": foodLevel(-8);
                Layout.setError("You lost a large amount of food");break;
            case "LSPL": if (spikeDamage > 0) {
                spikeDamage -= 1;
                Layout.setError("Your spikes have dulled");
            } break;
            case "LOHP": this.health -= 1; charDisplay();
                Layout.setError("You lost a health point"); break;
            case "NTHN":
                Layout.setError("Nothing happened");break;
            case "FSMM":
                Encounter enemy = new Encounter();
                enemy.enemy = new Generate().GenSmall();
                enemy.numPaths = Current.scenario.numPaths;
                enemy.leftPath = Current.scenario.leftPath;
                enemy.middlePath = Current.scenario.middlePath;
                enemy.rightPath = Current.scenario.rightPath;
                disToFlee = 2;
                Current.scenario = enemy;
                Current.scenario.completed = false;
                Current.scenario.State = "During";
                Layout.setError("A small creature appeared");
                        break;
            case "FMEM":
                enemy = new Encounter();
                enemy.enemy = new Generate().GenLarge();
                enemy.numPaths = Current.scenario.numPaths;
                enemy.leftPath = Current.scenario.leftPath;
                enemy.middlePath = Current.scenario.middlePath;
                enemy.rightPath = Current.scenario.rightPath;
                disToFlee = 2;
                Current.scenario = enemy;
                Current.scenario.completed = false;
                Current.scenario.State = "During";
                Layout.setError("A Large creature appeared");
                break;
            case "FBGM":
                enemy = new Encounter();
                enemy.enemy = new Generate().GenBoss();
                enemy.numPaths = Current.scenario.numPaths;
                enemy.leftPath = Current.scenario.leftPath;
                enemy.middlePath = Current.scenario.middlePath;
                enemy.rightPath = Current.scenario.rightPath;
                disToFlee = 2;
                Current.scenario = enemy;
                Current.scenario.completed = false;
                Current.scenario.State = "During";
                Layout.setError("A boss creature appeared");
                break;
            case "TSPL": if (spikeDamage > 0) {
                            spikeDamage -= 1;
                            foodLevel(5);
                            Layout.setError("You traded your spikes for some food");
                         } else {
                            Layout.setError("Your spikes are too dull to trade");
                         } break;
            case "GSHL": this.armorLevel += 1;
                Layout.setError("You gained a level of armor"); break;
            case "DEAD": this.health = 0; charDisplay();
                Layout.setError("You died"); break;
        }
    }

    public void eventInput(String Action){
        if (Integer.parseInt(Action) < 3) {
            Current.scenario.Path = Integer.parseInt(Action) + 5;
        }
        else{
            if(playerClass == "Shelled"){Current.scenario.Path = Integer.parseInt(Action) + 5;}
            else if(playerClass == "Finned"){Current.scenario.Path = Integer.parseInt(Action) + 6;}
            else if(playerClass == "Spiked"){Current.scenario.Path = Integer.parseInt(Action) + 7;}
        }
    }

    public String combatMap(){
        String output = "\n\n";
        for (int i = 0; i < (disToFlee + 2 + Current.scenario.enemy.disToFlee + Current.scenario.enemy.disPlay); i++){
            if (i == disToFlee){ output += " P";}
            else if(i == (1 + disToFlee + Current.scenario.enemy.disPlay)){output += " E";}
            else{
                output += " -";
            }
        }
        return output;
    }

    public void Eat(){
        if (Current.scenario.foodGen && Current.scenario.foodAmount > 0){
            for (int i = 0; i < Current.scenario.foodAmount; i++){
                Layout.setError("There is " + Current.scenario.foodAmount + " food chunks in the room\n");
                if (!Objects.equals(food, maxFood)) {
                    foodLevel(2);
                    Current.scenario.foodAmount -= 1;
                    i--;
                    Layout.setError("There is " + Current.scenario.foodAmount + " food chunks left in the room\n");
                    foodLevel(0);

                }
                else{
                    Layout.addError("You have no space to eat the food");
                }
            }
        }
        else{
            Layout.addError("There is no food to eat");
        }
        charDisplay();
    }

    public void foodLevel(Integer foodChange) {
        if (this.food + foodChange > maxFood) {
            foodChange = maxFood - this.food;
        }
        this.food += foodChange;
        if (this.food <= 0) {
            this.food = 3;
            this.health -= 1;
            Layout.addError("You desperately need to find food. You are starving.\nYou now have " + health + " health remaining.\n");
        }
        else if (this.food > maxFood) {
            this.food = maxFood;
        }
        if (foodChange == 0) {
            Layout.addError("You have " + food + " food remaining.\n");
        }
        else if(foodChange > 0){
            Layout.addError("You gained " + foodChange + " food.\n");
        }
        else if(foodChange < 0){
            Layout.addError("You lost " + foodChange.toString().substring(1) + " food.\n");
        }
        charDisplay();
    }

    public void Wait() {
        // this will be changing to draining food, and a chance at an encounter happening,
        // thus the trade-off is you might get more food, but you are wasting food by staying still
        this.foodLevel(-2);
        int encounter_chance = new Generate(9).int_random; // 0-9 is 10 numbers so <3 is 30% of range
        // Thinking 30% encounter chance on wait but I'm flexible
        if (encounter_chance < 3) {
            Encounter enemy = new Encounter();
            enemy.numPaths = Current.scenario.numPaths;
            enemy.leftPath = Current.scenario.leftPath;
            enemy.middlePath = Current.scenario.middlePath;
            enemy.rightPath = Current.scenario.rightPath;
            disToFlee = 2;
            Current.scenario = enemy;
            Current.scenario.State = "During";
            Layout.setError("After a period of waiting, you notice an enemy closing in on you.");
            Layout.addError("You have no choice but to fight.");
        }
        charDisplay();
    }

    public void Inspect() {
        // 30% chance each to trigger event, puzzle or encounter
        // 10% to just find food
        // No matter the outcome, drains food
        this.foodLevel(-2);
        int inspection_chance = new Generate(10).int_random;
        if (inspection_chance > 3 && inspection_chance <= 6) {
            Scenario puzzle = new Puzzle();
            Current.scenario = puzzle;
            Current.LoadRoom();
            Layout.addError("Your interactions with the environment revealed a puzzle.");
        }
        else if (inspection_chance <= 3){
            int food_found = new Generate(3, 1).int_random;
            foodLevel(food_found*2);
            Layout.addError("After inspecting the entire area, you find a small amount of food.");
        }
        else {
            Scenario event = new Event();
            Current.scenario = event;
            Current.LoadRoom();
            Layout.addError("You triggered an event.");
        }
        charDisplay();
    }

    public void Hide() {
        if (Current.scenario.completed) {
            this.hidden = true;
            this.foodLevel(-2);
            Layout.addError("You quickly find a rock to hide from the creature.\n");
        }
        else{
            Layout.addError("No Violent creatures to hide from\n");
        }
    }
}
