package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Volcano extends Environment {
    public Volcano(){
        super("Volcanic Depths", 7, new Generate(7, 4).int_random);
    }
}
