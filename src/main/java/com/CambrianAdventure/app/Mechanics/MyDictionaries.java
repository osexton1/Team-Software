package com.CambrianAdventure.app.Mechanics;
import java.util.*;

public class MyDictionaries {
    public Hashtable<Integer, String> randdesc;
    public Hashtable<Integer, String> Events;
    public Hashtable<Integer, String> NumPaths;

    public MyDictionaries() {
        randdesc = new Hashtable<>();
        Events = new Hashtable<>();
        NumPaths = new Hashtable<>();
        
        randdesc.put(0, "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in the sediment.");
        randdesc.put(1, "The frosty waters have calmed slightly, but not to a point of comfort. The remains of behemoths that couldn't handle the temperatures litter the seabed.");
        Events.put(0, "Something feels unusual in this area. You feel that if you take a closer look around you will discover something.");
        Events.put(1, "Some sort of brain teaser lies ahead. May the odds be ever in your favour.");
        Events.put(2, "There appears to be a large shadow darkening the room. You are unsure what exactly it is, but you know for sure it will be dangerous."); 
        NumPaths.put(0, "There is only one exit out of the room. You will have to take it and travel that direction.");
        NumPaths.put(1, "There are two exits from the room. You may only follow one, and not the other.");
        NumPaths.put(2, "There are three possible exits from the room. You will have to pick one and follow your instincts");
 
    }
}