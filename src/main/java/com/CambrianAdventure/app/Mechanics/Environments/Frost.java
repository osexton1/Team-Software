package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Frost extends Environment {
    public Frost(){
        super("Frost Spires", 0, new Generate(7, 4).int_random);
    }
}
