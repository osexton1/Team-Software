package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Open extends Environment {
    public Open(){
        super("Open Ocean", 3, new Generate(10, 8).int_random);
    }
}
