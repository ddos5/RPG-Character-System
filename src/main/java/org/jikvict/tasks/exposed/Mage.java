package org.jikvict.tasks.exposed;

public class Mage extends GameCharacter{
    private int mana;
    private int maxMana;
    public Mage(String name, int health, int basePowerAttack, int mana){
        super(name, health, basePowerAttack);
        this.mana = mana;
        this.maxMana = mana;

    }
    @Override
    public String getCharacterType(){
        return "Mage";
    }
    @Override
    public int calculateDamage(){
        return baseAttackPower * 2;
    }
    @Override
    public String getInfo(){
        return super.getInfo() + " | Mana: " + mana + "/" + maxMana;
    }
    public String castSpell(){
        if(mana < 10){
            return getName() + "does not have enough mana!";
        }
        mana-=10;
        return getName() + "casts a spell!";
    }

    public String castSpell(String spellName){
        if(mana < 10){
            return getName() + "does not have enough mana!";
        }
            mana-=10;
            return getName() + "casts" + spellName + "!";
    }

    public String castSpell(String spellName, GameCharacter target){
        if(mana < 10){
            return getName() + "does not have enough mana!";
        }
            mana-=10;
            target.takeDamage(calculateDamage());
            return getName() + "casts" + spellName + "on" + target.getName() + "!";
    }
    public int getMana(){
        return mana;
    }
    public int getMaxMana(){
        return maxMana;
    }
    public void setMana(int mana){
        this.mana = mana;
    }

}
