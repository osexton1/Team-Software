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
        
        public List<String> randDesc;
        
        public List<String> biomeType;
        
        public List<String> eventEvent;
        public List<String> eventPuzzle;
        public List<String> eventEncounter;
        
        public List<String> creatures;
        
        public List<String> numPaths;
        
        // prepping the below two for if we need them. If either are true, take
        // precedence over other random descriptors.
        public Hashtable<Boolean, String[]> BBEGpassed;
        //BBEG may need to be changed to Hunter (just a suggestion)
        public Hashtable<Boolean, String[]> BBEGpresent;
        
        public MyDictionaries() {
                // lists for biome-specific descriptions.
                List<String> randFrost = new ArrayList<>(Arrays.asList("The frosty waters have calmed slightly, but not to a point of comfort. The calcified remains of behemoths that couldn't handle the temperatures litter the seabed.",
                                                                       ""));
                List<String> randCaves = new ArrayList<>(Arrays.asList("You swim past a couple of narrow bends and come out into a large cavern. Scattered across the area are hundreds of small glowing jellyfish.",
                                                                       ""));
                List<String> randDeep = new ArrayList<>(Arrays.asList("",
                                                                      ""));
                List<String> randOpen = new ArrayList<>(Arrays.asList("As you swim forward, you gaze down below you into the depths, and for a moment you could've sworn the depths stared back.",
                                                                      "Suddenly a powerful ocean current sweeps across you and carries you quickly to new waters.",
                                                                     ""));
                List<String> randShallow = new ArrayList<>(Arrays.asList("The shallow waters of the tidepool become barren and empty, devoid of plant life or any other creatures. You are alone.",
                                                                         "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in the sediment.",
                                                                        ""));
                List<String> randMeadow = new ArrayList<>(Arrays.asList("",
                                                                        ""));
                List<String> randTrop = new ArrayList<>(Arrays.asList("You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in the sediment.",
                                                                      ""));
                List<String> randVolc = new ArrayList<>(Arrays.asList("A cloud of black smoke envelopes the waters just above you as a nearby geyser erupts spewing material into the sea. Many creatures are forced to the sea floor, like yourself.",
                                                                      ""));
                
                // generic descriptions list
                List<String> randDesc = new ArrayList<>(Arrays.asList("You come across the carcass of one of the Hunters. It sends chills down your back thinking about what manner of monstrosity left the bite mark on it's carapace.",
                                                                      ""));
                
                // biomeType List has replaced the roomType Hashtable. This has not been changed in other files cause I'm working from the github editor atm and can't be assed to do it across multiple browser tabs. This is pretty much the case for all other Hashtables :brainrot:
                // These are the initial biome entry descriptions. Use them in place of the random descriptions upon entering a new biome.
                // All the biomes are at their respective type index; 0-Frost 1-Cave 2-Deep 3-Open 4-Shallows 5-Meadows 6-Tropical 7-Volcano
                List<String> biomeType = new ArrayList<>(Arrays.asList("The landscape changes as you move forward." +
                    "\nThe waters you move through become noticeably cooler. Solid pillars of ice fill the landscape, floating just below the surface and piercing into the deep." +
                    "\nYou find yourself in the Frost Spires.",
                                                                      "The landscape changes as you move forward." +
                    "\nYou float deeper and deeper into the alcove as the sun disappears behind you. As the light fades, the cave becomes illuminated by the breathtaking colours emitted by the bioluminescent microbes." +
                    "\nYou find yourself in the Crystalline Caves",
                                                                      "The landscape changes as you move forward" +
                    "\nYou descend past the continental shelf and float down towards the deep. The ocean above you devours the sun as the darkness surrounds you." +
                    "\nYoy find yourself in the Deep Sea.",
                                                                      "The landscape changes as you move forward." +
                    "\nYou swim past the continental shelf and outwards to the great blue beyond. The vast waters lay open before you, as you get carried by the powerful currents." +
                    "\nYou find yourself in the Open Ocean",
                                                                      "The landscape changes as you move forward." +
                    "\nThe searing skies pierce through the water and illuminate the seabed, exposing vast reefs teeming with alien life.\" +\n" +
                    "\nYou find yourself in The Shallows.",
                                                                      "The landscape changes as you move forward." +
                    "\nThe environment reveals a vast open plain of sea grass. The sun gently kisses the flora as small and large creatures alike dive in and out of the seabed." +
                    "\nYou find yourself in the Ocean Meadows.",
                                                                      "The landscape changes as you move forward." +
                    "\nThe waters become warmer and more pleasant. The way opens forward to a vast network of coral reefs abundant with shoals of small creatures." +
                    "\nYou find yourself in Tropical Waters.",
                                                                      "The landscape changes as you move forward." +
                    "\nThe water becomes warm, almost hot. Ripples of rising currents extend before you as you gaze below. The seabed is scattered with volcanic activity, spewing magma and poisonous gasses into the ocean." +
                    "\nYou find yourself in the Volcanic Depths."));
                
                // worth conidering more scenario tells using the system Odhran thought up once
                // we have it working for these as well.
                List<String> eventEvent = new ArrayList<>(Arrays.asList("There is only one way forward. You will have to travel in that direction.",
                                                                       ""));
                List<String> eventPuzzle = new ArrayList<>(Arrays.asList("A chill passes down your carapace. This locale is particularly unique.",
                                                                       ""));
                List<String> eventEncounter = new ArrayList<>(Arrays.asList("You feel on edge. A quick scan of the area confirms your caution.",
                                                                       ""));
                
                List<String> creatures = new ArrayList<>(Arrays.asList("",
                                                                      ""));
                
                List<String> numPaths = new ArrayList<>(Arrays.asList("",
                                                                     "There is only one path forward for you to follow.",
                                                                     "There are two locations of interest ahead, you may only investigate one of them.",
                                                                     "There are three locations of interest ahead, you may only investigate one of them."));
                
                // see line 11
                BBEGpassed = new Hashtable<>();
                BBEGpresent = new Hashtable<>();
        }
}
