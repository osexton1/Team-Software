package com.CambrianAdventure.app.Mechanics;
import java.util.*;
import java.io.*;
import java.lang.*;

class My_Dictionaries {
    public static void main(String[] args) {

        Hashtable<Integer, String> randdesc = new Hashtable<Integer, String>();
        randdesc.put(1, "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in the sediment.");
        randdesc.put(2, "The frosty waters have calmed slightly, but not to a point of comfort. The remains of behemoths that couldn't handle the temperatures litter the seabed.");

        Hashtable<Integer, String> Events = new Hashtable<Integer, String>();
        Events.put(0, "Something feels unusual in this area. You feel that if you take a closer look around you will discover something.");
        Events.put(1, "Some sort of brain teaser lies ahead. May the odds be ever in your favour.");
        Events.put(2, "There appears to be a large shadow darkening the room. You are unsure what exactly it is, but you know for sure it will be dangerous.");

        Hashtable<Integer, String> NumPaths = new Hashtable<>();
        NumPaths.put(1, "There is only one exit out of the room. You will have to take it and travel that direction.");
        NumPaths.put(2, "There are two exits from the room. You may only follow one, and not the other.");
        NumPaths.put(3, "There are three possible exits from the room. You will have to pick one and follow your instincts");

    }
}

