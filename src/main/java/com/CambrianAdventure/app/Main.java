package com.CambrianAdventure.app;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.exploration.Scenario;
import com.CambrianAdventure.app.exploration.Scenarios.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static MyDictionaries Dict;
    public static Player Char;
    public static Art Art;
    public static String gameState = "Intro";
    public static Layout Layout;
    public static boolean waitForInput;

    public static void main(String[] args) throws IOException, InterruptedException {

        setup();

        while (true) {
            while (waitForInput){
                Thread.sleep(100);
            }
            biomechangeDesc(Char.Current);
            if (Char.health <= 0) {
                Layout.setAscText(Art.death);
                Layout.setDesText("R.I.P.");
                break;
            }
            if(Char.Current.scenario.completed){
                //move on capabilities
                Layout.addDesText("\n\nScenario Completed");
                System.out.println("\nScenario Completed"); //### to do move on to next room capabilities
            }
            else {
                if (Objects.equals(gameState, "Encounter")) {
                    Layout.setAscText(Art.monster);
                    if (Objects.equals(Char.Current.scenario.State, "Pre")){//pre combat
                        roomdesc(Char.Current.scenario);
                        Char.Current.scenario.changeState();
                    }
                    else if (Objects.equals(Char.Current.scenario.State, "During")) {
                        //during combat
                        //enemy description probably needed
                        roomdesc(Char.Current.scenario);
                        Layout.addDesText(Char.combatMap());
                        Layout.addDesText("\n\n1. Inspect, 2. Advance, 3. Retreat, 4. Wait, 5. Attack");
                        Layout.addDesText("\n" + Char.Current.scenario.enemy);
                    }
                    else {
                        Layout.addDesText("You defeated the enemy");
                    }
                }
                else if (Objects.equals(gameState, "Event")) {
                    Layout.setAscText(Art.event);
                    Layout.addDesText("\nEvent");
                    Char.Current.scenario.completed = true;
                    roomdesc(Char.Current.scenario);
                    possInputs();
                }
                else if (Objects.equals(gameState, "Puzzle")) {
                    Layout.setAscText(Art.puzzle);
                    Layout.addDesText("\nPuzzle");
                    Char.Current.scenario.completed = true;
                    roomdesc(Char.Current.scenario);
                    possInputs();
                }
            }

//            if (Objects.equals(Char.roomCount, Char.Current.length) && Char.Current.scenario.completed) { //end of biome
//                Layout.addDesText("You completed the " + Char.Current.Name);
//                Char.Current.completed = true;
//                possInputs();
//                Char.Current.LoadRoom();
//                biomechangeDesc(Char.Current);
//            }
            waitForInput = true;
        }
    }



    public static void biomechangeDesc(Environment biome) {
        Layout.setDesText(Dict.roomType.get(0).get(biome.type));
    }

    //    note that it may not be necessary to split these methods. I'm just doing it this way at the moment
//    because that fits better with how I made the hashtables.
    public static void roomdesc(Scenario room) {
        //random descriptor
        if (room.Description == null) {
            room.Description = Dict.randdesc.get(Char.Current.type).get(new Generate(2).int_random);
        }
        Layout.addDesText("\n" + room.Description); //Used for Hashtables
        Layout.addDesText("\n" + Dict.NumPaths.get(room.numPaths));
    }

    public static void possInputs(){
        String printer = "\n1. Hide, 2. Inspect, 3. Eat, 4. Wait";
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
        Layout.addDesText("\n" + printer);

    }

    public static String Intro(String PC) {
        if (PC.equals("1") || PC.equals("2") || PC.equals("3")) {
            switch (PC) {
                case "1": return "Shelled";
                case "2": return "Finned";
                case "3": return "Spiked";
            }
        }
        return "Invalid Input";
    }

    public static void ChangeStates(){
        gameState = Char.Current.scenario.Name;
    }


    public static void Inputting(String input) {
        // 0. Character info, 1. move between, 2. wait, 3. hide, 4. inspect, 5. eat
        if (!input.equals("") && Integer.parseInt(input) >=  1 && Integer.parseInt(input) <= 5){
            Integer inputting = Integer.parseInt(input);
            switch(inputting){
                case 1: Char.Hide(); break;
                case 2: Char.Inspect(); break;
                case 3: Char.Eat(); break;
                case 4: Char.Wait(); break;
//                case 5: if (!Char.Current.completed && !Char.Current.scenario.completed){Char.EventAction();} else{MoveOn();}; break;
            }
        }
        else{
            Layout.setError("Invalid Input");
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
            Layout.addDesText("\n" + output);
//            String inputText = Scan.nextLine();
//            Integer inputNum = Integer.parseInt(inputText);
//            if (inputNum <= 3 && inputNum > 0) {
//                Char.Move(inputNum);
//            } else {
//                Layout.setError("Invalid Input");
//                MoveOn();
//            }
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
            Layout.addDesText("\n" + output);
//            String inputText = Scan.nextLine();
//            Integer inputNum = Integer.parseInt(inputText);
//            if (inputNum <= 3 && inputNum > 0) {
//                Char.Move(inputNum);
//            } else {
//                System.out.println("Invalid Input");
//                MoveOn();
//            }
        }
    }

    public static ActionListener InputListener(){
        return new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (Objects.equals(gameState, "Intro")) {
                    String playerClass = Intro(Layout.textInput.getText());
                    if (!playerClass.equals("Invalid Input")){
                        Char.setPlayerClass(playerClass);
                        Layout.err.setText("Option: " + Layout.textInput.getText() + ", " + playerClass + " picked");
                        ChangeStates();
                        Char.charDisplay();
                        waitForInput = false;
                    }
                    else{
                        Layout.setError("Invalid Input");
                    }

                }
                else if(Objects.equals(gameState, "Encounter")){
                    System.out.println("Encounter");
                    Char.combatInput(Layout.textInput.getText());
                    waitForInput = false;
                }
                else if(Objects.equals(gameState, "Puzzle")){
                    System.out.println("Puzzle");
                    Char.puzzleInput(Layout.textInput.getText());
                    waitForInput = false;
                }
                else if(Objects.equals(gameState, "Event")){
                    System.out.println("Event");
                    Char.eventInput(Layout.textInput.getText());
                    waitForInput = false;
                }

                Layout.textInput.setText("");
            }
        };
    }

    public static void setup(){
        Dict = new MyDictionaries(); //hashtable
        Art = new Art();
        Char = new Player();

        Layout = new Layout();
        Layout.textInput.addActionListener(InputListener());
        Layout.setDesText("Welcome to your Cambrian Adventure. In this text adventure game, you play as a creature as it navigates and tries to survive the Cambrian period.\n" +
                "Manage your health and food, take part in combat and solve puzzles. Try to survive as long as you can.\n");
        Layout.addDesText("Pick a class\n");
        Layout.addDesText("1. Shelled; 2. Finned; 3. Spiked\n");
        Layout.setAscText(Art.menu);

        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
        waitForInput = true;
    }
}