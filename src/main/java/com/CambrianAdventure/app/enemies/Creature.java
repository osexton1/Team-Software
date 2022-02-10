package com.CambrianAdventure.app.enemies;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

import java.util.Objects;

public class Creature {
    public String name;
    public Integer health;
    public Integer food;
    public Integer combatHealth;
    public Persona personality;
    public Integer disPlay;
    public Integer disToFlee;

    public Creature(String Name){
        name = Name;
        health = 3;
        combatHealth = 20;
        food = 20;
        disToFlee = 2;
    }

    public Creature(String Name, Persona Personality){
        name = Name;
        health = 3;
        combatHealth = new Generate(21, 1).int_random;;
        food = new Generate(15, 5).int_random;
        personality = Personality;
        disPlay = new Generate(5, 2).int_random;
        disToFlee = 2;
    }
    //combat stuff goes here
    public void attack(Creature attacker, Creature target){
        Integer distance;
        if (attacker.disPlay == null){
            distance = target.disPlay;
        }
        else{
            distance = attacker.disPlay;
        }
        if (distance == 0){
            System.out.println("adjacent");
            target.combatHealth -= 5;
            if (target.combatHealth <= 0){
                System.out.println("Murder");
            }
        }
        else{
            System.out.println("Whiff");
        }
    }

    public String AICalculate(){
        // Aggression, based on combat health + food + personality
        // based on aggression, attack if in range/ advance/ retreat/
        Integer Aggression = combatHealth + food + personality.Bonus;
        String output = "";
        // 50 - 30 hard focus attack
        // 29 - 15 coinflip based on personality
        // 14 - -9 flee
        if (Aggression >= 30) {
            if (disPlay > 0) {
                output = "Advance";
            } else {
                output = "Attack";
            }
        }
        else if(Aggression >= 15){output = "IDK";}//coinflip
        else{output = "Flee";}
        return output;
    }

    public void AIDo(String Action){
        if (Objects.equals(Action, "Advance")) {
            this.disToFlee += 1;
            this.disPlay -= 1;
        }
        else if(Objects.equals(Action, "Flee")){
            this.disToFlee -= 1;
            this.disPlay += 1;
        }
        System.out.println(Action);
    }

    public String toString(){
        String output = "";
        output += name + "; Combat Health: " + combatHealth + ", food: " + food + ", distance to flee: " + disToFlee;
        if(disPlay != null){ output+= ", distance to Player: " + disPlay;};
        return output;
    }

}
