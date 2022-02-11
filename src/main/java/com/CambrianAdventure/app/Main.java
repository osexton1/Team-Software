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
        System.out.println("Welcome to your Cambrian Adventure. In this text adventure game, you play as a creature as it navigates and tries to survive the Cambrian period.\nManage your health and food, take part in combat and solve puzzles. Try to survive as long as you can\n");
        Integer playerClass = Intro();
        Char = new Player(playerClass);
        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
//        if(Type(Char.Current.scenario) == Encounter)

        while (true) {
            if (Char.health <= 0) {
                System.out.println("Death");
                break;
            }
            Char.WorldLevel(); //numbers of rooms and biomes
            Char.Current.scenario.completed = true;
//            System.out.println(Char.Current);

            roomdesc(Char.Current.scenario);

//        String inputText = System.console().readLine();
            possInputs();
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
        if (room.Description == null) {
            room.Description = Dict.randdesc.get(Char.Current.type).get(new Generate(3).int_random);
        }
        System.out.println(room.Description); //Used for Hashtables
        System.out.println(Dict.NumPaths.get(room.numPaths));
    }

    public static void possInputs(){
        String printer = "0. Player Info, 1. Hide, 2. Inspect, 3. Eat, 4. Wait";
        int counter = 5;
        if (!Char.Current.completed && !Char.Current.scenario.completed){ printer += ", " + counter + ". attack/puzzle action"; counter +=1;}
        else{
            if (Char.Current.scenario.completed) {
                printer += ", " + counter + ". Move Onward ";
            }
            else{
                printer += ", " + counter + ". Move Onward ";
            }
        }
        System.out.println(printer);

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
        if (Integer.parseInt(input) >=  0 && Integer.parseInt(input) <= 5){
            Integer inputting = Integer.parseInt(input);
            switch(inputting){
                case 0: Char.characterInfo(); break;
                case 1: Char.Hide(); break;
                case 2: Char.Inspect(); break;
                case 3: Char.Eat(); break;
                case 4: Char.Wait(); break;
                case 5: if (!Char.Current.completed && !Char.Current.scenario.completed){Char.EventAction();} else{MoveOn();}; break;
            }
        }
        else{
            System.out.println("Invalid Input");
        }
    }
    public static void MoveOn(){
        String output = "Enter a number to move to a new location: (1. " + Char.Current.scenario.middlePath.Name;
        if (Char.Current.scenario.leftPath != null) {
            output += "/2. " + Char.Current.scenario.leftPath.Name;
        }
        if (Char.Current.scenario.rightPath != null) {
            output += "/3. " + Char.Current.scenario.rightPath.Name;
        }
        output += ")";
        System.out.println(output);
        String inputText = Scan.nextLine();
        Integer inputNum = Integer.parseInt(inputText);
        if (inputNum <= 3 && inputNum > 0){
            Char.Move(inputNum);
        }
        else{
            System.out.println("Invalid Input");
            MoveOn();
        }
    }
}