package com.CambrianAdventure.app;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.exploration.Scenario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player Char = new Player();
        Char.Current = new Shallows();
        Char.Current.LoadBiomes();
        Char.Current.LoadRoom();
        while (true) {
            // Char.Current.scenario.completed = true;
            // System.out.println(Char.Current);
            // pathBiomes(Char);

            // System.out.println(Char.Current.scenario);
            pathRooms(Char);

            // String inputText = System.console().readLine();
            Scanner myObj = new Scanner(System.in);
            String inputText = myObj.nextLine(); // Read user input
            Inputting(Char, inputText);
        }
    }

    public static void biomechangeDesc(Scenario room) {
        MyDictionaries Dict = new MyDictionaries(); // hashtable
        System.out.println(Dict.roomType.get(room.type));
        System.out.println(Dict.NumPaths.get(room.numPaths));
    }

    // note that it may not be necessary to split these methods. I'm just doing it
    // this way at the moment
    // because that fits better with how I made the hashtables.
    public static void roomdesc(Scenario room) {
        MyDictionaries Dict = new MyDictionaries();
        System.out.println(Dict.randdesc.get(0));
        if (room.completed) {
            System.out.println(Dict.NumPaths.get(room.numPaths));
            // if this should be elsewhere just move it
        }

    }

    public static void pathRooms(Player Char) {
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

    public static void pathBiomes(Player Char) {
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

    public static void Inputting(Player Char, String input) {

        if (Char.Current.completed) {
            Char.Move(input, false);
        }
        if (Char.Current.scenario.completed) {
            Char.Move(input, true);
        } else {
            System.out.println(input);
        }
    }
}