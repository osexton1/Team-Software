package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Anomalocaris extends Creature{
    public Integer tUntilMove = 3;
    public Integer distanceBehind = 1; // for testing. Should be 5

    public Anomalocaris() {
        super("Hunter", 120);
        personality = new Rabid();
        combatHealth = 120;
        armorLevel = 5;
        spikeDamage = 0;
        attackDamage = 25;
        reach = 2;
        movementDistance = 2;
        Speed = 8;
    }
}
