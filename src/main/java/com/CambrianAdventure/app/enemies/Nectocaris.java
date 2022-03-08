package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Nectocaris extends Creature{
    public Nectocaris() {
        super("Nectocaris", new Generate(32, 20).int_random);
        armorLevel = 0;
        spikeDamage = 0;
        attackDamage = 6;
        reach = 2;
        movementDistance = 1;
        Speed = 5;
    }
}
