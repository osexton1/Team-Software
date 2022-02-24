package com.CambrianAdventure.app.exploration;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Creature;

import java.util.Objects;

public class Scenario {
    public int type;
    public int numPaths;
    public String Name;
    public String State;
    public String Description;
    public Scenario middlePath;
    public Scenario rightPath;
    public Scenario leftPath;

    public Creature enemy;
    public boolean p1Complete;
    public boolean p2Complete;
    public boolean p3Complete;
    public Integer path1;
    public Integer path2;

    public boolean BBEGPresent;
    public boolean BBEGPassed;
    public boolean completed;
    public boolean foodGen;
    public int foodAmount;

    public Scenario(int Type, String name){
        type = Type;
        Name = name;
        State = "Pre";
        Description = null;
        numPaths = new Generate(3).int_random + 1;
        BBEGPresent = false;
        BBEGPassed = false;
        completed = false;
        foodGen= new Generate().coinFlip();
        foodAmount= new Generate(3,1).int_random;
        middlePath = null;
        rightPath = null;
        leftPath = null;
    }

    @Override
    public String toString() {
        String output = "Room type: " + Name + ", Number of paths: " + numPaths + ", middle Path: " + middlePath.Name;
        if (leftPath != null){
            output += ", left Path: " + leftPath.Name;
        }
        if (rightPath != null){
            output += ", right Path: " + rightPath.Name;
        }
        return output;
    }
    public void changeState(){
        if(Objects.equals(State, "Pre")){
            State = "During";
            System.out.println("During");
        }
        else{
            State = "After";
            System.out.println("After");
        }

    }
}
