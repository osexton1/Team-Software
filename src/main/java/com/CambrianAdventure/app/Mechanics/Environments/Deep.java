package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Deep extends Environment {
    public Deep(){
        super("Deep Ocean", 2, new Generate().GenerateRoom(2));
    }
}
