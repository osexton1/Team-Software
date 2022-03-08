package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.Mechanics.Environments.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;
import com.CambrianAdventure.app.exploration.*;
import com.CambrianAdventure.app.exploration.Scenarios.*;
import com.CambrianAdventure.app.enemies.*;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Generate {
    public Integer int_random;
    public Generate(Integer upperbound){
        Random rand = new Random();
        int_random = rand.nextInt(upperbound); //generate an int up to input upperbounds
    }
    public Generate(){
        int_random = new Generate(100).int_random; // default int generator up to 100
    }

    public Generate(Integer upperbound, Integer lowerbound) {
        Random rand = new Random();
        int_random = rand.nextInt((upperbound - lowerbound) + 1)+lowerbound;
    }

    public boolean coinFlip(){
        return new Generate(2).int_random >= 1;
    }

    public Integer Paths(){
        return (new Generate(2)).int_random;
    }

    public Scenario GenerateRoom(Integer currentRoom){
        List<Integer> rooms = new ArrayList<>(Arrays.asList(0, 1, 2)); //list of possible room types
        List<Integer> weightedList = new ArrayList<>();
        for (Integer room : rooms) { //create weighted list
            if (room != currentRoom){
                weightedList.add(room);
            }
            weightedList.add(room);//make 1 of them
        }
        Generate output = new Generate(weightedList.size()); //get random number from weighted list
        Scenario outputroom = null;
        switch (weightedList.get(output.int_random)) {
            case 0: outputroom = new Event(); break;
            case 1: outputroom = new Puzzle(); break;
            case 2: outputroom = new Encounter(); break;
            }
        return outputroom;
    }

    public Environment GenerateBiome(Integer currentBiome){
        List<Integer> biomes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)); //list of possible biome types
        List<Integer> weightedList = new ArrayList<>();
        for (Integer biome : biomes) { //create weighted list
            if(biome+1 == currentBiome || biome-1 == currentBiome || biome.equals(currentBiome)){//make 3 of them
                weightedList.add(biome);
                weightedList.add(biome);
            }
            else if(biome+2 == currentBiome || biome-2 == currentBiome){//make 2 of them
                weightedList.add(biome);
            }
            weightedList.add(biome);//make 1 of them
        }
        Generate output = new Generate(weightedList.size()); //get random number from weighted list
        Environment outputBiome = null;
        switch (weightedList.get(output.int_random)) {
            case 0: outputBiome = new Frost(); break;
            case 1: outputBiome = new Caves(); break;
            case 2: outputBiome = new Deep(); break;
            case 3: outputBiome = new Open(); break;
            case 4: outputBiome = new Shallows(); break;
            case 5: outputBiome = new Meadow(); break;
            case 6: outputBiome = new Tropical(); break;
            case 7: outputBiome = new Volcano(); break;
        }
        return outputBiome;
    }

    public Persona GeneratePersonal(){
        List<Integer> personal = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        Generate output = new Generate(personal.size()); //get random number from weighted list
        Persona outputPersonality = null;
        switch (personal.get(output.int_random)) {
            case 0: outputPersonality = new Rabid(); break;
            case 1: outputPersonality = new Brawny(); break;
            case 2: outputPersonality = new Neutral(); break;
            case 3: outputPersonality = new Shy(); break;
            case 4: outputPersonality = new Fearful(); break;
        }
        return outputPersonality;
    }

    public Creature GenerateEnemy(){
        Integer temp = new Generate(11, 1).int_random;
        switch (temp) {
            case 1: return new Aysheaia();
            case 2: return new Hallucigenia();
            case 3: return new Hellcionelloida();
            case 4: return new Hymenocaris();
            case 5: return new Isoxys();
            case 6: return new Marrella();
            case 7: return new Nectocaris();
            case 8: return new Opabinia();
            case 9: return new Trilobite();
            case 10: return new Waptia();
            default: return new Wiwaxia();
        }
    }
    public Creature GenSmall(){
        Integer temp = new Generate(6, 1).int_random;
        switch (temp) {
            case 1: return new Aysheaia();
            case 2: return new Hallucigenia();
            case 3: return new Hymenocaris();
            case 4: return new Marrella();
            case 5: return new Waptia();
            default: return new Wiwaxia();
        }
    }

    public Creature GenLarge(){
        Integer temp = new Generate(5, 1).int_random;
        switch (temp) {
            case 1: return new Hellcionelloida();
            case 2: return new Isoxys();
            case 3: return new Nectocaris();
            case 4: return new Opabinia();
            default: return new Trilobite();
        }
    }

    public Creature GenBoss(){
        Integer temp = new Generate(11, 1).int_random;
        switch (temp) {
            case 1: Creature tempChar = new Hallucigenia();
                tempChar.combatHealth = 50;
                tempChar.attackDamage = 7;
                tempChar.spikeDamage = 5;
                tempChar.armorLevel = 3;
                return tempChar;
            default: return new Anomalocaris();
        }
    }
}
