package com.CambrianAdventure.app.Mechanics;
import java.util.Objects;

public class Player {
    public Integer health;
    public String healthStr;

    public Integer food;
    public String foodStr;

    public Integer evolutionLevel;

    public Environment Current;
    public Integer playerClass;
    //this can just be an integer thinking about it as opposed to 3 seperate classes.
    //0 = Shelled, 1 = Finned, 2 = Spiked
    public Integer biomeCount = 1;
    public Integer roomCount = 1;
    public Integer globalRoomCount = 1;
    public Player(){
        health = 3;
        //max of 3
        food = 20;
        //default of 20, max of 50
        evolutionLevel = 0;
        Current = null;
        //default of 0, max not determined
    }

    public void Move(String input, boolean room){
        if (room){
            if (Objects.equals(input, "1")) {
                Current.scenario = Current.scenario.middlePath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
            }
            else if (Objects.equals(input, "2") && Current.scenario.leftPath != null) {
                Current.scenario = Current.scenario.leftPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
            }
            else if (Objects.equals(input, "3") && Current.scenario.rightPath != null) {
                Current.scenario = Current.scenario.rightPath;
                Current.LoadRoom();
                roomCount += 1;
                globalRoomCount += 1;
            }
        }
        else {
            if (Objects.equals(input, "1")) {
                Current = Current.middlePath;
                Current.LoadBiomes();
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
            } else if (Objects.equals(input, "2") && Current.scenario.rightPath != null) {
                Current = Current.rightPath;
                Current.LoadBiomes();
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
            } else if (Objects.equals(input, "3") && Current.scenario.leftPath != null) {
                Current = Current.leftPath;
                Current.LoadBiomes();
                biomeCount += 1;
                roomCount = 1;
                globalRoomCount += 1;
            }
        }
    }

    public void HealthLvl(String input){
        if (Objects.equals(input, "0")) {
            healthStr = health.toString();
            System.out.println("You are at "+healthStr+" HP.");
            if (health == 3) {
                System.out.println("You are feeling healthy.");
            } else if (health == 2) {
                System.out.println("You feel weak.");
            } else if (health == 1) {
                System.out.println("Your vision clouds. You will not last much longer.");
            }
            //while this isn't a hack, we could implement it in a cooler way when 
            //we realise what the fuck a hashtable is

        }
    }

    public void WorldLevel(String input){
        if (Objects.equals(input, "8")) {
            System.out.println(biomeCount.toString()+"-"+roomCount.toString());
        }
    }

    public void FoodLvl(String input){
        if (Objects.equals(input, "9")) {
            foodStr = food.toString();
            System.out.println("You have "+foodStr+" food left.");
            if (food >= 25) {
                System.out.println("Hunger pangs.");
            } else if (food <= 75) {
                System.out.println("You are feeling well fed.");
            }
            //see the comment on lines 85-86
        }
    }

    public void Wait() {
        if (this.health < 3) {
            this.health+= 1;
            healthStr = health.toString();
            System.out.println("After taking a well deserved break, you feel rejuvenated and enjoy a burst of energy.");
            System.out.println("You now have " +healthStr+ " health remaining.");
        } else {
            System.out.println("Although you have rested, you feel no different. It's as if you were already full of vitality.");
            System.out.println("You still have 3 health remaining");
        }
    }
}
