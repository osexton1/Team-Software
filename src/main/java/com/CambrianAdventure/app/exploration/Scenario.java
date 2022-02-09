package com.CambrianAdventure.app.exploration;
import com.CambrianAdventure.app.Mechanics.*;
public class Scenario {
    public int type;
    public int numPaths;
    public String Name;
    public String Description;
    public Scenario middlePath;
    public Scenario rightPath;
    public Scenario leftPath;
    boolean BBEGPresent;
    boolean BBEGPassed;
    public boolean completed;
    boolean foodGen;
    int foodAmount;

    public Scenario(int Type, String name){
        type = Type;
        Name = name;
        Description = null;
        numPaths = new Generate(3).int_random + 1;
        BBEGPresent = false;
        BBEGPassed = false;
        completed = false;
        foodGen= new Generate().coinFlip();
        foodAmount= new Generate(4,1).int_random;
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
//                "Scenario{" +
//                "type=" + type +
//                ", numPaths=" + numPaths +
//                ", middlePath=" + middlePath +
//                ", rightPath=" + rightPath +
//                ", leftPath=" + leftPath +
//                ", BBEGPresent=" + BBEGPresent +
//                ", BBEGPassed=" + BBEGPassed +
//                ", foodGen=" + foodGen +
//                ", foodAmount=" + foodAmount +
//                '}';
    }
}
