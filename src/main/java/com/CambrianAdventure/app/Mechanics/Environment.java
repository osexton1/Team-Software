package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.enemies.*;

public class Environment {
    public String Descript;
    public Enemy Enemy;
    public int type;
    public Environment leftPath;
    public Environment rightPath;

    public Environment(String description, int Type, Enemy enemy) {
        Descript = description;
        type = Type;
        Enemy = enemy;
        leftPath = null;
        rightPath = null;
    }

    public String toString(){
        String output = "You are currently located in a " + Descript + ", there is a " + Enemy;
        if(leftPath != null){
            output += "\nahead of you to your left, there is a " + leftPath.Descript + " and there seems to be a " + leftPath.Enemy;
        }
        if(rightPath != null){
            output += "\nahead of you to your right, there is a " + rightPath.Descript + " and there seems to be a " + rightPath.Enemy;
        }
        return output;

    }

    public void LoadBiomes(){
        Generate Generator = new Generate();
        leftPath = Generator.GenerateBiome(type);
        rightPath = Generator.GenerateBiome(type);
    }

}
