package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Tropical extends Environment {
    public Tropical(){
        super("Tropical Ocean", 6, new Hallucigenia());
    }
}
