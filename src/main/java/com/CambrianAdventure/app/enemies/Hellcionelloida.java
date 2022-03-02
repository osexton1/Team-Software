package com.CambrianAdventure.app.enemies;
import com.CambrianAdventure.app.Mechanics.*;
import com.CambrianAdventure.app.enemies.Personalitys.*;

import java.util.Objects;

import static com.CambrianAdventure.app.Main.Char;

public class Hellcionelloida extends Creature{
    public Hellcionelloida() {
        super("Hellcionelloida", new Fearful());
        combatHealth = new Generate(29, 18).int_random;
        armorLevel = 3;
        spikeDamage = 0;
        attackDamage = 1;
        reach = 1;
        movementDistance = 1;
        Speed = 1;
        size = "M";
    }

    // overriding method so that this creature flees into its shell instead of fleeing the battlefield if it has low Health.
    public void AIDo(String Action, Creature Player){
        this.armorLevel = 3; // resets armour to default value at the beginning of this creatures turn.
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
            if (this.combatHealth > 15) {
                if (disToFlee > 0) {
                    this.disToFlee -= 1;
                    this.disPlay += 1;
                }
                else{
                    this.combatHealth = 0;
                    System.out.println("CPU Leave the battlefield");
                }
            }
            else{
                this.armorLevel = 9;
            }
        }
    }
}
