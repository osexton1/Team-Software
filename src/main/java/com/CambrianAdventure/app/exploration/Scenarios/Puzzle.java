package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.exploration.Scenario;

public class Puzzle extends Scenario {
    
    public boolean p1Complete = false;
    public boolean p2Complete = false;
    public boolean p3Complete = false;

    public Integer p1Path = 0;
    public Integer p2Path = 0;
    
    public Puzzle(){
        super(1, "Puzzle");
    }

    public void PuzzlePaths(){
        if(p3Complete) {
            PuzzleRun();
            completed = true;
        } else if(p2Complete) {
            PuzzleRun();
        } else if(p1Complete) { 
            PuzzleRun();
        }
    }
    public void PuzzleRun(){
        roomdesc(Scenario )
    }
}
