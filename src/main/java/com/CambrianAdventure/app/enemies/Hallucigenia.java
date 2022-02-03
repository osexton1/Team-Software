package com.CambrianAdventure.app.enemies;

import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Hallucigenia extends Creature {
    public Persona personality;
    public Hallucigenia() {
        super("Hallucigenia");
        personality = new Brawny();
    }
}
