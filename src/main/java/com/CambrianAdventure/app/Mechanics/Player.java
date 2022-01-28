package com.CambrianAdventure.app.Mechanics;

public class Player {
    public int health;
    public int food;
    public int evolutionLevel;
    public String inventorySpot;
    public Player(){
        health = 50;
        food = 20;
        evolutionLevel = 0;
        inventorySpot = null;
    }

    public void Move(){
        System.out.println("Venturing further into the depths");

    }
}
