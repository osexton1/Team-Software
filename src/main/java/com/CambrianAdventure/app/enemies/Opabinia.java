package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Opabinia extends Creature{
    public Opabinia() {
        super("Opabinia", new Rabid(), new Generate(26, 13).int_random);
        armorLevel = 0;
        spikeDamage = 0;
        attackDamage = 6;
        reach = 2;
        movementDistance = 1;
        Speed = 4;
    }
}
