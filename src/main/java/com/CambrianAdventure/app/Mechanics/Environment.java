package com.CambrianAdventure.app.Mechanics;

import com.CambrianAdventure.app.enemies.*;

public class Environment {
    public String Descript;
    public Base Enemy;
    public int type;

    public Environment(String description, int Type, Base enemy) {
        Descript = description;
        type = Type;
        Enemy = enemy;
    }

    public String toString(){
        return "You are currently located in a " + Descript + ", There is a " + Enemy;
    }

}
