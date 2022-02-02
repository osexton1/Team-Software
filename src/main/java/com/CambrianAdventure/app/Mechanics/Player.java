package com.CambrianAdventure.app.Mechanics;
import java.util.Objects;

public class Player {
    public Integer health;
    public String healthOutput;
    public String healthStr;

    public Integer food;
    public String foodOutput;
    public String foodStr;

    public Integer evolutionLevel;

    public Environment Current;
    public int playerClass;
    //this can just be an integer thinking about it as opposed to 3 seperate classes.
    //0 = Shelled, 1 = Finned, 2 = Spiked

    public Player(){
        health = 3;
        //max of 3
        food = 20;
        foodStr = "";
        //default of 20, max of 50
        evolutionLevel = 0;
        Current = null;
        //default of 0, max not determined
        foodOutput = "";
    }

    public void Move(String input, boolean room){
        if (room){
            if (Objects.equals(input, "1")) {
                Current.scenario = Current.scenario.middlePath;
                Current.LoadRoom();
            }
            else if (Objects.equals(input, "2") && Current.scenario.leftPath != null) {
                Current.scenario = Current.scenario.leftPath;
                Current.LoadRoom();
            }
            else if (Objects.equals(input, "3") && Current.scenario.rightPath != null) {
                Current.scenario = Current.scenario.rightPath;
                Current.LoadRoom();
            }
        }
        else {
            if (Objects.equals(input, "1")) {
                Current = Current.middlePath;
                Current.LoadBiomes();
            } else if (Objects.equals(input, "2") && Current.scenario.rightPath != null) {
                Current = Current.rightPath;
                Current.LoadBiomes();
            } else if (Objects.equals(input, "3") && Current.scenario.leftPath != null) {
                Current = Current.leftPath;
                Current.LoadBiomes();
            }
        }
    }

    public void HealthLvl(String input){
        if (Objects.equals(input, "0")) {
            healthStr = health.toString();
            healthOutput = "You are at "+healthStr+" HP.";
            if (health == 3) {
                healthOutput += "You are feeling healthy.";
            } else if (health == 2) {
                healthOutput += "You feel weak.";
            } else if (health == 1) {
                healthOutput += "Your vision clouds. You will not last much longer.";
            }
            System.out.println(healthOutput);
        }
    }

    public void FoodLvl(String input){
        if (Objects.equals(input, "9")) {
            foodStr = food.toString();
            foodOutput = "You have "+foodStr+" food left.";
            if (food >= 25) {
                foodOutput += " Hunger pangs.";
            } else if (food <= 75) {
                foodOutput += " You are feeling well fed.";
            }
            System.out.println(foodOutput);
        }
    }
}
