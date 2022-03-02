package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Hallucigenia extends Creature {
    public Hallucigenia() {
        super("Hallucigenia", new Rabid(), 10); //randomize the personality
        spikeDamage = 2;
        description = "spiky boi, be careful of its defensive spikes";
    }
}
