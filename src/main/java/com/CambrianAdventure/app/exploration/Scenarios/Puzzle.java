package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.exploration.Scenario;

public class Puzzle extends Scenario {

    public Puzzle(){
        super(1, "Puzzle");
        PuzzleNum = new Generate(3,2).int_random;
        Path = 0;
    }

}
