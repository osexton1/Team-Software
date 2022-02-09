package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

public class Hallucigenia extends Creature {
    public Integer disToPlayer;
    public Integer disToFlee;

    public Hallucigenia() {
        super("Hallucigenia", new Brawny());
        disToPlayer = new Generate(5, 2).int_random;

    }
}
