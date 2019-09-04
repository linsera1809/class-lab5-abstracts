# Lab Description
This lab involves writing code for a game engine. It supports competency development and master. Upon completion of this lab
the student will:
* Implement the inheritance pattern with an abstract class.

## Directions
1. Complete the steps in the assignment below
2. Save your code (.java file) and your results output into a .ZIP file with the following format:
firstname-lastname-abstractclass-date
EXAMPLE: mary-smith-abstractclass-08272019
3. Then, upload (submit) the file to the corresponding assignment link.

## Java Abstract Class Assignment
In this lab we will be implementing part of a game engine for a role-playing game. Players can choose one of three character types 
to play: Warrior, Archer, and Mage. Each of these character types can attack and deal damage to other characters, and each of the
character types have specific rules around these actions. Your job will be to implement these character types. 

## General Game Rules
Each character can attack, deal damage, and take damage. 

### Hit Points
Each character has a number of hit points which represent their health in the game. Hit points are calculated when the character
is created based on their class type and level.

### Attacking
* An attack's success is determined by a roll (a random number between 1 and 20) plus a potential attack bonus. If the roll plus the attack bonus
is higher than (20 - the calculated armor class (see below)) then the attack is successful. Successful attacks cause the target to take damage.
* A roll of 20 (the highest possible roll value) indicates an automatic successful hit for the attacker, causing the target to take damage.
* A roll of 1 (the lowest possible roll value) indicates an automatic miss for the attacker, which deals no damage.

### Dealing Damage
* When a successful attack has been made then the attacking character can deal damage to their opponent. The amount of damage points
is subtracted from the the opponents hit points. 

### Taking Damage
* Damage subtracts from a characters hit points.
* Once a character reaches zero hit points they are unconscious, and cannot attack.

(You don't have to implement this rule as it has already been implemented in the base class).

### Armor Class
Each character has an armor class, which represents how hard it is to hit them. The armor class starts at 10 and goes down based on the
type of character. 

### Warriors
#### Hit Points
* Warrior receive 10 hit points per level upon character creation.

#### Attacking
* Warriors get a +1 attack bonus per level. So if a level 3 warrior attacks they get +3 to the their
attack roll.

#### Dealing Damage
* Warriors deal 2 points of damage per attack per level.

#### Armor class
* Warriors' Armor Class decreases by 1 point per level.

### Archers
#### Hit Points
* Archers receive 6 hit points per level upon character creation.

#### Attacking
* Archers get a +1 bonus for every 2 levels. So a level 4 archer gets +2 to their attack roll.

#### Dealing Damage
* Archers deal 1 point of damage per attack per level.

#### Armor Class
* Archers' Armor Class descreases by 1 point per 2 levels.

### Mages
#### Hit Points
* Mages receive 4 hit points per level upon character creation.

#### Attacking
* Mages use magic, and automatically hit their target, causing the target to take damage.

#### Dealing Damage
* Mages deal 2 points of damage per attack per level. If the target is another mage then divide the damage by 2 (Hint: use the `.equals()` or `.getClass()` methods
to determine if the target is a Mage or not).

#### Armor Class
* Mages' Armor Class decreases by 1 point per four levels.

##Tasks

* Implement three classes which extend from `RolePlayingCharacter`:
    * Warrior
    * Mage
    * Archer
    
The class names **must** match exactly, and **must** be in the `edu.cscc.roleplayingclasses` package.
* Override the `.calculateHitPoints()` method for each subclass from the base abstract class.
* Override the `.calculateTotalAttackRoll()` method for each subclass from the base abstract class.
* Override the `.dealDamage()` method for each subclass from the base abstract class.
* Override the `.calculateArmorClass()` method for each subclass.

## Testing
A suite of tests have been provided for each class to be implemented. Initially all of these tests will fail. As you implement each class
the tests will begin to pass (Assuming you have named your classes correctly and they are in the correct package.). Once all of the tests
are passing you have completed the assignment. You are free to add additional tests as you see fit.

## Additional Notes
* You may need to override one or two additional methods on the RolePlayingCharacter class when implementing the Mage rules. Consider the rules
about automatically hitting their targets and only doing half damage to other Mages. Read the `RolePlayingCharacter` class to get an idea of which 
methods to override in Mage.