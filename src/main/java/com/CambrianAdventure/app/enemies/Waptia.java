package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Waptia extends Creature{
    public Waptia() {
        super("Waptia", new Neutral());
        combatHealth = new Generate(22, 16).int_random;
        armorLevel = 1;
        spikeDamage = 0;
        attackDamage = 4;
        reach = 1;
        movementDistance = 1;
        Speed = 4;
        size = "M";
    }
}
