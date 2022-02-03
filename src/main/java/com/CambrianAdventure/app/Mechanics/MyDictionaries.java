package com.CambrianAdventure.app.Mechanics;

import java.util.*;

public class MyDictionaries {
        public List<String> randFrost;
        public List<String> randCaves;
        public List<String> randDeep;
        public List<String> randOpen;
        public List<String> randShallow;
        public List<String> randMeadow;
        public List<String> randTrop;
        public List<String> randVolc;
        
        public Hashtable<Integer, String> randdesc;
        public Hashtable<Integer, String> Events;
        public Hashtable<Integer, String> Creatures;
        public Hashtable<Integer, String> NumPaths;
        public Hashtable<Integer, String> roomType;
        // prepping the below two for if we need them. If either are true, take
        // precedence over other random descriptors.
        public Hashtable<Boolean, String[]> BBEGpassed;
        public Hashtable<Boolean, String[]> BBEGpresent;

        public MyDictionaries() {
                List<String> randFrost = new ArrayList<>(Arrays.asList("",""));
                List<String> randCaves = new ArrayList<>(Arrays.asList("",""));
                List<String> randDeep = new ArrayList<>(Arrays.asList("",""));
                List<String> randOpen = new ArrayList<>(Arrays.asList("",""));
                List<String> randShallow = new ArrayList<>(Arrays.asList("",""));
                List<String> randMeadow = new ArrayList<>(Arrays.asList("",""));
                List<String> randTrop = new ArrayList<>(Arrays.asList("",""));
                List<String> randVolc = new ArrayList<>(Arrays.asList("",""));

                randdesc = new Hashtable<>();
                Events = new Hashtable<>();
                Creatures = new Hashtable<>();
                NumPaths = new Hashtable<>();
                roomType = new Hashtable<>();
                // see line 11
                BBEGpassed = new Hashtable<>();
                BBEGpresent = new Hashtable<>();

                // use these for generic descriptors. I will get around to writing more biome
                // specific ones.
                randdesc.put(0, "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in the sediment.");
                randdesc.put(1, "The frosty waters have calmed slightly, but not to a point of comfort. The remains of behemoths that couldn't handle the temperatures litter the seabed.");
                randdesc.put(2, "A cloud of black smoke envelopes the waters just above you as a nearby geyser erupts spewing material into the sea. Many creatures are forced to the sea floor, like yourself.");
                randdesc.put(3, "You swim past a couple of narrow bends and come out into a large cavern. Scattered across the area are hundreds of small glowing jellyfish.");
                randdesc.put(4, "You come across the carcass of the Predator. It sends chills down your back thinking about what manner of monstrosity left the bite mark on it's carapace.");
                randdesc.put(5, "As you swim forward, you gaze down below you into the depths, and for a moment you could've sworn the depths stared back.");
                randdesc.put(6, "Suddenly a powerful ocean current sweeps across you and carries you quickly to new waters.");
                randdesc.put(7, "The shallow waters of the tidepool become barren and empty, devoid of plant life or any other creatures. You are alone.");

                // worth conidering more scenario tells using the system Odhran thought up once
                // we have it working for these as well.
                Events.put(0, "An oddity in the distance catches your eye."); // event
                Events.put(1, "A chill passes down your exoskeleton. This locale is particularly unique."); // puzzle
                Events.put(2, "You feel on edge. A quick scan of the area confirms your caution."); // encounter

                NumPaths.put(0, "There is only one way forward. You will have to travel in that direction.");
                NumPaths.put(1, "There are two locations of interest ahead, you may only investigate one of them.");
                NumPaths.put(2, "There are three locations of interest ahead, you may only investigate one of them.");

                // These are the initial biome entry descriptions. Use them in place of the
                // generic room descriptions for biome changes.
                roomType.put(0, "The landscape changes as you move forward." +
                                "\nThe waters you move through become noticeably cooler. Solid pillars of ice fill the landscape, floating just below the surface and piercing into the deep."
                                +
                                "\nYou find yourself in the Frost Spires.");
                roomType.put(1, "The landscape changes as you move forward." +
                                "\nYou float deeper and deeper into the alcove as the sun disappears behind you. As the light fades, the cave becomes illuminated by the breathtaking colours emitted by the bioluminescent microbes."
                                +
                                "\nYou find yourself in the Crystalline Caves");
                roomType.put(2, "The landscape changes as you move forward" +
                                "\nYou descend past the continental shelf and float down towards the deep. The ocean above you devours the sun as the darkness surrounds you."
                                +
                                "\nYoy find yourself in the Deep Sea.");
                roomType.put(3, "The landscape changes as you move forward." +
                                "\nYou swim past the continental shelf and outwards to the great blue beyond. The vast waters lay open before you, as you get carried by the powerful currents."
                                +
                                "\nYou find yourself in the Open Ocean");
                roomType.put(4, "The landscape changes as you move forward." +
                                "\nThe searing skies pierce through the water and illuminate the seabed, exposing vast reefs teeming with alien life.\" +\n"
                                +
                                "\nYou find yourself in The Shallows.");
                roomType.put(5, "The landscape changes as you move forward." +
                                "\nThe environment reveals a vast open plain of sea grass. The sun gently kisses the flora as small and large creatures alike dive in and out of the seabed."
                                +
                                "\nYou find yourself in the Ocean Meadows.");
                roomType.put(6, "The landscape changes as you move forward." +
                                "\nThe waters become warmer and more pleasant. The way opens forward to a vast network of coral reefs abundant with shoals of small creatures."
                                +
                                "\nYou find yourself in Tropical Waters.");
                roomType.put(7, "The landscape changes as you move forward." +
                                "\nThe water becomes warm, almost hot. Ripples of rising currents extend before you as you gaze below. The seabed is scattered with volcanic activity, spewing magma and poisonous gasses into the ocean."
                                +
                                "\nYou find yourself in the Volcanic Depths.");
        }
}