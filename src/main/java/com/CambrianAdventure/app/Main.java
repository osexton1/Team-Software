package com.CambrianAdventure.app;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Player Char = new Player();
        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
        while(true) {
            System.out.println(Char.Current.scenario);
            pathRooms(Char);

//            Char.Current.scenario.completed = true;
            MyDictionaries Dict = new MyDictionaries(); //Used for Hashtables
            System.out.println(Dict.randdesc.get(0)); //Used for Hashtables
//            System.out.println(Char.Current);
//            pathBiomes(Char);

//        String inputText = System.console().readLine();
//            Scanner myObj = new Scanner(System.in);
//            String inputText = myObj.nextLine();  // Read user input
//            Inputting(Char, inputText);
        }
    }
    public static void pathRooms(Player Char){
        String output = "Enter a number for a room to travel to: (1. " + Char.Current.scenario.middlePath.Name;
        if (Char.Current.scenario.leftPath != null) {
            output += "/2. " + Char.Current.scenario.leftPath.Name;
        }
        if (Char.Current.scenario.rightPath != null){
            output += "/3. " + Char.Current.scenario.rightPath.Name;
        }
        output += ")";
        System.out.println(output);
    }

    public static void pathBiomes(Player Char){
        String output = "Enter a number for a biome to travel to: (1. " + Char.Current.middlePath.Name;
        if (Char.Current.leftPath != null) {
            output += "/2. " + Char.Current.leftPath.Name;
        }
        if (Char.Current.rightPath != null){
            output += "/3. " + Char.Current.rightPath.Name;
        }
        output += ")";
        System.out.println(output);
    }

    public static void Inputting(Player Char, String input){

        if (Char.Current.completed){
            Char.Move(input, false);
        }
        if (Char.Current.scenario.completed){
            Char.Move(input, true);
        }
        else {
            System.out.println(input);
        }
    }
}