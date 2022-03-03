package com.CambrianAdventure.app.enemies;

import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

import java.util.Random;
import java.util.Objects;

import static com.CambrianAdventure.app.Main.*;

public class Creature {
    public String name;
    public Integer health;
    public Integer food;
    public Integer combatHealth;
    public Persona personality;
    public Integer disPlay;
    public Integer disToFlee = 2;
    public Integer Speed = 4;
    public String playerClass;
    public Integer armorLevel = 0;
    public Integer spikeDamage = 0;
    public Integer attackDamage = 5;
    public Integer reach = 1;
    public String description;
    public Integer movementDistance = 1;
    public Integer Aggression;

    public Creature(String Name){
        name = Name;
        health = 3;
        combatHealth = 20;
        food = 20;
        disToFlee = 2;
    }

    public Creature(String Name, int maxComHealth){
        name = Name;
        combatHealth = maxComHealth;
        food = new Generate(20, 15).int_random;
        personality = new Generate().GeneratePersonal();
        disPlay = new Generate(5, 2).int_random;
        disToFlee = 2;
        Aggression = combatHealth + food + personality.Bonus;
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
        if (distance < attacker.reach){
            System.out.println("adjacent, hit");
            int damage = attacker.attackDamage - target.armorLevel;
            if (damage > 0) {
                target.combatHealth -= (damage);
                if (target.spikeDamage > 0 && distance == 0) {
                    attacker.combatHealth -= target.spikeDamage;
                }
            }
            if (target.combatHealth <= 0){
                System.out.println("Murder");
            }
        }
        else{
            System.out.println("Whiff");
        }
    }

    public void Threaten(){
        Integer threatRand = new Generate(3).int_random;
        switch(threatRand){
            case 0: Aggression += 20;
                    Layout.setError("That made them mad!"); break;
            case 1: Aggression += 10;
                    Layout.setError("They attempt to threaten you back!"); break;
            case 2: Aggression -= 25;
                    Layout.setError("The creature cowers for a moment!"); break;
        }

    }

    public String AICalculate(){
        // Aggression, based on combat health + food + personality
        // based on aggression, attack if in range/ advance/ retreat/
        String output = "";
        // 50 - 30 hard focus attack
        // 29 - 15 coinflip based on personality
        // 14 - 9 flee
        if (Aggression >= 30) {
            if (this.disPlay >= this.reach) {
                output = "Advance";
            }
            else{
                output = "Attack";
            }
        }

        else if(Aggression >= 15){
            if (personality instanceof Brawny || personality instanceof Rabid){
                if (this.disPlay >= this.reach) {
                    output = "Advance";
                }
                else{
                    output = "Attack";
                }
            }
            else if (personality instanceof Neutral){
                if (30 - Aggression > Aggression -15){
                    if (this.disPlay >= this.reach) {
                        output = "Advance";
                    }
                    else{
                        output = "Attack";
                    }
                }
                else if (30 - Aggression < Aggression -15){
                    output = "Flee";
                }
            }
            else if (personality instanceof Shy || personality instanceof Fearful){
                output = "Flee";
            }
        }
        else{output = "Flee";}
        return output;
    }

    public void AIDo(String Action, Creature Player){
        if (Objects.equals(Action, "Advance")) {
            if (this.disPlay > 1 && this.movementDistance == 2) {
                this.disToFlee += 2;
                this.disPlay -= 2;
            }
            else if (this.disPlay > 0) {
                this.disToFlee += 1;
                this.disPlay -= 1;
            }
            else{
                System.out.println("The " + this.name + " bumped into you");
            }
        }
        else if (Objects.equals(Action, "Attack")){
            System.out.println("CPU Attack");
            //attack
            attack(this, Player);
            Char.charDisplay();
        }

        else if(Objects.equals(Action, "Flee")){
            if (disToFlee > 0) {
                this.disToFlee -= 1;
                this.disPlay += 1;
            }
            else{
                this.combatHealth = 0;
                System.out.println("CPU Leave the battlefield");
            }
        }
    }
    public void comInspect(){
        Layout.setError("You try to gather the mentality of the enemy in front of you.");
    }

    public void comWait(){
        Layout.setError("You wait for the enemy to make a move");
    }

    public String toString(){
        String output = "";
        output += name + ", Combat Health: " + combatHealth + ", food: " + food + ", distance to flee: " + disToFlee;
        if(disPlay != null){ output+= ", distance to Player: " + disPlay;};
        return output;
    }

}
