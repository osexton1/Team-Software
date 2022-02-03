package com.CambrianAdventure.app;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.exploration.Scenario;
import java.util.Scanner;

public class Main {
    public static MyDictionaries Dict;
    public static Scanner Scan;
    public static Player Char;

    public static void main(String[] args) {
        Dict = new MyDictionaries(); //hashtable
        Scan = new Scanner(System.in);
        System.out.println("Probably want a description of what the game is about up here");
        Integer playerClass = Intro();
        Char = new Player(playerClass);
        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();

        while (true) {
            Char.WorldLevel();
            Char.Current.scenario.completed = true;
//            System.out.println(Char.Current);
//            pathBiomes(Char);

//            System.out.println(Char.Current.scenario);
            roomdesc(Char.Current.scenario);
            pathRooms();

//        String inputText = System.console().readLine();
            String inputText = Scan.nextLine();  // Read user input
            Inputting(inputText);
        }
    }

    public static void biomechangeDesc(Scenario room) {
        System.out.println(Dict.roomType.get(room.type));
        System.out.println(Dict.NumPaths.get(room.type));
    }

    //    note that it may not be necessary to split these methods. I'm just doing it this way at the moment
//    because that fits better with how I made the hashtables.
    public static void roomdesc(Scenario room) {
        //random descriptor
        System.out.println(Dict.randdesc.get(new Generate(8).int_random)); //Used for Hashtables
        System.out.println(Dict.NumPaths.get(room.numPaths));
    }

    public static void pathRooms() {
        String output = "Enter a number to move to a new location: (1. " + Char.Current.scenario.middlePath.Name;
        if (Char.Current.scenario.leftPath != null) {
            output += "/2. " + Char.Current.scenario.leftPath.Name;
        }
        if (Char.Current.scenario.rightPath != null) {
            output += "/3. " + Char.Current.scenario.rightPath.Name;
        }
        output += ")";
        System.out.println(output);
    }

    public static void pathBiomes() {
        String output = "Enter a number to move to a new location: (1. " + Char.Current.middlePath.Name;
        if (Char.Current.leftPath != null) {
            output += "/2. " + Char.Current.leftPath.Name;
        }
        if (Char.Current.rightPath != null) {
            output += "/3. " + Char.Current.rightPath.Name;
        }
        output += ")";
        System.out.println(output);
    }

    public static Integer Intro() {
        System.out.println("Pick a class");
        System.out.println("1. Shelled; 2. Finned; 3. Spiked");
        String PC = Scan.nextLine();
        if (PC.equals("1") || PC.equals("2") || PC.equals("3")) {
            return Integer.parseInt(PC) - 1;
        }//do thing
        else {
            System.out.println("Invalid Choice");
            return Intro();
        }
    }

    public static void Inputting(String input) {
        // 0. Character info, 1. move between, 2. wait, 3. hide, 4. inspect, 5. eat, 6.
        if (Integer.parseInt(input) >=  0){
            Integer inputting = Integer.parseInt(input);
            if (Char.Current.completed){
                switch(inputting){
                case 0: Char.characterInfo(); break;
                case 1:
                case 2:
                case 3: Char.Move(input, false); break;
                case 4: ; break;
                case 5: ; break;
                case 6: ; break;
                case 7: ; break;
                case 8: ; break;
                case 9: ; break;
                }
            }
            switch (inputting) {
                case 0: Char.characterInfo(); break;
                case 1: if (Char.Current.completed){Char.Move(input, false);}
                    else if (Char.Current.scenario.completed){Char.Move(input, true);}
                    else {System.out.println("default things like eat, wait");}
                case 2:
                case 3: ; break;
                case 4: ; break;
                case 5: ; break;
                case 6: ; break;
                case 7: ; break;
                case 8: ; break;
                case 9: ; break;
            }

        }
        else{
            System.out.println("Invalid Input");
        }
    }
}