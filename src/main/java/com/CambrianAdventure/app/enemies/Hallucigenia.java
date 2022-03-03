package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Hallucigenia extends Creature {
    public Hallucigenia() {
        super("Hallucigenia", new Generate(16, 8).int_random); //randomize the personality
        armorLevel = 0;
        spikeDamage = 2;
        attackDamage = 2;
        reach = 1;
        movementDistance = 1;
        Speed = 2;
        description = "Be careful of its spikes";
    }
}
