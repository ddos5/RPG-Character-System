package org.jikvict.tasks.exposed;

public abstract class GameCharacter {


    private String name;
    private int health;
    private int maxHealth;
    protected int baseAttackPower;
    private int level;
    private Weapon weapon;
    private boolean alive;


    public GameCharacter(String name, int health, int baseAttackPower) {
        this.name = name;
        this.health = health;
        this.baseAttackPower = baseAttackPower;
        this.maxHealth = health;
        this.level = 1;
        this.alive = true;
        this.weapon = null;
    }

    public abstract String getCharacterType();
    public abstract int calculateDamage();


    public String getInfo() {
        return "Name: " + name + " | Type: " + getCharacterType() + " | HP: " + health + "/" + maxHealth + " | Level: " + level;
    }


    public void attack(GameCharacter target) {
        int someDamage = calculateDamage();
        if (weapon != null && !weapon.isBroken()) {
            someDamage += weapon.getDamage();
            weapon.use();
        }
        target.takeDamage(someDamage);
    }


    public int attack() {
        int totalDamage = calculateDamage();
        if(weapon != null && !weapon.isBroken()) {
            totalDamage += weapon.getDamage();
        }
        return totalDamage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if(this.health <= 0){
            this.health = 0;
            this.alive = false;
        }
    }

    public void heal(int amount) {
        if(alive){
            this.health = Math.min(maxHealth, this.health + amount);
        }
    }

    public void levelUp() {
        this.level += 1;
        maxHealth += 10;
        baseAttackPower += 2;
    }

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getBaseAttackPower(){
        return baseAttackPower;
    }
    public void setName(String name){
        this.name = name;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public int getLevel(){
        return level;
    }

    @Override
    public String toString() {
        return getCharacterType() + ": " + name + "(Level " + level + ")";
    }

    public boolean isAlive(){
        return alive;
    }
}


