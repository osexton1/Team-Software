package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Aysheaia extends Creature{
    public Aysheaia() {
        super("Aysheaia", new Shy(), 11);
        combatHealth = new Generate(11, 7).int_random;
        armorLevel = 0;
        spikeDamage = 0;
        attackDamage = 1;
        reach = 1;
        movementDistance = 1;
        Speed = 4;
    }
}