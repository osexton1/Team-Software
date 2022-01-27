package com.CambrianAdventure.app.Mechanics;
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

    public int GenerateBiome(int currentBiome){
        List<Integer> biomes = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        List<Integer> weightedList = new ArrayList<Integer>();
        for (Integer biome : biomes) {
            if(biome+1 == currentBiome || biome-1 == currentBiome || biome == currentBiome){
                weightedList.add(biome);
                weightedList.add(biome);
                weightedList.add(biome);
            }//make 3 of them
            else if(biome+2 == currentBiome || biome-2 == currentBiome){
                weightedList.add(biome);
                weightedList.add(biome);
            }//make 2 of them
            else{weightedList.add(biome);}//make 1 of them
        }
        Generate test = new Generate(weightedList.size());
        System.out.println(weightedList);
        return weightedList.get(test.int_random);
    }
}
