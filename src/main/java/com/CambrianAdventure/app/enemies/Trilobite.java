package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Trilobite extends Creature{
    public Trilobite() {
        super("Trilobite", new Neutral(), new Generate(44, 17).int_random);
        armorLevel = 3;
        spikeDamage = 0;
        attackDamage = 4;
        reach = 1;
        movementDistance = 1;
        Speed = 2;
    }
}
