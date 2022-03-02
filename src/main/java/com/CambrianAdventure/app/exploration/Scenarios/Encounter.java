package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.exploration.Scenario;

public class Encounter extends Scenario {
    public Encounter(){
        super(2, "Encounter");
        Integer temp = new Generate(11, 1).int_random;
        switch (temp) {
            case 1: enemy = new Aysheaia(); break;
            case 2: enemy = new Hallucigenia(); break;
            case 3: enemy = new Hellcionelloida(); break;
            case 4: enemy = new Hymenocaris(); break;
            case 5: enemy = new Isoxys(); break;
            case 6: enemy = new Marrella(); break;
            case 7: enemy = new Nectocaris(); break;
            case 8: enemy = new Opabinia(); break;
            case 9: enemy = new Trilobite(); break;
            case 10: enemy = new Waptia(); break;
            case 11: enemy = new Wiwaxia(); break;
        }
    }
}
