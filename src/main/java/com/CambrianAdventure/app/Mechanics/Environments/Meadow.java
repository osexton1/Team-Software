package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Meadow extends Environment {
    public Meadow(){
        super("Ocean Meadow", 5, new Hallucigenia());
    }
}
