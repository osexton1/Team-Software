package com.CambrianAdventure.app.Mechanics;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Hashtable<v,k> extends Dictionary<v,k> implements Map<v,k>, Cloneable, Serializable {
    public Hashtable(){
        Hashtable<Integer, String> randdesc = new Hashtable<Integer, String>();
        randdesc.put(1, "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in thew sediment.");
        randdesc.put(2, "The frosty waters have calmed slightly, but not to a point of comfort. The remains of behemoths that couldn't handle the temperatures litter the seabed.");
           
    }
}
    
