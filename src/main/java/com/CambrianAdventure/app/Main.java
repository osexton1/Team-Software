package com.CambrianAdventure.app;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;

public class Main{
    public static void main(String[] args){
//        String inputText = System.console().readLine();
//        System.out.println(inputText);
        // Generate test = new Generate(); // used for randomizing the next zone
        // System.out.println(test.GenerateBiome(2));
        Player Char = new Player();
        Environment Beach = new Beach();

        System.out.println(Beach);
        Char.Move();

    }
}