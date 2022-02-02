package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.exploration.Scenarios.*;

public class Caves extends Environment {
    public Caves(){
        super("Cave entrance", 1, new Generate().GenerateRoom(2));
    }
}
