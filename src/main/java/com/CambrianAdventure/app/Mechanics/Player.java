package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.Mechanics.Environments.Shallows;

import java.util.Objects;

public class Player {
    public int health;
    public Integer food;
    public int evolutionLevel;
    public Environment Current;
    public String foodOutput;
    public String foodStr;

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
    public String FoodLvl(String input){
        if (Objects.equals(input, "9")) {
            foodStr = food.toString();
            foodOutput += "You have "+foodStr+" food left.";
            if (food >= 25) {
                foodOutput += " Hunger pangs.";
            } if (food <= 75) {
                foodOutput += " You are feeling well fed.";
            }
        }
        return foodOutput;
    }
}
