package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Hallucigenia extends Creature {
    public Hallucigenia() {
        super("Hallucigenia", new Rabid()); //randomize the personality
    }
}
