package com.CambrianAdventure.app.enemies;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Creature {
    public String name;
    public Integer health;
    public Integer food;
    public Integer combatHealth;
    public Persona personality;
    public Integer disToFlee;

    public Creature(String Name){
        name = Name;
        health = 3;
        combatHealth = 20;
        food = 20;
        disToFlee = 2;
    }

    public Creature(String Name, Persona Personality){
        name = Name;
        health = 3;
        combatHealth = 20;
        food = new Generate(15, 5).int_random;
        disToFlee = 2;
        personality = Personality;
    }
    //combat stuff goes here
    public void attack(Creature target){

    }
    public void AICalculate(){

    }

    public String toString(){
        return name + "; health: " + health + ", food: " + food;
    }
}
