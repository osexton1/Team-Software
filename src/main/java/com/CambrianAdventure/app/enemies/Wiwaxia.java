package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Wiwaxia extends Creature{
    public Wiwaxia() {
        super("Wiwaxia", new Shy(), 22);
        combatHealth = new Generate(22, 12).int_random;
        armorLevel = 2;
        spikeDamage = 0;
        attackDamage = 1;
        reach = 1;
        movementDistance = 1;
        Speed = 1;
    }
}
