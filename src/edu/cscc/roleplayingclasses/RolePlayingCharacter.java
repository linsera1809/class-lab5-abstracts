package edu.cscc.roleplayingclasses;

import static edu.cscc.combat.Combat.*;

/**
 * This is the base class that all character classes extend from.
 */
public abstract class RolePlayingCharacter {

    private String name;
    protected int level;
    protected int hitPoints;

    /**
     * Constructor a new RolePlayingCharacter.
     *
     * @param name
     * @param level
     */
    public RolePlayingCharacter(String name, int level) {
        this.name = name;
        this.level = level;
        calculateHitPoints();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getName() {
        return name;
    }

    /**
     * Applies damage received from the opponent's dealDamage() method.
     * May be overridden when necessary.
     * @param opponent The opponent RolePlayingCharacter.
     */
    void takeDamage(RolePlayingCharacter opponent) {
        int damage = opponent.dealDamage();
        System.out.println(name + " took " + damage + " points of damage from " + opponent.getName());
        this.hitPoints -= damage;
    }

    /**
     * Method to be called during combat. It orchestrates the attack and damage process between
     * a character and their opponent. Do not modify this method.
     * @param opponent The target character to be attacked. This character will take damage on a successful attack.
     * @param roll The attack roll before modifiers have been applied.
     */
    public void attack(RolePlayingCharacter opponent, int roll) {
        System.out.println(name + " is now attacking " + opponent + "!");
        if (roll == AUTOMATIC_FAILURE) {
            System.out.println(name + " fumbled and missed!");
            return;
        }

        if (roll == AUTOMATIC_SUCCESS || attackIsSuccessful(opponent, roll)) {
            System.out.println(name + " scored a hit!");
            opponent.takeDamage(this);
        }
    }

    /**
     * This method determines if an attack was successful based on the total attack roll and
     * armor class of the opponent. May be overridden when necessary.
     * @param opponent
     * @param roll The attack roll before modifiers have been applied.
     * @return true if the attack is successful, false otherwise.
     */
    protected boolean attackIsSuccessful(RolePlayingCharacter opponent, int roll) {
        return calculateTotalAttackRoll(roll) >= (MAX_ATTACK_ROLL - opponent.calculateArmorClass());
    }

    /**
     * TODO Override this method in the Archer, Warrior, and Mage classes which will extend this class.
     * This method should set the hitPoints property based on the class and level of the character.
     */
    protected abstract void calculateHitPoints();

    /**
     * TODO Override this method in the Archer, Warrior, and Mage classes which will extend this class.
     * @param roll A random number between 1 and 20.
     * @return The total attack roll, which is the combination of roll and any modifiers that may be applied.
     */
    public abstract int calculateTotalAttackRoll(int roll);

    /**
     * TODO Override this method in the Archer, Warrior, and Mage classes which will extend this class.
     * @return The number of damage points that the character deals based on their class and any modifiers.
     */
    public abstract int dealDamage();

    /**
     * TODO Override this method in the Archer, Warrior, and Mage classes which will extend this class.
     * @return The calculated Armor Class for a character. The base armor class starts at edu.cscc.roleplayingclasses.Combat.BASE_ARMOR_CLASS
     * and goes down from there based on the class and level of a character.
     */
    public abstract int calculateArmorClass();
}
