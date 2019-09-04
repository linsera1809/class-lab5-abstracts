package edu.cscc.roleplayingclasses;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class ArcherTest extends TestHelpers {

    private static final String ARCHER_NAME = "Robin";
    private static final String ARCHER_CLASSNAME = "edu.cscc.roleplayingclasses.Archer";

    @Test
    public void aLevel1ArcherHas6HitPoints() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 1, ARCHER_CLASSNAME);

        assertEquals(6, callGetHitPoints(archer));
    }

    @Test
    public void aArcherHas6HitPointsPerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 5, ARCHER_CLASSNAME);

        assertEquals(30, callGetHitPoints(archer));
    }

    @Test
    public void aLevel1ArcherGetsNoBonusToAttack() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Object archer = createObjectForClass(ARCHER_NAME, 1, ARCHER_CLASSNAME);

        assertEquals(9, callCalculateTotalAttackRoll(archer, 9));
    }

    @Test
    public void aArcherGetsPlus1BonusToAttackPerTwoLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 4, ARCHER_CLASSNAME);

        assertEquals(7, callCalculateTotalAttackRoll(archer, 5));
    }

    @Test
    public void aLevel1ArcherDeals1PointsOfDamagePerAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 1, ARCHER_CLASSNAME);

        assertEquals(1, callDealDamage(archer));
    }

    @Test
    public void aArcherDeals2PointsOfDamagePerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 5, ARCHER_CLASSNAME);

        assertEquals(5, callDealDamage(archer));
    }

    @Test
    public void aLevel1ArcherStartsWithAnArmorClassOf10() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 1, ARCHER_CLASSNAME);

        assertEquals(10, callCalculateArmorClass(archer));
    }

    @Test
    public void aArchersArmorClassGoesDown1PointPerTwoLevels() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object archer = createObjectForClass(ARCHER_NAME, 5, ARCHER_CLASSNAME);

        assertEquals(8, callCalculateArmorClass(archer));
    }
}