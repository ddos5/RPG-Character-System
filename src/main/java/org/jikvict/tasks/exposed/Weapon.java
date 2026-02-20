package org.jikvict.tasks.exposed;


public class Weapon {

    private String name;
    private int damage;
    private int durability;


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
    public void setDurability(int durability){
        this.durability = durability;
    }

    public boolean use() {
        if (durability > 0) {
            durability--;
            return true;
        }
            return false;
    }

    public boolean isBroken() {
        return durability <= 0;
    }

    @Override
    public String toString() {
        return "Weapon: " + name + " (Damage: " + damage + ", Durability: " + durability + ")";
    }
}
