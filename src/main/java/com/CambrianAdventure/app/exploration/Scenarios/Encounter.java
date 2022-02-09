package com.CambrianAdventure.app.exploration.Scenarios;

import com.CambrianAdventure.app.enemies.*;
import com.CambrianAdventure.app.exploration.Scenario;

public class Encounter extends Scenario {
    protected Creature enemy;
    public Encounter(){
        super(2, "Encounter");
        this.enemy = new Hallucigenia();
    }
}
