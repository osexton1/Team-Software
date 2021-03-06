package com.CambrianAdventure.app;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.enemies.Anomalocaris;
import com.CambrianAdventure.app.exploration.Scenario;
import com.CambrianAdventure.app.exploration.Scenarios.Encounter;

import java.io.File;
import java.io.FileWriter;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
    public static MyDictionaries Dict;
    public static Player Char;
    public static Anomalocaris Hunter;
    public static boolean hunterPresent;
    public static Art Art;
    public static String gameState = "Intro";
    public static Layout Layout;
    public static boolean LevelUp;
    public static boolean waitForInput;
    public static boolean combatChange;
    public static boolean moveOn;
    public static int score = 0;
    public static ActionListener Listener;
    public static boolean FirstFight = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        setup();
        while (true) {
            while (waitForInput) {
                Thread.sleep(100);
            }
            Layout.setDesText("");
            Layout.setFooterText("");
            if (Char.roomCount == 1) {
                biomechangeDesc(Char.Current);
            }
            if (Char.health <= 0) {
                Char.charDisplay();
                Layout.textInput.removeActionListener(Listener);
                Layout.setAscText(Art.death);
                Layout.setDesText("You ran out of food and starved to death\n");
                score = (Char.globalRoomCount * 50) + (Char.evolutionLevel * 200);
                Layout.addDesText("Your score was: " + score + "\n");
                try {
                    File scoreFile = new File("HighScore.txt");
                    if (scoreFile.createNewFile()) {
                        FileWriter scoreWriter = new FileWriter("HighScore.txt");
                        scoreWriter.write( String.valueOf(score));
                        scoreWriter.close();
                    } else {
                        Scanner scoreReader = new Scanner(scoreFile);
                        while (scoreReader.hasNextLine()) {
                            int highScore = Integer.parseInt(scoreReader.nextLine());
                            if (score > highScore) {
                                FileWriter scoreWriter = new FileWriter("HighScore.txt");
                                scoreWriter.write( String.valueOf(score));
                                scoreWriter.close();
                            } else {
                                Layout.addDesText("You did not beat the high score\n");
                                Layout.addDesText("The high score is: " + highScore);
                            }
                        }
                    }
                } catch (IOException e) {}
                break;
            }
            else if (Char.Current.scenario == null){
                Char.Current.LoadRoom();
                biomechangeDesc(Char.Current);
            }
            else if (LevelUp){
                Layout.setDesText("You Levelled up by completing a biome\n");
                Layout.addDesText("Pick an attribute to increase\n");
                Layout.setFooterText("1. Combat Health\n");
                Layout.addFooterText("2. Max Food Level\n");
                Layout.addFooterText("3. Attack Damage\n");
                Layout.addFooterText("4. Combat Speed\n");
                Layout.addFooterText("5. Spike Damage\n");
                Layout.addFooterText("6. Armor Level\n");
            }
            else if ((Char.roomCount == Char.Current.length) && Char.Current.scenario.completed) { //end of biome
                Layout.setDesText("You completed the " + Char.Current.Name);
                Char.Current.completed = true;
                if (!moveOn) {
                    hunterMove();
                    possInputs();
                }
                else if(moveOn){
                    possMove();
                }
            }
            else {
                if (Objects.equals(Char.Current.scenario.Name, "Encounter")) {
                    if (hunterPresent) {
                        Char.Current.scenario.enemy = Hunter;
                    }
                    if (Char.Current.scenario.enemy.name == "Hymenocaris") {
                        Layout.setAscText(Art.hymenocaris);
                    } else {
                        Layout.setAscText(Art.monster);
                    }
                    if (Objects.equals(Char.Current.scenario.State, "Pre")){//pre combat
                        Char.hidden = false;
                        if (Char.roomCount != 1) {
                            Layout.setDesText("");
                        }
                        Char.disToFlee = 2;
                        Char.combatHealth = Char.maxCombatHealth;
                        roomdesc(Char.Current.scenario);
                        Layout.addDesText("\n" + Dict.eventEncounter.get(0));
                        if (Char.Current.scenario.enemy.name.equals("Hunter")) {
                            Layout.addDesText("\nTo your horror; there is a Hunter in this area. You could hide or attempt to face it. All your instincts scream: \"RUN\"");
                        }
                        else {
                            Layout.addDesText("\nThere seems to be a wild " + Char.Current.scenario.enemy.name + " moving slowly through the area.");
                        }
                        possInputs();
                    }
                    else if (Objects.equals(Char.Current.scenario.State, "During")) {
                        if (hunterPresent) {
                            hunterPresent = false;
                            Hunter.combatHealth = 120;
                            Hunter.tUntilMove = 3;
                            Hunter.distanceBehind = 2;
                        }
                        //during combat
                        //enemy description probably needed
//                        roomdesc(Char.Current.scenario);
                        String output;
                        if (Char.Current.scenario.enemy.name.equals("Hunter")) {
                            output = "Your eyes lock with the Hunter's. There is no escape.";
                        }
                        else {
                            output = "The " + Char.Current.scenario.enemy.name + " turns towards you and locks eyes with you.";
                        }
                        switch(Char.Current.scenario.enemy.personality.Name){
                            case "Rabid":
                                if (Char.Current.scenario.enemy.name.equals("Hunter")) {
                                    output += "\nThe Hunter exists only to kill. It will not retreat.";
                                }
                                else {
                                    output += "\nIt seems very aggressive.\n";
                                }
                                break;
                            case "Brawny": output += "\nIt seems slightly aggressive towards you.\n"; break;
                            case "Neutral": output += "\nIt seems indecisive towards fighting you.\n"; break;
                            case "Shy": output += "\nIt seems sheepish.\n"; break;
                            case "Fearful": output += "\nIt seems avoidant.\n"; break;
                        }
                        Layout.setDesText(output);
                        Layout.addDesText(Char.Current.scenario.enemy.description);
                        Layout.addDesText(Char.combatMap());
                        Layout.setFooterText("\n\n1. Inspect the enemy\n");
                        Layout.addFooterText("2. Advance towards the enemy\n");
                        Layout.addFooterText("3. Retreat away from the enemy\n");
                        Layout.addFooterText("4. Wait for the enemy to do something\n");
                        Layout.addFooterText("5. Attack the spot in front of you");

                        if (FirstFight){
                            Layout.tutorial();
                            FirstFight = false;
                        }
//                        Layout.addDesText("\n" + Char.Current.scenario.enemy);
                    }
                    else {
                        if (Char.hidden){
                            Layout.setDesText("You avoided the enemy " + Char.Current.scenario.enemy.name + ".");
                            if ((hunterPresent) && (Char.Current.scenario.enemy.name == "Hunter")) {
                                hunterPresent = false;
                                Hunter.combatHealth = 120;
                                Hunter.tUntilMove = 3;
                                Hunter.distanceBehind = 2;
                            }
                        }
                        else if (Char.disToFlee <= 0) {
                            Layout.setDesText("You fled the battlefield");
                        }
                        else if (Char.combatHealth <= 0){
                            Layout.setDesText("You lost the fight against the enemy " + Char.Current.scenario.enemy.name + ", and it ran away.");
                        }
                        else if (Char.Current.scenario.enemy.disToFlee <= 0) {
                            Layout.setDesText("The enemy " + Char.Current.scenario.enemy.name + " fled the battlefield");
                        }
                        else if (Char.Current.scenario.enemy.combatHealth <= 0){
                            Layout.setDesText("You killed the enemy " + Char.Current.scenario.enemy.name + ".");
                        }
                        Layout.addDesText("\n\n" + Dict.NumPaths.get(Char.Current.scenario.numPaths));
                        Char.charDisplay();
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
                    int Path = Char.Current.scenario.Path;
                    String output = Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path);
                    if (Char.Current.scenario.Path > 5) {//string splicing
                        output = Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path).substring(0, output.length() - 5);
                        if (!moveOn) {
                            possInputs();
                        } else if (moveOn) {
                            possMove();
                        }
                    } else if (Path == 0) {
                        Layout.addFooterText("\n" + Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 1));
                        Layout.addFooterText("\n" + Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 2));
                        int counter = 3;
                        if ((Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 3)) != "" && (Char.playerClass == "Shelled")){
                            Layout.addFooterText("\n" + Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 3));
                        }
                        if ((Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 4)) != "" && (Char.playerClass == "Finned")){
                            Layout.addFooterText("\n" + Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 4));
                        }
                        if ((Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 5) != "") && (Char.playerClass == "Spiked")){
                            Layout.addFooterText("\n" + Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Path + 5));
                        }
                    }
                    Layout.addDesText(output);
                }
                else if (Objects.equals(gameState, "Puzzle")) {
                    Layout.setAscText(Art.puzzle);
                    String output = Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path);
                    if(Char.Current.scenario.Path > 8){//string splicing
                        output = Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).substring(0, output.length()-5);
                        if (!moveOn) {
                            possInputs();
                        }
                        else if(moveOn){
                            possMove();
                        }
                    }
                    else if(Char.Current.scenario.Path == 0){
                        Layout.addFooterText("\n" + Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path+1));
                        Layout.addFooterText(Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path+2));}
                    else if (Char.Current.scenario.Path == 3){
                        Layout.addFooterText("\n" +Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path+2));
                        Layout.addFooterText(Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path+3));
                    }
                    else if (Char.Current.scenario.Path == 4) {
                        Layout.addFooterText("\n" +Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path+3));
                        Layout.addFooterText(Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path+4));
                    }

                    Layout.addDesText(output);

                }
            }
            waitForInput = true;
        }
    }

    public static void biomechangeDesc(Environment biome) {
        Layout.setDesText(Dict.roomType.get(0).get(biome.type)+ "\n\n");
    }

    public static void roomdesc(Scenario room) {
        //random descriptor
        if (room.Description == null) {
            room.Description = Dict.randdesc.get(Char.Current.type).get(new Generate(2).int_random);
        }
        Layout.addDesText(room.Description); //Used for Hashtable
    }

    public static void possInputs(){
        String printer = "\n1. Hide from possible violent enemies\n2. Inspect the surrounding area\n3. Eat food from the room\n4. Wait for something to happen";

        if (Char.Current.completed || Char.Current.scenario.completed){
            printer += "\n5. Move Onward ";
        }
        Layout.setFooterText("\n" + printer);

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
                switch (inputting) {
                    case 1:
                        hunterMove();
                        Char.Hide();
                        Char.Current.scenario.foodAmount = 0;
                        Char.Current.scenario.foodGen = false;
                        Char.Current.scenario.changeState();
                        combatChange = true;
                        Char.Current.scenario.completed = true;
                        break;
                    case 2:
                        hunterMove();
                        if (!Char.Current.scenario.completed) {
                            combatChange = true;
                        }
                        else {
                            Char.Inspect();
                            ChangeStates();
                        }
                        break;
                    case 3:  //cant eat till enemy defeated?
                        hunterMove();
                        if(!Char.Current.scenario.completed) {
                            combatChange = true;
                            Layout.setError("The enemy attacked before you could eat the food");
                        }
                        else {
                            Char.Eat();
                        }
                        break;
                    case 4:
                        hunterMove();
                        if (!Char.Current.scenario.completed) {
                            combatChange = true;
                        }
                        else {
                            Char.Wait();
                            ChangeStates();
                        }
                        break;
                    case 5:
                        if (Char.Current.completed || Char.Current.scenario.completed){
                            hunterMove();
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
        Layout.setFooterText("");
        if (hunterPresent) {
            Char.Current.scenario.middlePath = new Encounter();
            if (Char.Current.scenario.leftPath != null) {
                Char.Current.scenario.leftPath = new Encounter();
            }
            if (Char.Current.scenario.rightPath != null) {
                Char.Current.scenario.rightPath = new Encounter();
            }
        }
        if (Char.Current.completed){
            String output = "Enter a number to move to a new Biome: \n1. " + Char.Current.middlePath.Name;
            if (Char.Current.leftPath != null) {
                output += "\n2. " + Char.Current.leftPath.Name;
            }
            if (Char.Current.rightPath != null) {
                output += "\n3. " + Char.Current.rightPath.Name;
            }
            output += "";
            Layout.setFooterText("\n" + output);
        }
        else {
            String output = "Enter a number to move to a new Room: \n1. " + Char.Current.scenario.middlePath.Name;
            if (Char.Current.scenario.leftPath != null) {
                output += "\n2. " + Char.Current.scenario.leftPath.Name;
            }
            if (Char.Current.scenario.rightPath != null) {
                output += "\n3. " + Char.Current.scenario.rightPath.Name;
            }
            output += "";
            Layout.setFooterText("\n" + output);
        }
    }

    public static void hunterMove() {
        if (Hunter.distanceBehind > 0) {
            if (Hunter.tUntilMove > 0) {
                Hunter.tUntilMove -= 1;
            }
            else {
                Hunter.tUntilMove = 3;
                Hunter.distanceBehind -= 1;
            }
        } else {
            hunterPresent = true;
        }
    }

    public static ActionListener InputListener(){
        Listener = e -> {
            Layout.setError("");
            String Action = Layout.textInput.getText();
            if(LevelUp){
                try {
                    int intAction = Integer.parseInt(Action);
                    if (intAction > 0 && intAction < 7) {
                        switch (intAction) {
                            //1. Combat Health, 2. Max Food Level, 3. Attack Damage, 4. Combat Speed, 5. Spike Damage, 6. Armor Level
                            case 1:
                                Char.maxCombatHealth += 3;
                                Char.combatHealth += 3;
                                break;
                            case 2:
                                Char.maxFood += 3;
                                Char.food += 3;
                                break;
                            case 3:
                                Char.attackDamage += 1;
                                break;
                            case 4:
                                Char.Speed += 1;
                                break;
                            case 5:
                                Char.spikeDamage += 1;
                                break;
                            case 6:
                                Char.armorLevel += 1;
                                break;
                        }
                        Char.charDisplay();
                        Char.evolutionLevel += 1;
                        Layout.setFooterText("");
                        waitForInput = false;
                        LevelUp = false;
                    }
                    else{
                        Layout.setError("Invalid Input for Level up");
                    }
                }
                catch(Throwable Error){
                    Layout.setError("Invalid Input");
                }
            }
            else if(moveOn){
                try {
                    int intAction = Integer.parseInt(Action);
                    if (Char.Current.completed){
                        LevelUp = true;
                    }
                    Char.Move(intAction);
                    moveOn = false;
                    Hunter.distanceBehind += 1;
                    waitForInput = false;
                    gameState = Char.Current.scenario.Name;
                }
                catch(Throwable Error){
                    Layout.setError("Invalid Input");
                }
            }
            else if (Objects.equals(gameState, "Intro")) {
                String playerClass = Intro(Action);
                if (!playerClass.equals("Invalid Input")){
                    Char.setPlayerClass(playerClass);
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
                if (Objects.equals(Char.Current.scenario.State, "After")){
                    Inputting(Action);
                    waitForInput = false;
                }
                else {
                    if (Objects.equals(Action, "1") || Objects.equals(Action, "2")) {
                        Char.puzzleInput(Action);

                        hunterMove();
                        waitForInput = false;
                        if (Char.Current.scenario.Path > 5) {//string splicing
                            String outcome = Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).substring(Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).length() - 4, Dict.puzzleNum.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).length());
                            if (!Char.Current.scenario.completed) {
                                Char.Current.scenario.completed = true;
                                Char.Current.scenario.State = "After";
                                Char.genPuzOut(outcome);
                                ChangeStates();
                            }
                        }
                    } else {
                        Layout.setError("Invalid Input");
                    }
                }
            }
            else if(Objects.equals(gameState, "Event")){
                if (Objects.equals(Char.Current.scenario.State, "After")){
                    Inputting(Action);
                    waitForInput = false;
                }
                else {
                    if (Objects.equals(Action, "1") || Objects.equals(Action, "2") || Objects.equals(Action, "3")) {
                        Char.eventInput(Layout.textInput.getText());
                        hunterMove();
                        waitForInput = false;
                        if (Char.Current.scenario.Path > 5) {//string splicing
                            String outcome = Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).substring(Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).length() - 4, Dict.Events.get(Char.Current.scenario.PuzzleNum).get(Char.Current.scenario.Path).length());
                            if (!Char.Current.scenario.completed) {
                                Char.Current.scenario.completed = true;
                                Char.Current.scenario.State = "After";
                                Char.genEveOut(outcome);
                                ChangeStates();
                            }
                        }
                    } else {
                        Layout.setError("Invalid Input");
                    }
                }
            }

            Layout.textInput.setText("");
        };
        return Listener;
    }

    public static void setup(){
        Dict = new MyDictionaries(); //hashtable
        Art = new Art();
        Char = new Player();
        Hunter = new Anomalocaris();

        Layout = new Layout();
        Layout.textInput.addActionListener(InputListener());
        Layout.setDesText("Welcome to your Cambrian Adventure. In this text adventure game, you play as a creature as it navigates and tries to survive the Cambrian period.\n" +
                "Manage your health and food, take part in combat and solve puzzles. Try to survive as long as you can.\n");
        Layout.setFooterText("Pick a class, each class can do special abilities depending on the scenario.\n");
        Layout.addFooterText("1. Shelled - +1 to Armor, -1 to Combat Speed.\n");
        Layout.addFooterText("2. Finned - +1 to Combat Speed.\n");
        Layout.addFooterText("3. Spiked - Deals 1 damage when hit.\n");
        Layout.setAscText(Art.menu);

        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
        waitForInput = true;
    }
}