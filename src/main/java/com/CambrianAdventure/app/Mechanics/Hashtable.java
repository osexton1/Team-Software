package com.CambrianAdventure.app.Mechanics;
import java.util.*;

class My_Dictionaries {
    public static void main(String[] args) {

        Hashtable<Integer, String> randdesc = new Hashtable<Integer, String>();
        randdesc.put(0, "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in thew sediment.");
        randdesc.put(1, "The frosty waters have calmed slightly, but not to a point of comfort. The remains of behemoths that couldn't handle the temperatures litter the seabed.");

        Hashtable<Integer, String> Events = new Hashtable<Integer, String>();
        Events.put(0, "Event - Something feels different.");
        Events.put(1, "Puzzle - May the luck be with you.");
        Events.put(2, "Encounter - There appears to be a large shadow darkening the room.");

        Hashtable<Integer, String> NumPaths = new Hashtable<>();
        NumPaths.put(1, "There is only one exit out of the room. You will have to take it and travel that direction.");
        NumPaths.put(2, "There are two exits from the room. You may only follow one, and not the other.");
        NumPaths.put(3, "There are three possible exits from the room. You will have to pick one and follow your instincts");
    }
}

