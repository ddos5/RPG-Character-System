package exposed;

import org.jikvict.tasks.exposed.GameCharacter;
import org.jikvict.tasks.exposed.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exposed structural tests — students can see and run these locally.
 */
class StructureTest {

    @Test
    @DisplayName("GameCharacter should be an abstract class")
    void gameCharacterShouldBeAbstract() {
        assertTrue(Modifier.isAbstract(GameCharacter.class.getModifiers()),
                "GameCharacter must be declared abstract");
    }

    @Test
    @DisplayName("Warrior class should exist and extend GameCharacter")
    void warriorShouldExist() {
        GameCharacter warrior = Util.createWarrior("Test", 100, 10, 5);
        assertNotNull(warrior);
    }

    @Test
    @DisplayName("Mage class should exist and extend GameCharacter")
    void mageShouldExist() {
        GameCharacter mage = Util.createMage("Test", 80, 15, 50);
        assertNotNull(mage);
    }

    @Test
    @DisplayName("Archer class should exist and extend GameCharacter")
    void archerShouldExist() {
        GameCharacter archer = Util.createArcher("Test", 90, 12, 20);
        assertNotNull(archer);
    }

    @Test
    @DisplayName("Weapon class should be instantiable")
    void weaponShouldExist() {
        Weapon weapon = new Weapon("Sword", 10, 100);
        assertNotNull(weapon);
    }

    @Test
    @DisplayName("Warrior, Mage, Archer should each report the correct character type")
    void characterTypesShouldBeCorrect() {
        assertEquals("Warrior", Util.createWarrior("W", 100, 10, 5).getCharacterType());
        assertEquals("Mage",    Util.createMage("M", 80, 15, 50).getCharacterType());
        assertEquals("Archer",  Util.createArcher("A", 90, 12, 20).getCharacterType());
    }
}
