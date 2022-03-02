package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Marrella extends Creature{
    public Marrella() {
        super("Marrella", new Brawny());
        Integer temp;
        temp = new Generate(4,0).int_random;
        combatHealth = new Generate(14, 8).int_random;
        armorLevel = 0;
        spikeDamage = 0;
        attackDamage = 3;
        reach = 1;
        movementDistance = 2;
        Speed = 6;
        size = "S";
    }
}
