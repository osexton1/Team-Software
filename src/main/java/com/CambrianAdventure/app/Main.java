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
            System.out.println(Char.Current);
            String output = "Enter a number for a direction to travel: (1. " + Char.Current.middlePath.Name;
            if (Char.Current.leftPath != null) {
                output += "/2. " + Char.Current.leftPath.Name;
            }
            if (Char.Current.rightPath != null){
                output += "/3. " + Char.Current.rightPath.Name;
            }
            output += ")";
            System.out.println(output);

//        String inputText = System.console().readLine();
            Scanner myObj = new Scanner(System.in);

            String inputText = myObj.nextLine();  // Read user input
            Inputting(Char, inputText);
        }
    }
    public static void Inputting(Player Char, String input){

        if (Char.Current.completed){
            Char.Move(input);
        }
        else {
            System.out.println(input);
        }
    }
}