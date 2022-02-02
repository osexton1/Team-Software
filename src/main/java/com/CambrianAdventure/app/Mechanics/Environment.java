package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.exploration.*;
import com.CambrianAdventure.app.exploration.*;


public class Environment {
    public String Name;
    public Scenario scenario;
    public int type;
    public int numPaths;
    public Environment leftPath;
    public Environment middlePath;
    public Environment rightPath;
    public Boolean completed;

    public Environment(String Description, int Type) {
        Name = Description;
        type = Type;
        scenario = null;
        leftPath = null;
        middlePath = null;
        rightPath = null;
        completed = false;
    }

    public String toString(){
        String output = "\nYou are currently located in a " + Name + ", there is a " + scenario;
        if(middlePath != null) {
            output += "\nstraight ahead of you, there is a " + middlePath.Name;
        }
        if(leftPath != null){
            output += "\nahead of you to your left, there is a " + leftPath.Name;
        }
        if(rightPath != null){
            output += "\nahead of you to your right, there is a " + rightPath.Name;
        }
        return output;

    }

    public void LoadBiomes(){
        Generate Generator = new Generate();
        numPaths = Generator.Paths();//generate int number of paths
        if (numPaths > 1){
            rightPath = Generator.GenerateBiome(type);
        }
        if (numPaths > 0){
            leftPath = Generator.GenerateBiome(type);
        }
        middlePath = Generator.GenerateBiome(type);
    }
    public void LoadRoom(){
        Generate Generator = new Generate();//generate path room types
        if (scenario == null){
            scenario = Generator.GenerateRoom(1);
        }
        if (scenario.numPaths > 2){
            scenario.rightPath = Generator.GenerateRoom(scenario.type);
        }
        if (scenario.numPaths > 1){
            scenario.leftPath = Generator.GenerateRoom(scenario.type);
        }
        scenario.middlePath = Generator.GenerateRoom(scenario.type);

    }
}
