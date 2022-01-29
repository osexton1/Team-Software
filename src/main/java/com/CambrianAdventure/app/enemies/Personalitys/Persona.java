package com.CambrianAdventure.app.enemies.Personalitys;

public class Persona {
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
