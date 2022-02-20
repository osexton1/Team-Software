package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.exploration.Scenario;

public class Puzzle extends Scenario {
    
    public Puzzle(){
        super(1, "Puzzle");
        p1Complete = false;
        p2Complete = false;
        p3Complete = false;
        path1 = 0;
        path2 = 0;
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
/**
 *      while(not completed) {
 *          PuzzleRun();
 *          if(p3 == complete) {
 *              completed = true;
 *          }
 *      }
 */
    }
    public void PuzzleRun(){
    }
}
