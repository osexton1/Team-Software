package com.CambrianAdventure.app.Mechanics.Environments;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Hallucigenia;

public class Beach extends Environment {
    public Beach(){
        super("Sandy Beach", 0, new Hallucigenia());
    }
}
