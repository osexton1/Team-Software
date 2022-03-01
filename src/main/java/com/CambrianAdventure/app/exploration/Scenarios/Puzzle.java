package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.exploration.Scenario;

public class Puzzle extends Scenario {
    
    public boolean p1Complete = false;
    public boolean p2Complete = false;
    public boolean p3Complete = false;

    public Integer path1 = 0;
    public Integer path2 = 0;
    
    public Puzzle(){
        super(1, "Puzzle");
        Path = 0;
        path1 = 0;
        path2 = 0;
    }

    public void PuzzlePaths(){
//        if(p3Complete) {
//            completed = true; //unless it gets something new
//            PuzzleRun();
//        } else if(p2Complete) {
//            PuzzleRun();
//        } else if(p1Complete) {
//            PuzzleRun();
//        }
//        else{
//
//        }
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
