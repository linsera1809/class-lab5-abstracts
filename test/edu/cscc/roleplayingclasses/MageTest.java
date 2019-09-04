package edu.cscc.roleplayingclasses;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MageTest extends TestHelpers {
    private static final String MAGE_NAME = "Merlin";
    private static final String MAGE_CLASSNAME = "edu.cscc.roleplayingclasses.Mage";

    @Test
    public void aLevel1MageHas4HitPoints() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 1, MAGE_CLASSNAME);

        assertEquals(4, callGetHitPoints(mage));
    }

    @Test
    public void aMageHas4HitPointsPerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 5, MAGE_CLASSNAME);

        assertEquals(20, callGetHitPoints(mage));
    }

    @Test
    public void aLevel1MageGetsNoBonusToAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 1, MAGE_CLASSNAME);

        assertEquals(10, callCalculateTotalAttackRoll(mage, 10));
    }

    @Test
    public void aLevel1MageDeals2PointsOfDamagePerAttack() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 1, MAGE_CLASSNAME);

        assertEquals(2, callDealDamage(mage));
    }

    @Test
    public void aMageDeals2PointsOfDamagePerLevel() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 5, MAGE_CLASSNAME);

        assertEquals(10, callDealDamage(mage));
    }

    @Test
    public void aLevel1MageStartsWithAnArmorClassOf10() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 1, MAGE_CLASSNAME);

        assertEquals(10, callCalculateArmorClass(mage));
    }

    @Test
    public void aMagesArmorClassGoesDown1PointPerFourLevels() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 8, MAGE_CLASSNAME);

        assertEquals(8, callCalculateArmorClass(mage));
    }

    @Test
    public void mageAttacksAreAlwaysSuccessful() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 1, MAGE_CLASSNAME);

        Object opponent = createObjectForClass("Xanatos", 2, MAGE_CLASSNAME);
        assertTrue(callAttackIsSuccessful(mage, opponent, 2));
    }

    @Test
    public void damageTakenFromAnotherMageIsHalved() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object mage = createObjectForClass(MAGE_NAME, 4, MAGE_CLASSNAME);
        Object opponent = createObjectForClass("Xanatos", 4, MAGE_CLASSNAME);

        int roll = 20;
        RolePlayingCharacter rolePlayingCharacter = (RolePlayingCharacter) opponent;
        rolePlayingCharacter.attack((RolePlayingCharacter)mage, roll);

        assertEquals(12, callGetHitPoints(mage));
    }
}