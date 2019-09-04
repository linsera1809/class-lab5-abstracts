package edu.cscc.roleplayingclasses;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class WarriorTest extends TestHelpers {

    private static final String WARRIOR_NAME = "Conan";
    private static final String WARRIOR_CLASSNAME = "edu.cscc.roleplayingclasses.Warrior";

    @Test
    public void aLevel1WarriorHas10HitPoints() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 1, WARRIOR_CLASSNAME);

        assertEquals(10, callGetHitPoints(warrior));
    }

    @Test
    public void aWarriorHas10HitPointsPerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 5, WARRIOR_CLASSNAME);

        assertEquals(50, callGetHitPoints(warrior));
    }

    @Test
    public void aLevel1WarriorGetsPlus1BonusToAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 1, WARRIOR_CLASSNAME);

        assertEquals(10, callCalculateTotalAttackRoll(warrior, 9));
    }

    @Test
    public void aWarriorGetsPlus1BonusToAttackPerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 5, WARRIOR_CLASSNAME);

        assertEquals(10, callCalculateTotalAttackRoll(warrior, 5));
    }

    @Test
    public void aLevel1WarriorDeals2PointsOfDamagePerAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 1, WARRIOR_CLASSNAME);

        assertEquals(2, callDealDamage(warrior));
    }

    @Test
    public void aWarriorDeals2PointsOfDamagePerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 5, WARRIOR_CLASSNAME);

        assertEquals(10, callDealDamage(warrior));
    }

    @Test
    public void aLevel1WarriorStartsWithAnArmorClassOf9() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 1, WARRIOR_CLASSNAME);

        assertEquals(9, callCalculateArmorClass(warrior));
    }

    @Test
    public void aWarriorsArmorClassGoesDown1PointPerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object warrior = createObjectForClass(WARRIOR_NAME, 5, WARRIOR_CLASSNAME);

        assertEquals(5, callCalculateArmorClass(warrior));
    }
}
