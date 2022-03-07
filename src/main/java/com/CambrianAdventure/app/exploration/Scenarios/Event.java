package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.Hallucigenia;
import com.CambrianAdventure.app.exploration.Scenario;

public class Event extends Scenario {
    public Event(){
        super(0, "Event");
        PuzzleNum = new Generate(2,2).int_random;
//        PuzzleNum = 1;
        Path = 0;
    }
}
