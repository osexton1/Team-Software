package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Isoxys extends Creature{
    public Isoxys() {
        super("Isoxys", new Generate(21, 16).int_random);
        armorLevel = 1;
        spikeDamage = 0;
        attackDamage = 2;
        reach = 1;
        movementDistance = 2;
        Speed = 6;
    }
}
