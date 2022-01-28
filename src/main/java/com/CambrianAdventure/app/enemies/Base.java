package com.CambrianAdventure.app.enemies;

public class Base {
    public String name;
    public int health;
    public int food;
    public int evolutionLevel;
    public String inventorySpot;
    public String personality;
    public Base(String Name, String Persona){
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
