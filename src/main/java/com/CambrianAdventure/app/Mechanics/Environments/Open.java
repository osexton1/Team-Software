package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Open extends Environment {
    public Open(){
        super("Open Sea", 3, new Generate().GenerateRoom(2));
    }
}
