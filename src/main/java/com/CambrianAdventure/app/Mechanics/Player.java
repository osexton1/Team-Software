package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.Mechanics.Environments.Shallows;

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

    public Player(){
        health = 3;
        //max of 3
        food = 20;
        foodStr = "";
        //default of 20, max of 50
        evolutionLevel = 0;
        //default of 0, max not determined
        Current = new Shallows();
        //default shallows
        foodOutput = "";
    }

    public void Move(String input){
        if (Objects.equals(input, "1")) {
            Current = Current.middlePath;
            Current.LoadBiomes();
        }
        else if (Objects.equals(input, "2")) {
            Current = Current.rightPath;
            Current.LoadBiomes();
        }
        else if (Objects.equals(input, "3")) {
            Current = Current.leftPath;
            Current.LoadBiomes();
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
