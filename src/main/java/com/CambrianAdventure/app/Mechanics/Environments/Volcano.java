package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Volcano extends Environment {
    public Volcano(){
        super("Volcano", 7, new Hallucigenia());
    }
}
