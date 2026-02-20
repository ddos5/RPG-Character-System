package org.jikvict.tasks.exposed;

/**
 * Simple demonstration of the RPG character system.
 * <p>
 * Once you have implemented all the classes, this main method should run
 * without errors and print character information and combat results.
 */
public class Main {

    public static void main(String[] args) {
        // TODO: After you implement Warrior, Mage and Archer, uncomment the code below.


        GameCharacter warrior = new Warrior("Arthur", 100, 10, 6);
        GameCharacter mage    = new Mage("Gandalf", 80, 15, 50);
        GameCharacter archer  = new Archer("Legolas", 90, 12, 20);

        System.out.println(warrior.getInfo());
        System.out.println(mage.getInfo());
        System.out.println(archer.getInfo());

        System.out.println();
        System.out.println("Warrior damage: " + warrior.calculateDamage());
        System.out.println("Mage damage:    " + mage.calculateDamage());
        System.out.println("Archer damage:  " + archer.calculateDamage());

        System.out.println();
        warrior.attack(mage);
        System.out.println("Mage HP after warrior attack: " + mage.getHealth());

        Weapon sword = new Weapon("Excalibur", 15, 100);
        warrior.setWeapon(sword);
        System.out.println("Warrior potential damage with weapon: " + warrior.attack());

    }
}
