package exposed;

import org.jikvict.tasks.exposed.GameCharacter;

import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Utility helpers shared by exposed tests.
 */
public class Util {

    private static final String PACKAGE = "org.jikvict.tasks.exposed";

    /**
     * Creates a character subclass instance via reflection.
     * Expects a constructor (String, int, int, int).
     */
    public static GameCharacter createCharacter(String className, String name,
                                                 int health, int attack, int extra) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + "." + className);
            assertThat(clazz).isNotNull();
            assertThat(GameCharacter.class).isAssignableFrom(clazz);
            var constructor = clazz.getConstructor(String.class, int.class, int.class, int.class);
            return (GameCharacter) constructor.newInstance(name, health, attack, extra);
        } catch (Exception e) {
            throw new RuntimeException("Could not create " + className + ": " + e.getMessage(), e);
        }
    }

    public static GameCharacter createWarrior(String name, int health, int attack, int armor) {
        return createCharacter("Warrior", name, health, attack, armor);
    }

    public static GameCharacter createMage(String name, int health, int attack, int mana) {
        return createCharacter("Mage", name, health, attack, mana);
    }

    public static GameCharacter createArcher(String name, int health, int attack, int arrows) {
        return createCharacter("Archer", name, health, attack, arrows);
    }

    /**
     * Calls a no-arg method on an instance via reflection and returns the result.
     */
    public static Object callMethod(Object instance, String methodName) {
        try {
            Method method = instance.getClass().getMethod(methodName);
            return method.invoke(instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to call " + methodName + ": " + e.getMessage(), e);
        }
    }

    /**
     * Calls a method with specified parameter types on an instance via reflection.
     */
    public static Object callMethod(Object instance, String methodName,
                                    Class<?>[] paramTypes, Object... args) {
        try {
            Method method = instance.getClass().getMethod(methodName, paramTypes);
            return method.invoke(instance, args);
        } catch (Exception e) {
            throw new RuntimeException("Failed to call " + methodName + ": " + e.getMessage(), e);
        }
    }

    /**
     * Loads a class from the exposed package.
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(PACKAGE + "." + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + className, e);
        }
    }
}
