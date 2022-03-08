package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.Mechanics.Generate;
import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.exploration.Scenario;

public class Encounter extends Scenario {
    public Encounter(){
        super(2, "Encounter");
        enemy = new Generate().GenerateEnemy();
    }
    public Encounter(Creature Enemy){
        super(2, "Encounter");
        enemy = Enemy;
    }
}
