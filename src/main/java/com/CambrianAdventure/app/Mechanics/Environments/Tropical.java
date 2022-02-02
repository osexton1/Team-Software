package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.Environment;
import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.exploration.Scenarios.*;

public class Tropical extends Environment {
    public Tropical(){
        super("Tropical Ocean", 6, new Generate().GenerateRoom(2));
    }
}
