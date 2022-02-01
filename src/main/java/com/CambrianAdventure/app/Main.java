package com.CambrianAdventure.app;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;

public class Main{
    public static void main(String[] args){
//        String inputText = System.console().readLine();
//        System.out.println(inputText);
        Player Char = new Player();
        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        System.out.println(Char.Current);
        Char.Move("Right");
        System.out.println(Char.Current);
        Char.Move("Right");
        System.out.println(Char.Current);
        Char.Move("Right");
        System.out.println(Char.Current);
        Char.Move("Right");
        System.out.println(Char.Current);

    }
}