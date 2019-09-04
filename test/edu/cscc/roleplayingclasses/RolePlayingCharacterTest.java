package edu.cscc.roleplayingclasses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RolePlayingCharacterTest {

    private TestRolePlayingCharacter testRolePlayingCharacter;
    private TestRolePlayingCharacter opponent;

    @Before
    public void setUp() {
        testRolePlayingCharacter = new TestRolePlayingCharacter("Rolo", 1);
        opponent = new TestRolePlayingCharacter("Rolo", 1);
    }

    @Test
    public void charactersCanTakeDamage() {
        testRolePlayingCharacter.takeDamage(opponent);

        assertEquals(9, testRolePlayingCharacter.getHitPoints());
    }

    @Test
    public void whenAnAttackIsSuccessfulThenTheOpponentTakesDamage() {
        testRolePlayingCharacter.attack(opponent, 15);

        assertEquals(9, opponent.getHitPoints());
    }

    @Test
    public void whenAnAttackFailsThenTheOpponentDoesNotTakeDamage() {
        testRolePlayingCharacter.attack(opponent, 1);

        assertEquals(10, opponent.getHitPoints());
    }

    @Test
    public void aRollOf1AlwaysFails() {
        opponent.setArmorClass(25);

        testRolePlayingCharacter.attack(opponent, 1);

        assertEquals(10, opponent.getHitPoints());
    }

    @Test
    public void whenARollOf20OccursTheAttackAutomaticallyHits() {
        opponent.setArmorClass(-20);
        testRolePlayingCharacter.attack(opponent, 20);

        assertEquals(9, opponent.getHitPoints());
    }

    class TestRolePlayingCharacter extends RolePlayingCharacter {

        private int armorClass = 10;

        public TestRolePlayingCharacter(String name, int level) {
            super(name, level);
        }

        @Override
        protected void calculateHitPoints() {
            this.hitPoints = 10;
        }

        @Override
        public int calculateTotalAttackRoll(int roll) {
            return roll;
        }

        @Override
        public int dealDamage() {
            return 1;
        }

        @Override
        public int calculateArmorClass() {
            return armorClass;
        }

        public void setArmorClass(int armorClass) {
            this.armorClass = armorClass;
        }
    }
}