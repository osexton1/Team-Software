package com.CambrianAdventure.app.Mechanics;
import com.CambrianAdventure.app.Mechanics.Environments.*;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Generate {
    int int_random;
    private Generate(int upperbound){
        Random rand = new Random();
        int_random = rand.nextInt(upperbound);
    }
    public Generate(){
        Random rand = new Random();
        int upperbound = 100;
        int_random = rand.nextInt(upperbound);
    }

    public Environment GenerateBiome(int currentBiome){
        List<Integer> biomes = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        List<Integer> weightedList = new ArrayList<Integer>();
        for (Integer biome : biomes) {
            if(biome+1 == currentBiome || biome-1 == currentBiome || biome == currentBiome){//make 3 of them
                weightedList.add(biome);
                weightedList.add(biome);
                weightedList.add(biome);
            }
            else if(biome+2 == currentBiome || biome-2 == currentBiome){//make 2 of them
                weightedList.add(biome);
                weightedList.add(biome);
            }
            else{weightedList.add(biome);}//make 1 of them
        }
        Generate output = new Generate(weightedList.size());
        System.out.println(weightedList);
        Environment outputBiome = null;
        switch (weightedList.get(output.int_random)) {
            case 0:
                outputBiome = new Frost();
                break;
            case 1:
                outputBiome = new Open();
                break;
            case 2:
                outputBiome = new Deep();
                break;
            case 3:
                outputBiome = new Caves();
                break;
            case 4:
                outputBiome = new Shallows();
                break;
            case 5:
                outputBiome = new Meadow();
                break;
            case 6:
                outputBiome = new Tropical();
                break;
            case 7:
                outputBiome = new Volcano();
                break;

        }
        return outputBiome;
    }
}
