package com.CambrianAdventure.app;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.exploration.*;
import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.combat.*;

public class Main{
    public static void main(String[] args){
        System.out.println("Welcome to Cambrian Adventure!\ncool");
        EnviromentBase t = new EnviromentBase("beach", "hallucigenia");
        t.setup();
        String inputText = System.console().readLine();
        System.out.println(inputText);
        Generate test = new Generate();
        System.out.println(test.GenerateBiome(2));
    }
}