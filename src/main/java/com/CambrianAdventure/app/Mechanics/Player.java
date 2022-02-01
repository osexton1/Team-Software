package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.Mechanics.Environments.Shallows;

import java.util.Objects;

public class Player {
    public int health;
    public int food;
    public int evolutionLevel;
    public String inventorySpot;
    public Environment Current;

    public Player(){
        health = 50;
        food = 20;
        evolutionLevel = 0;
        inventorySpot = null;
        Current = new Shallows();
    }

    public void Move(String input){
        if (Objects.equals(input, "Left")) {
            Current = Current.leftPath;
            Current.LoadBiomes();
        }
        else if (Objects.equals(input, "Right")) {
            Current = Current.rightPath;
            Current.LoadBiomes();
        }
    }
}
