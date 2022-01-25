package com.CambrianAdventure.app.Mechanics;

public class EnviromentBase {
    public String Descript;
    public String enemy;

    public EnviromentBase(String sandy_beach, String hallucigenia) {
        Descript = sandy_beach;
        enemy = hallucigenia;
    }

    public void setup(){
        System.out.println(Descript);
    }
}
