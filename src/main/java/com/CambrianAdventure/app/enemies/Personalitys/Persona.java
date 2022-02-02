package com.CambrianAdventure.app.enemies.Personalitys;

public abstract class Persona {
    String Name;
    int Bonus;
    public Persona(String name, int bonus){
        Name = name;
        Bonus = bonus;
    }
    public String toString(){
        return Name + " towards you";
    };

}
