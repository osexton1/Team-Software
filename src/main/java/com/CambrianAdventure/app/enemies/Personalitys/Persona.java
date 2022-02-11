package com.CambrianAdventure.app.enemies.Personalitys;

public abstract class Persona {
    public String Name;
    public Integer Bonus;
    public Persona(String name, int bonus){
        Name = name;
        Bonus = bonus;
    }
    public String toString(){
        return Name + " towards you";
    };

}
