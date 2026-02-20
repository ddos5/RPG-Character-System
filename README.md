# RPG Character System

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

A robust and extensible RPG character management system built with Java. This project demonstrates core **Object-Oriented Programming (OOP)** principles: **Inheritance, Polymorphism, Encapsulation, and Abstraction**.

##  Key Features
- **Abstract Foundation:** A base `GameCharacter` class that handles shared logic for all hero types.
- **Hero Classes:** Specialized implementations for `Warrior`, `Mage`, and `Archer`, each with unique damage calculation formulas.
- **Weapon System:** Dynamic weapon equipping that modifies attack power and handles durability.
- **RPG Mechanics:** Leveling system (Level Up), health management (Heal/Take Damage), and status tracking (Alive/Dead).

##  System Architecture



The project follows a strict hierarchical structure:
- **`GameCharacter` (Abstract):** Defines the core attributes (name, health, level) and abstract methods.
- **`Warrior`:** High physical defense; damage scales with `armorRating`.
- **`Mage`:** Master of spells; damage scales with `mana`.
- **`Archer`:** Ranged specialist; damage scales with `dexterity` and `arrowCount`.
- **`Weapon`:** A separate entity that can be equipped to boost performance.

---

##  Installation & Usage

This project uses the **Gradle** build tool.

### Prerequisites
- **JDK 17** or higher.
- **Gradle** (or use the included `gradlew` wrapper).

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/RPG-Character-System.git
cd RPG-Character-System
```
### 2. Build the Project
To compile all classes and resolve dependencies:
```bash
./gradlew build
```
### 3. Run Unit Tests
The project includes a comprehensive test suite (JUnit 5) to ensure all game logic is accurate:
```bash
./gradlew test
```
*Test reports can be found at:* `build/reports/tests/test/index.html`
