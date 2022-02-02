package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Shallows extends Environment {
    public Shallows(){
        super("Shallows", 4, new Generate().GenerateRoom(2));
    }
}
