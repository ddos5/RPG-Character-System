package exposed;

import org.jikvict.tasks.exposed.GameCharacter;
import org.jikvict.tasks.exposed.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exposed functional tests — students can see and run these locally.
 */
class GameCharacterTest {

    // ───────────────────── basic creation & getters ─────────────────────

    @Test
    @DisplayName("Newly created character should be alive with correct health")
    void newCharacterIsAlive() {
        GameCharacter warrior = Util.createWarrior("Arthur", 100, 10, 5);
        assertTrue(warrior.isAlive());
        assertEquals(100, warrior.getHealth());
        assertEquals(100, warrior.getMaxHealth());
        assertEquals(1, warrior.getLevel());
    }

    @Test
    @DisplayName("getName should return the character's name")
    void getNameWorks() {
        GameCharacter mage = Util.createMage("Gandalf", 80, 15, 50);
        assertEquals("Gandalf", mage.getName());
    }

    // ───────────────────── damage & death ─────────────────────

    @Test
    @DisplayName("takeDamage should reduce health and character should die at 0 HP")
    void takeDamageAndDie() {
        GameCharacter archer = Util.createArcher("Legolas", 50, 12, 20);
        archer.takeDamage(50);
        assertEquals(0, archer.getHealth());
        assertFalse(archer.isAlive());
    }

    @Test
    @DisplayName("Health should not drop below 0")
    void healthFloorIsZero() {
        GameCharacter warrior = Util.createWarrior("Arthur", 30, 10, 5);
        warrior.takeDamage(999);
        assertEquals(0, warrior.getHealth());
    }

    // ───────────────────── healing ─────────────────────

    @Test
    @DisplayName("heal should not exceed maxHealth")
    void healCappedAtMax() {
        GameCharacter warrior = Util.createWarrior("Arthur", 100, 10, 5);
        warrior.takeDamage(20);
        warrior.heal(999);
        assertEquals(100, warrior.getHealth());
    }

    // ───────────────────── polymorphism preview ─────────────────────

    @Test
    @DisplayName("calculateDamage should return different values for each character type")
    void polymorphicDamage() {
        GameCharacter warrior = Util.createWarrior("W", 100, 10, 6);  // 10 + 6/2 = 13
        GameCharacter mage    = Util.createMage("M", 80, 15, 50);     // 15 * 2 = 30
        GameCharacter archer  = Util.createArcher("A", 90, 12, 20);   // 12 + 5 = 17

        assertEquals(13, warrior.calculateDamage());
        assertEquals(30, mage.calculateDamage());
        assertEquals(17, archer.calculateDamage());
    }

    // ───────────────────── weapon basics ─────────────────────

    @Test
    @DisplayName("Weapon getters should return correct values")
    void weaponGetters() {
        Weapon sword = new Weapon("Excalibur", 15, 100);
        assertEquals("Excalibur", sword.getName());
        assertEquals(15, sword.getDamage());
        assertEquals(100, sword.getDurability());
        assertFalse(sword.isBroken());
    }

    @Test
    @DisplayName("Weapon.use() should decrease durability")
    void weaponUse() {
        Weapon sword = new Weapon("Sword", 10, 2);
        assertTrue(sword.use());
        assertEquals(1, sword.getDurability());
        assertTrue(sword.use());
        assertEquals(0, sword.getDurability());
        assertTrue(sword.isBroken());
        assertFalse(sword.use());
    }
}
