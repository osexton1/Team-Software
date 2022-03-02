package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.exploration.Scenario;

public class Encounter extends Scenario {
    public Encounter(){
        super(2, "Encounter");
        /*
        this is temporary just to make sure creatures get randomised. This needs to still;
        1. get weighted so larger creatures only get generated if the player is larger.
        2. get weighted for biomes/rooms.
        3. probably get weighted for population, but this isn't necessary.
        */
        Integer temp = new Generate(11, 1).int_random;
        switch (temp) {
            case 1: enemy = new Aysheaia();
            case 2: enemy = new Hallucigenia();
            case 3: enemy = new Hellcionelloida();
            case 4: enemy = new Hymenocaris();
            case 5: enemy = new Isoxys();
            case 6: enemy = new Marrella();
            case 7: enemy = new Nectocaris();
            case 8: enemy = new Opabinia();
            case 9: enemy = new Trilobite();
            case 10: enemy = new Waptia();
            case 11: enemy = new Wiwaxia();
        }
    }
}
