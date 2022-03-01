package com.CambrianAdventure.app;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.exploration.Scenario;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public class Main {
    public static MyDictionaries Dict;
    public static Player Char;
    public static Art Art;
    public static String gameState = "Intro";
    public static Layout Layout;
    public static boolean LevelUp;
    public static boolean waitForInput;
    public static boolean combatChange;
    public static boolean moveOn;
    public static void main(String[] args) throws IOException, InterruptedException {
        setup();
        while (true) {
            while (waitForInput) {
                Thread.sleep(100);
            }
            biomechangeDesc(Char.Current);
            if (Char.health <= 0) {
                Layout.setAscText(Art.death);
                Layout.setDesText("R.I.P.");
                break;
            }
            else if (Char.Current.scenario == null){
                Char.Current.LoadRoom();
                biomechangeDesc(Char.Current);
            }
            else if (LevelUp){
                Layout.setDesText("You Levelled up by completing a biome\n");
                Layout.addDesText("Pick an attribute to increase\n");
                Layout.addDesText("1. Combat Health, 2. Max Food Level, 3. Attack Damage, 4. Combat Speed, 5. Spike Damage, 6. Armor Level\n");


            }
            else if (Objects.equals(Char.roomCount, Char.Current.length) && Char.Current.scenario.completed) { //end of biome
                Layout.addDesText("You completed the " + Char.Current.Name);
                Char.Current.completed = true;
                if (!moveOn) {
                    possInputs();
                }
                else if(moveOn){
                    possMove();
                }
            }
            else {
                if (Char.Current.scenario.Name == "Encounter") {
                    Layout.setAscText(Art.monster);
                    if (Objects.equals(Char.Current.scenario.State, "Pre")){//pre combat
                        roomdesc(Char.Current.scenario);
                        Layout.addDesText("\n" + Dict.eventEncounter.get(0));
                        possInputs();
                    }
                    else if (Objects.equals(Char.Current.scenario.State, "During")) {
                        //during combat
                        //enemy description probably needed
                        roomdesc(Char.Current.scenario);
                        Layout.addDesText(Char.combatMap());
                        Layout.addDesText("\n\n1. Inspect the enemy, 2. Advance towards the enemy, 3. Retreat away from the enemy, 4. Wait for the enemy to do something, 5. Attack the spot in front of you");
                        Layout.addDesText("\n" + Char.Current.scenario.enemy);
                    }
                    else {
                        System.out.println("Move on");
                        Layout.addDesText("You defeated the enemy");
                        Layout.addDesText("\n\n" + Dict.NumPaths.get(Char.Current.scenario.numPaths));
                        if (!moveOn) {
                            possInputs();
                        }
                        else if(moveOn){
                            possMove();
                        }
                    }
                }
                else if (Objects.equals(gameState, "Event")) {
                    Layout.setAscText(Art.event);
                    Layout.addDesText("\nEvent");

//                    Char.Current.scenario.completed = true;
//                    roomdesc(Char.Current.scenario);
//                    possInputs();
                }
                else if (Objects.equals(gameState, "Puzzle")) {
                    Layout.setAscText(Art.puzzle);
                    Layout.addDesText("\nPuzzle");
                    Layout.addDesText("\n" + Dict.puzzleNum.get(1).get(Char.Current.scenario.Path));
//                    Char.Current.scenario.completed = true;
//                    roomdesc(Char.Current.scenario);
//                    possInputs();
                }
            }
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
        Layout.addDesText("\n" + room.Description); //Used for Hashtable
    }

    public static void possInputs(){
        String printer = "\n1. Hide from possible violent enemies, 2. Eat food from the room, 3. Inspect the surrounding area, 4. Wait for something to happen";
        if (Char.Current.completed || Char.Current.scenario.completed){
            printer += ", 5. Move Onward ";
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
        try {
            if (!input.equals("") && Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 5) {
                int inputting = Integer.parseInt(input);
                Layout.setError("Option: " + inputting + ". " + " picked");
                switch (inputting) {
                    case 1:
                        Char.Hide();
                        combatChange = true;
                        break;
                    case 2:
                        Char.Eat();
                        break;
                    case 3:
                        Char.Inspect();
                        combatChange = true;
                        break;
                    case 4:
                        Char.Wait();
                        combatChange = true;
                        break;
                    case 5:
                        if (Char.Current.completed || Char.Current.scenario.completed){
                            moveOn = true;
                        }
                        else{
                            Layout.setError("Invalid Input");
                        }
                        break;
                }
            }
            else {
                Layout.setError("Invalid Input");
            }
        }
        catch(Throwable Error){
            Layout.setError("Invalid Input");
        }
    }

    public static void possMove(){
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
        }
        else {
            String output = "Enter a number to move to a new Room: (1. " + Char.Current.scenario.middlePath.Name;
            if (Char.Current.scenario.leftPath != null) {
                output += "/2. " + Char.Current.scenario.leftPath.Name;
            }
            if (Char.Current.scenario.rightPath != null) {
                output += "/3. " + Char.Current.scenario.rightPath.Name;
            }
            output += ")";
            Layout.addDesText("\n" + output);
        }
    }

    public static ActionListener InputListener(){
        return e -> {
            Layout.setError("");
            String Action = Layout.textInput.getText();
            if(LevelUp){
                try {
                    int intAction = Integer.parseInt(Action);
                    switch (intAction) {
                        //1. Combat Health, 2. Max Food Level, 3. Attack Damage, 4. Combat Speed, 5. Spike Damage, 6. Armor Level
                        case 1:
                            Char.combatHealth += 1;
                            break;
                        case 2:
                            Char.maxFood += 1;
                            break;
                        case 3:
                            Char.attackDamage += 1;
                            break;
                        case 4:
                            Char.movementSpeed += 1;
                            break;
                        case 5:
                            Char.spikeDamage += 1;
                            break;
                        case 6:
                            Char.armorLevel += 1;
                            break;
                    }
                    LevelUp = false;
                }
                catch(Throwable Error){

                }
            }
            if(moveOn){
                try {
                    int intAction = Integer.parseInt(Action);
                    if (Char.Current.completed){
                        LevelUp = true;
                    }
                    Char.Move(intAction);
                    waitForInput = false;
                    moveOn = false;

                }
                catch(Throwable Error){
                    System.out.println("please");
                }
            }
            else if (Objects.equals(gameState, "Intro")) {
                String playerClass = Intro(Action);
                if (!playerClass.equals("Invalid Input")){
                    Char.setPlayerClass(playerClass);
                    Layout.err.setText("Option: " + Action + ", " + playerClass + " picked");
                    ChangeStates();
                    Char.charDisplay();
                    waitForInput = false;
                }
                else{
                    Layout.setError("Invalid Input");
                }
            }
            else if(Objects.equals(gameState, "Encounter")){
                if(Objects.equals(Char.Current.scenario.State, "Pre")){
                    Inputting(Action);
                }
                else if(Objects.equals(Char.Current.scenario.State, "During")){
                    Char.combatInput(Action);
                }
                else if(Objects.equals(Char.Current.scenario.State, "After")){
                    Inputting(Action);
                }

                if(combatChange) {
                    Char.Current.scenario.changeState();
                    combatChange = false;
                }
                waitForInput = false;
            }
            else if(Objects.equals(gameState, "Puzzle")){
                if (Objects.equals(Action, "1") || Objects.equals(Action, "2")) {
                    Char.puzzleInput(Action);
                    waitForInput = false;
                }
                else{
                    Layout.setError("Invalid Input");
                }
            }
            else if(Objects.equals(gameState, "Event")){
                System.out.println("Event");
                Char.eventInput(Layout.textInput.getText());
                waitForInput = false;
            }

            Layout.textInput.setText("");
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
        Layout.addDesText("Pick a class, each class can do special abilities depending on the scenario\n");
        Layout.addDesText("1. Shelled;\t2. Finned;\t3. Spiked\n");
        Layout.addDesText("    - +1 to Armor                 - +1 to Combat speed                 - Deals 1 damage when hit\n");
        Layout.addDesText("    - -1 to combat Speed\n");
        Layout.setAscText(Art.menu);

        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
        waitForInput = true;
    }
}