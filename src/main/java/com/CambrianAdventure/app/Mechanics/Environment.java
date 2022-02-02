package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.Mechanics.MyDictionaries;

public class Environment {
    public String Descript;
    public Enemy Enemy;
    public int biome;
    public Environment leftPath;
    public Environment rightPath;

    public Environment(String description, int Biome, Enemy enemy) {
        Descript = description;
        biome = Biome;
        Enemy = enemy;
        leftPath = null;
        rightPath = null;
    }

    public String toString(){
        // String output = "You are currently located in a " + Descript + ", there is a " + Enemy;
        // if(leftPath != null){
        //     output += "\nahead of you to your left, there is a " + leftPath.Descript + " and there seems to be a " + leftPath.Enemy;
        // }
        // if(rightPath != null){
        //     output += "\nahead of you to your right, there is a " + rightPath.Descript + " and there seems to be a " + rightPath.Enemy;
        // }
        
        String output = "";
        output += randdesc.get(1);
        return output;
    }

    public void LoadBiomes(){
        Generate Generator = new Generate();
        leftPath = Generator.GenerateBiome(biome);
        rightPath = Generator.GenerateBiome(biome);
    }

}
