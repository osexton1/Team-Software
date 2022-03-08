package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Hymenocaris extends Creature{
    public Hymenocaris() {
        super("Hymenocaris", new Generate(15, 9).int_random);
        armorLevel = 2;
        spikeDamage = 0;
        attackDamage = 2;
        reach = 1;
        movementDistance = 1;
        Speed = 2;
    }
}
