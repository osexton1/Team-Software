package com.CambrianAdventure.app.enemies;

import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Creature {
    public String name;
    public int health;
    public int food;

    public Creature(String Name){
        name = Name;
        health = 50;
        food = 50;
    }
    //combat stuff goes here

    public String toString(){
        return name + "; health: " + health + ", food: " + food;
    }
}
