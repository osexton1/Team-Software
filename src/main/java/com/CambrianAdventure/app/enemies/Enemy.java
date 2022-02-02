package com.CambrianAdventure.app.enemies;

import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Enemy {
    public String name;
    public int health;
    public int food;
    public int evolutionLevel;
    public String inventorySpot;
    public Persona personality;
    public Enemy(String Name, Persona Persona){
        name = Name;
        health = 50;
        food = 20;
        evolutionLevel = 0;
        inventorySpot = null;
        personality = Persona;
    }

    public String toString(){
        return name + " who looks " + personality ;
    }
}
