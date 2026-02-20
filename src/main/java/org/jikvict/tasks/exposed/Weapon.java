package org.jikvict.tasks.exposed;

/**
 * Represents a weapon that can be equipped by a {@link GameCharacter}.
 * <p>
 * Fields (all <b>private</b>):
 * <ul>
 *   <li>{@code name}       — String</li>
 *   <li>{@code damage}     — int</li>
 *   <li>{@code durability} — int (remaining uses)</li>
 * </ul>
 */
public class Weapon {

    // TODO: Declare private fields

    private String name;
    private int damage;
    private int durability;


    /**
     * Creates a new Weapon.
     *
     * @param name       the weapon's name
     * @param damage     the weapon's damage bonus
     * @param durability remaining uses before the weapon breaks
     */
    public Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDurability(){
        return durability;
    }
    public void setDurability(int durablity){
        this.durability = durability;
    }

    // TODO: Implement getters and setters for ALL fields:
    //   getName(), setName(String)
    //   getDamage(), setDamage(int)
    //   getDurability(), setDurability(int)

    /**
     * Uses the weapon once, reducing durability by 1.
     * Durability cannot drop below 0.
     *
     * @return {@code true} if the weapon had remaining durability (was actually used),
     *         {@code false} otherwise
     */
    public boolean use() {
        if (durability > 0) {
            durablity -= 1;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @return {@code true} if durability is 0
     */
    public boolean isBroken() {
        if(durability == 0) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Format: {@code "Weapon: {name} (Damage: {damage}, Durability: {durability})"}
     */
    @Override
    public String toString() {
        return "Weapon: " + name + " (Damage: " + damage + ", Durability: " + durability + ")";
    }
}
