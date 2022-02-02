package com.CambrianAdventure.app.exploration;
import com.CambrianAdventure.app.Mechanics.*;
public class Scenario {
    int type;
    int numPaths;
    boolean BBEGPresent;
    boolean BBEGPassed;
    boolean foodGen;
    int foodAmount;

    public Scenario(int Type){
        type = Type;
        numPaths = new Generate(3,1).int_random;
        BBEGPresent = false;
        BBEGPassed = false;
        foodGen= new Generate().coinFlip();
        foodAmount= new Generate(4,1).int_random;

    }
}
