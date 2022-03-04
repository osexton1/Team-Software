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

        public List<String> puzzle01; 
        public List<String> puzzle02;
        public List<String> puzzle03;
        /**
         * we'll probably change these to a short desc as the name but for now numbers work
         * all of the puzzle lists will have 7 values
         * 0 - part 1
         * 1,2 - part 2
         * 3,4 - part 3, following index 1
         * 5,6 - part 3, following index 2
         */

        public Hashtable<Integer, List<String>> randdesc;
        public Hashtable<Integer, String> Events;
        public Hashtable<Integer, String> Creatures;
        public Hashtable<Integer, String> NumPaths;
        public Hashtable<Integer, List<String>> roomType;
        public Hashtable<Integer, List<String>> puzzleNum;

        // prepping the below two for if we need them. If either are true, take
        // precedence over other random descriptors.
        public Hashtable<Boolean, String[]> BBEGpassed;
        //BBEG may need to be changed to Hunter (just a suggestion)
        public Hashtable<Boolean, String[]> BBEGpresent;

        public MyDictionaries() {
                // lists for biome-specific descriptions.
                randdesc = new Hashtable<>();
                randFrost = new ArrayList<>(Arrays.asList(
                        "The frosty waters have calmed slightly, but the temperatures are still causing you discomfort. The calcified remains of the behemoths that couldn't survive the cold litter the seabed.",
                        "You circle around a large glacier as it breaks apart in the waters. Chunks of ice float past, making for good cover from predators.",
                        "A pane of glass-like ice covers the surface of the water here. The sunlight dims, and the outside world howls with wind sending resonating crackles through the glacial sheet."
                ));
                randCaves = new ArrayList<>(Arrays.asList(
                        "You swim past a couple of narrow bends and come out into a large cavern. Scattered across the area are hundreds of small glowing jellyfish.",
                        "The caves become extremely narrow and you're forced to squeeze to move ahead. Soon you emerge into a larger cavern, stalactites dip into the water from an air pocket above." ,
                        "As you move into the next cavern, the bioluminescent fauna disappears and darkness surrounds you. You have the uneasy feeling of being watched."
                ));
                randDeep = new ArrayList<>(Arrays.asList(
                        "The darkness of the crushing depths surround you. Gravity is the only thing that can tell you which way is up.",
                        "The sea floor here is barren and devoid of plant life. The compacted sand and skeletal remains of creatures are the only scenery in your limited vision.",
                        "You see a light in the shadows of the deep. It moves enticingly. It could be food, but you have more than enough experience to know that it is not to be trusted."
                ));
                randOpen = new ArrayList<>(Arrays.asList(
                        "As you swim forward, you gaze down below you into the depths, and for a moment you could've sworn the depths stared back.",
                        "Suddenly a powerful ocean current sweeps across you and carries you quickly to new waters. Not much has changed, but you are far from where you were before.",
                        "The waters here a clear and let you see for vast distances. Not that there's much to see other than the occasional jellyfish."
                ));
                randShallow = new ArrayList<>(Arrays.asList(
                        "The rocks are ever more beautiful, bejewelled by barnacle crowns.",
                        "The warm waters of the tidepool are pleasant. There is plenty of algae around, and other creatures are abound.",
                        "The tides recede for the day and pull you away from the tidepools. You find yourself in the shallows of the beach, algae litters your surroundings."
                ));
                randMeadow = new ArrayList<>(Arrays.asList(
                        "As you swim through the kelp forest of the meadow, you catch a moving shadow of something above you. It reminds you that this is where the Hunters reside. You are frozen in fear as it passes by.",
                        "You come across a graveyard of scavenged remains. The sea grass sways as the stench of death diffuses into the waters.",
                        "You stop in absolute terror as you run directly into one of the Hunters. It doesn't move, it hasn't seen you peaking between the algae yet. It merely lays there in the sand, resting. You work up enough courage and turn around and run. It doesn't chase. This place is a death trap."
                ));
                randTrop = new ArrayList<>(Arrays.asList(
                        "You come across a flatbed within the coral. The clearing is teeming with small critters foraging for food in the sediment.",
                        "You squeeze through some coral and eroded rock and emerge into a small clearing filled to the brim with small critters. They had flocked to the remains of a larger creature, which is all but eaten. Once they notice you, they scatter into the coral to hide.",
                        "The rays of light penetrate the waters here. It's warm and pleasant. Food and cover is abundant. Life is good in the tropics!"
                ));
                randVolc = new ArrayList<>(Arrays.asList(
                        "A cloud of black smoke envelopes the waters just above you as a nearby geyser erupts spewing material into the sea. Many creatures are forced to the sea floor, like yourself.",
                        "The sea shakes as the ground splits below you. Magma erupts upwards, solidifying as it boils the water. You narrowly avoid being cooked alive as you dash out of the way.",
                        "The murky waters here are searing hot to the touch. You are mostly fine at the moment, but you wonder how can anything survive down here for long?"
                ));
                randdesc.put(0, randFrost);
                randdesc.put(1, randCaves);
                randdesc.put(2, randDeep);
                randdesc.put(3, randOpen);
                randdesc.put(4, randShallow);
                randdesc.put(5, randMeadow);
                randdesc.put(6, randTrop);
                randdesc.put(7, randVolc);

//                GSMF - gain 2 food
//                GBGF - gain 4 food
//                LSMF - lose 4 food
//                LBGF - lose 8 food
//                LOHP - lose 1 hp
//                NTHN - nothing
//                FSMM - fight small mob
//                FMEM - fight med mob
//                FBGM - fight boss
//                DEAD - death

                puzzleNum = new Hashtable<>();
                puzzle01 = new ArrayList<>(Arrays.asList(
                        "Base Description\nPath 1 to desription, Path 2 to description",

                        "Option 1 description\nPath 1 to option 3, Path 2 to option 4",
                        "Option 2 description\nPath 1 to option 5, Path 2 to option 6",

                        "Option 3 description\nRoom complete",
                        "Option 4 description\nRoom complete",

                        "Option 5 description\nRoom complete",
                        "Option 6 description\nRoom complete"
                ));
                puzzle02 = new ArrayList<>(Arrays.asList(
                        "A soft fog surrounds you as you progress. As you wade through the murky waters, your vision gets cloudier, until the world is a harsh gray smoke.\n" +
                        "You hear something erupt where you were just moments ago, splitting the silence like a dagger. What do you do?\n",
                        "1.Swim down(1-1)\n",
                        "2.Swim up(1-2)\n",

                        "1-1: As you frantically attempt to reach the seafloor, the smoke penetrates your gills. Panic raising inside like a vice, more eruptions surround you,\n" +
                        "each a distant thunder through the haze. You begin to choke as a sudden burst clears the smoke off your side, the heat searing, for a split second.\n",
                        "1-2: The haze slowly grows more opaque as you dash upward, and you can now see the cause of the ash and heat. Blazing skyfire pierces through the fog at random, leaving a trail of bubbles in their wake. As you take in the sight before you, one rushes past you, the heat almost boiling the water. You are not safe yet.\n",
                        "1.Continue to the floor(1-3)\n",
                        "2.Take the chance the eruption provided(1-4)\n",

                        "1.Speed up(1-5)\n",
                        "2.Slow down(1-6)\n",

                        "1-3: You make a dash for the seafloor. Your vision continues to glaze over as the rising heat brings the water almost to a boil. Just as the fired water \n" +
                        "reaches unbearability and each crack of the eruptions threatens to deafen you, you slam into the sand. As you reassert yourself, your vision clears. Surrounding you are dozens of breaches in the seabed, each periodically catapulting streams of skyfire into the smoke above you, causing the deafening booms you've grown accustomed to. Clusters of soft-shelled quarry gather in the heat. You take the opportunity, before cautiously traversing the rest of the breaches. GBGF",
                        "1-4: Bursting through the haze, you see what caused the disruption, a bolt of skyfire catapulting into the distance. Desperately following to avoid the smoke, the heat grows unbearable. Unable to keep up the speed as exhaustion takes over, the sheer greyness encroaches yet again. As panic begins to take hold, a distant crack rumbles directly beneath yourself. Catapulted upwards, you breach the fog on the back of cooled skyfire. Battered and bloodied, you continue away from the fog as the eruptions get quieter and quieter. LOHP",
                        "1-5: Speeding up, you quickly reach a height where the bolts have stopped glowing entirely, and cruise through the water. Free from any threat you can continue at your own leisure. NTHN",
                        "1-6: You cautiously traverse the clearer waters, narrowly dodging the streaks of heat. The effort quickly exhausts you, and while you escape the barrage, you feel significantly drained. LBGF"));
                puzzle03 = new ArrayList<>(Arrays.asList(
                        "2-0: Driven to the seabed by the zealous Hunters above, you descend through the spiring flora. You stumble into a clearing. Swirled up in the epicentre, a long spiked giant sleeps. Surrounding it are half-eaten carcasses. What do you do?",
                        "1.Approach for an attempt to scavenge(2-1)\n",
                        "2.Take a wide berth(2-2)\n",
                        "2-1: Continuing into the clearing you hear the soft flow of water through the beast. The hum contrasts the grisly sight of its feeding ground; forgotten corpses, many larger than yourself, have stained the light sand a deep crimson, appendages and gore littering the reddened earth. A colossal shell-dweller, half-gouged, is what you decide on, and as you start picking at the body you hear a loud rustle in the flora, and see a distinct shifting in the sand.",
                        "2-2: You retreat back into the flora, and as it rustles around you, you begin to understand why the Giant picked this as its hunting grounds. Whisking through the weeds, you see an opportunity to scatter, lest you end up the giant's next kill.",
                        "1.Bolt for the weeds(2-3)\n",
                        "2.Stick with your scavenge(2-4)\n",
                        "1.Risk the open ocean(2-5)\n",
                        "2.Risk the seabed(2-6)\n",
                        "2-3: You instantly make for the reeds, and the Giant turns towards you. A gaping maw of shattered glass flanked by two large hooks are the only recognisable feature on the being's armoured head. It coils up and launches its maw towards you, and everything goes dark. DEAD",
                        "2-4: You watch the Giant unwrap it's serpentine body sending the sand into a spiral as it launches it's enormous head at the source of the rustling. The rest of the body slowly catches up as it coils up once again, raising its head into the sky. Wedged between its jaw of shattered glass is a young Hunter, still squirming, until a sharp bite stops the throes. You waste no time. Devouring as much of the succulent shell-dweller as possible, you scatter, glamoured by the sheer power of the Giant. GBGF",
                        "2-5: Leaving the death-trap behind you, you take to the dunes. While the shadows of the Hunters above continue to circle the area, none approach, and you quickly make your leave. NTHN",
                        "2-6: Fearing the Hunters more than the Giant, you continue to skulk through the weeds. Senses open for any potential motion from the clearing, you hear soft rustling ahead of you. Taking inspiration from the earlier threat, you stalk after the rustling. FSMM"
                ));
                puzzleNum.put(1, puzzle01);
                puzzleNum.put(2, puzzle02);
                puzzleNum.put(3, puzzle03);

                Events = new Hashtable<>();
                Creatures = new Hashtable<>();
                BBEGpassed = new Hashtable<>();
                BBEGpresent = new Hashtable<>();


                NumPaths = new Hashtable<>();
                NumPaths.put(1, "There is only one path forward for you to follow.");
                NumPaths.put(2, "There are two locations of interest ahead, you may only investigate one of them.");
                NumPaths.put(3, "There are three locations of interest ahead, you may only investigate one of them.");


                // These are the initial biome entry descriptions. Use them in place of the random descriptions upon entering a new biome.
                // All the biomes are at their respective type index; 0-Frost 1-Cave 2-Deep 3-Open 4-Shallows 5-Meadows 6-Tropical 7-Volcano
                roomType = new Hashtable<>();
                biomeType = new ArrayList<>(Arrays.asList(
                                "The landscape changes as you move forward."
                        + "\nThe waters you move through become noticeably cooler. Solid pillars of ice fill the landscape, floating just below the surface and piercing into the deep."
                        + "\nYou find yourself in the Frost Spires.",
                                "The landscape changes as you move forward."
                        + "\nYou float deeper and deeper into the alcove as the sun disappears behind you. As the light fades, the cave becomes illuminated by the breathtaking colours emitted by the bioluminescent microbes."
                        + "\nYou find yourself in the Crystalline Caves",
                                "The landscape changes as you move forward"
                        + "\nYou descend past the continental shelf and float down towards the deep. The ocean above you devours the sun as the darkness surrounds you."
                        + "\nYoy find yourself in the Deep Sea.",
                                "The landscape changes as you move forward."
                        + "\nYou swim past the continental shelf and outwards to the great blue beyond. The vast waters lay open before you, as you get carried by the powerful currents."
                        + "\nYou find yourself in the Open Ocean",
                                "The landscape changes as you move forward."
                        + "\nThe searing skies pierce through the water and illuminate the seabed, exposing vast reefs teeming with alien life."
                        + "\nYou find yourself in The Shallows.",
                                "The landscape changes as you move forward."
                        + "\nThe environment reveals a vast open plain of sea grass. The sun gently kisses the flora as small and large creatures alike dive in and out of the seabed."
                        + "\nYou find yourself in the Ocean Meadows.",
                                "The landscape changes as you move forward."
                        + "\nThe waters become warmer and more pleasant. The way opens forward to a vast network of coral reefs abundant with shoals of small creatures."
                        + "\nYou find yourself in Tropical Waters.",
                                "The landscape changes as you move forward."
                        + "\nThe water becomes warm, almost hot. Ripples of rising currents extend before you as you gaze below. The seabed is scattered with volcanic activity, spewing magma and poisonous gasses into the ocean."
                        + "\nYou find yourself in the Volcanic Depths."
                        ));
                roomType.put(0,biomeType);

                eventEvent = new ArrayList<>(Arrays.asList(
                                "There is only one way forward. You will have to travel in that direction.",
                                ""
                        ));
                eventPuzzle = new ArrayList<>(Arrays.asList(
                                "A chill passes down your carapace. This locale is particularly unique.",
                                ""
                        ));
                eventEncounter = new ArrayList<>(Arrays.asList(
                                "You feel on edge. A quick scan of the area confirms your caution.",
                                ""
                        ));

                creatures = new ArrayList<>(Arrays.asList(
                                "",
                                ""
                        ));
        }
}
