package com.CambrianAdventure.app.Mechanics;
import java.util.Objects;

public class Player {
    public int health;
    public int food;
    public int evolutionLevel;
    public Environment Current;

    public Player(){
        health = 3;
        food = 20;
        evolutionLevel = 0;
        Current = null;
    }

    public void Move(String input, boolean room){
        if (room){
            if (Objects.equals(input, "1")) {
                Current.scenario = Current.scenario.middlePath;
                Current.LoadRoom();
            }
            else if (Objects.equals(input, "2") && Current.scenario.leftPath != null) {
                Current.scenario = Current.scenario.leftPath;
                Current.LoadRoom();
            }
            else if (Objects.equals(input, "3") && Current.scenario.rightPath != null) {
                Current.scenario = Current.scenario.rightPath;
                Current.LoadRoom();
            }
        }
        else {
            if (Objects.equals(input, "1")) {
                Current = Current.middlePath;
                Current.LoadBiomes();
            } else if (Objects.equals(input, "2") && Current.scenario.rightPath != null) {
                Current = Current.rightPath;
                Current.LoadBiomes();
            } else if (Objects.equals(input, "3") && Current.scenario.leftPath != null) {
                Current = Current.leftPath;
                Current.LoadBiomes();
            }
        }
    }
}
