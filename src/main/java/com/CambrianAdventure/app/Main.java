package com.CambrianAdventure.app;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.exploration.Scenario;
import com.CambrianAdventure.app.exploration.Scenarios.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static MyDictionaries Dict;
    public static Scanner Scan;
    public static Player Char;
    public static Art Art;
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("\033[H\033[2J");  // clear console
        System.out.flush();
//        if (OS.contains("mac")) {
//            Process p = Runtime.getRuntime().exec("open -n -F -a /Applications/Utilities/Terminal.app --args ls");
//            p.waitFor();
//        }
//        else if (OS.contains("win")) {
//            Process p1 = Runtime.getRuntime().exec("cmd /c start cmd.exe"); // launch terminal first
//            p1.waitFor();;
//        }
//        else if (OS.contains("nix") || (OS.contains("nux")) || (OS.contains("aix"))){
//            System.out.println("Linux");
//        }
        Dict = new MyDictionaries(); //hashtable
        Scan = new Scanner(System.in);
        System.out.println("Welcome to your Cambrian Adventure. In this text adventure game, you play as a creature as it navigates and tries to survive the Cambrian period.");
        System.out.println("Manage your health and food, take part in combat and solve puzzles. Try to survive as long as you can\n");
        Art = new Art();
        System.out.println(Art.menu);
        Integer playerClass = Intro();
        Char = new Player(playerClass);
        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
        Char.combat = true;
        biomechangeDesc(Char.Current);
        while (true) {
            System.out.print("\033[H\033[2J");  // clear console
            System.out.flush();
            if (Char.health <= 0) {
                System.out.println("Death");
                break;
            }
            Char.WorldLevel(); //numbers of rooms and biomes
//            Char.Current.scenario.completed = true;
//            System.out.println(Char.Current);
            if (Char.Current.scenario instanceof Encounter && Char.combat){
                System.out.println(Art.monster);

                //enemy description
                roomdesc(Char.Current.scenario);
                Char.goToCombat(Scan);
            }
            else {
                if(Objects.equals(Char.roomCount, Char.Current.length)){
                    System.out.println("You completed the " + Char.Current.Name);
                    Char.Current.completed = true;

                    possInputs();
                    String inputText = Scan.nextLine();  // Read user input
                    Inputting(inputText);

                    Char.Current.LoadBiomes();
                    Char.Current.LoadRoom();
                    biomechangeDesc(Char.Current);
                }
                else {
                    System.out.println(Char.Current.scenario.Name);
                    Char.Current.scenario.completed = true;
                    roomdesc(Char.Current.scenario);
                    possInputs();
                    String inputText = Scan.nextLine();  // Read user input
                    Inputting(inputText);
                }
            }
        }
    }

    public static void biomechangeDesc(Environment biome) {
        System.out.println(Dict.roomType.get(0).get(biome.type));
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
        // 0. Character info, 1. move between, 2. wait, 3. hide, 4. inspect, 5. eat
        if (!input.equals("") && Integer.parseInt(input) >=  0 && Integer.parseInt(input) <= 5){
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
        if (Char.Current.completed){
            String output = "Enter a number to move to a new Biome: (1. " + Char.Current.middlePath.Name;
            if (Char.Current.leftPath != null) {
                output += "/2. " + Char.Current.leftPath.Name;
            }
            if (Char.Current.rightPath != null) {
                output += "/3. " + Char.Current.rightPath.Name;
            }
            output += ")";
            System.out.println(output);
            String inputText = Scan.nextLine();
            Integer inputNum = Integer.parseInt(inputText);
            if (inputNum <= 3 && inputNum > 0) {
                Char.Move(inputNum);
            } else {
                System.out.println("Invalid Input");
                MoveOn();
            }
        }
        else {
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
            if (inputNum <= 3 && inputNum > 0) {
                Char.Move(inputNum);
            } else {
                System.out.println("Invalid Input");
                MoveOn();
            }
        }
    }
}