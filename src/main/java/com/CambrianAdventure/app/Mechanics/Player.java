package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.Mechanics.Environments.Shallows;

import java.util.Objects;

public class Player {
    public int health;
    public int food;
    public int evolutionLevel;
    public Environment Current;

    public Player(){
        health = 3;
        food = 20;
        evolutionLevel = 0;
        Current = new Shallows();
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
}
