# Task 6 — RPG Character System

### Inheritance, Encapsulation, Polymorphism & Method Overloading

In this task you will build a simple **RPG character system** — no UI needed, just the core
class hierarchy and game logic. You will practise the most important OOP pillars:

| Concept | What you practise |
|---|---|
| **Inheritance** | Building a class hierarchy (`Warrior`, `Mage`, `Archer` extend `GameCharacter`) |
| **Encapsulation** | Private fields, getters / setters, no leaking of internal state |
| **Method overriding** | Each subclass overrides `getCharacterType()`, `calculateDamage()`, `getInfo()` |
| **Method overloading** | `attack()` / `attack(GameCharacter)` in `GameCharacter`; `castSpell()` overloads in `Mage` |
| **Runtime polymorphism** | Using `GameCharacter` references to call overridden methods |
| **Access modifiers** | `private` vs `protected` fields inside an inheritance hierarchy |

---

## Provided skeleton files

Two skeleton files live in `org.jikvict.tasks.exposed`:

| File | Description |
|---|---|
| `GameCharacter.java` | **Abstract** base class — read the TODOs inside |
| `Weapon.java` | Simple weapon class — read the TODOs inside |

> **Do not** change method signatures or access modifiers that are already present.
> You **may** add private helper methods if you need them.

---

## What you must implement

### 1. Complete `Weapon`

| Field (private) | Type | Notes |
|---|---|---|
| `name` | `String` | weapon name |
| `damage` | `int` | damage bonus |
| `durability` | `int` | remaining uses |

Methods to implement (see TODOs in file):

- Constructor `Weapon(String name, int damage, int durability)`
- Getters & setters for **all three** fields
- `boolean use()` — decreases durability by 1; returns `true` if the weapon still had durability, `false` otherwise
- `boolean isBroken()` — returns `true` when durability is 0
- `toString()` → `"Weapon: {name} (Damage: {damage}, Durability: {durability})"`

---

### 2. Complete `GameCharacter` (abstract)

#### Fields

| Field | Type | Access | Notes |
|---|---|---|---|
| `name` | `String` | **private** | character name |
| `health` | `int` | **private** | current HP |
| `maxHealth` | `int` | **private** | max HP (set to initial health) |
| `baseAttackPower` | `int` | **protected** | accessible from subclasses directly |
| `level` | `int` | **private** | starts at 1 |
| `weapon` | `Weapon` | **private** | equipped weapon, initially `null` |
| `alive` | `boolean` | **private** | starts as `true` |

#### Constructor

`GameCharacter(String name, int health, int baseAttackPower)` — sets `maxHealth = health`,
`level = 1`, `alive = true`, `weapon = null`.

#### Abstract methods (you just implement them in subclasses)

| Method | Returns |
|---|---|
| `getCharacterType()` | `String` — e.g. `"Warrior"` |
| `calculateDamage()` | `int` — base damage formula |

#### Concrete methods to implement

| Method | Behaviour |
|---|---|
| `getInfo()` | Returns `"Name: {name} \| Type: {type} \| HP: {health}/{maxHealth} \| Level: {level}"` |
| `attack(GameCharacter target)` | Calculate damage via `calculateDamage()`, add weapon damage (if weapon equipped & not broken, also call `weapon.use()`), then `target.takeDamage(totalDamage)` |
| `int attack()` | Same calculation but **returns** the damage without attacking anyone and **without** consuming weapon durability (method overloading!) |
| `takeDamage(int damage)` | Reduce `health` by `damage`. Health must not drop below 0. If it reaches 0, set `alive = false` |
| `heal(int amount)` | Increase health (max = `maxHealth`). Does nothing if character is dead |
| `levelUp()` | `level += 1`, `maxHealth += 10`, `baseAttackPower += 2` |
| `toString()` | `"{type}: {name} (Level {level})"` |

#### Required getters

`getName()`, `getHealth()`, `getMaxHealth()`, `getBaseAttackPower()`, `getLevel()`,
`getWeapon()`, `isAlive()`

#### Required setters

`setName(String)`, `setWeapon(Weapon)`

> Health is modified **only** via `takeDamage` / `heal`.
> Level is modified **only** via `levelUp`.

---

### 3. Create three subclasses (from scratch)

All in package `org.jikvict.tasks.exposed`. Each **extends** `GameCharacter`.

#### `Warrior`

| Extra field (private) | Type |
|---|---|
| `armorRating` | `int` |

| Constructor | `Warrior(String name, int health, int baseAttackPower, int armorRating)` |
|---|---|

| Method | Behaviour |
|---|---|
| `getCharacterType()` | `"Warrior"` |
| `calculateDamage()` | `baseAttackPower + armorRating / 2` (integer division) |
| `takeDamage(int damage)` | Calls `super.takeDamage(Math.max(0, damage - armorRating / 3))` — armour absorbs part of the blow |
| `getInfo()` | `super.getInfo() + " \| Armor: {armorRating}"` |
| Getter / setter | `getArmorRating()`, `setArmorRating(int)` |

#### `Mage`

| Extra fields (private) | Type |
|---|---|
| `mana` | `int` |
| `maxMana` | `int` |

| Constructor | `Mage(String name, int health, int baseAttackPower, int mana)` — sets `maxMana = mana` |
|---|---|

| Method | Behaviour |
|---|---|
| `getCharacterType()` | `"Mage"` |
| `calculateDamage()` | `baseAttackPower * 2` |
| `getInfo()` | `super.getInfo() + " \| Mana: {mana}/{maxMana}"` |
| `castSpell()` | If `mana < 10` → return `"{name} does not have enough mana!"`. Otherwise `mana -= 10`, return `"{name} casts a spell!"` |
| `castSpell(String spellName)` | Same mana check. Return `"{name} casts {spellName}!"` |
| `castSpell(String spellName, GameCharacter target)` | Same mana check. Deal `calculateDamage()` to target. Return `"{name} casts {spellName} on {targetName}!"` |
| Getters / setter | `getMana()`, `getMaxMana()`, `setMana(int)` |

> The three `castSpell` variants demonstrate **method overloading**.

#### `Archer`

| Extra field (private) | Type |
|---|---|
| `arrowCount` | `int` |

| Constructor | `Archer(String name, int health, int baseAttackPower, int arrowCount)` |
|---|---|

| Method | Behaviour |
|---|---|
| `getCharacterType()` | `"Archer"` |
| `calculateDamage()` | `baseAttackPower + 5` |
| `getInfo()` | `super.getInfo() + " \| Arrows: {arrowCount}"` |
| `shootArrow()` | If `arrowCount > 0`, decrements and returns `true`; else `false` |
| Getter / setter | `getArrowCount()`, `setArrowCount(int)` |

---

## Quick example

```java
GameCharacter warrior = new Warrior("Arthur", 100, 10, 6);
GameCharacter mage    = new Mage("Gandalf", 80, 15, 50);

System.out.println(warrior.getCharacterType()); // "Warrior"
System.out.println(mage.calculateDamage());     // 30

warrior.attack(mage);            // mage takes damage
System.out.println(warrior.attack()); // prints damage value (no target attacked)
```

---

## Submission

Take your whole project, remove unnecessary files (like `.idea` folder or build folder) and zip it.

The final zip file should contain the `default-structure` folder at the root.
