package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Caves extends Environment {
    public Caves(){
        super("Cave entrance", 3, new Hallucigenia());
    }
}
