package edu.cscc.roleplayingclasses;

import java.lang.reflect.InvocationTargetException;

public class TestHelpers {

    protected Object callGetHitPoints(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("getHitPoints").invoke(object);
    }

    protected Object callDealDamage(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("dealDamage").invoke(object);
    }

    protected Object callCalculateArmorClass(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("calculateArmorClass").invoke(object);
    }

    protected Object callCalculateTotalAttackRoll(Object object, int roll) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("calculateTotalAttackRoll", int.class).invoke(object, roll);
    }

    protected boolean callAttackIsSuccessful(Object object, Object opponent, int roll) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (boolean) object.getClass().getMethod("attackIsSuccessful", RolePlayingCharacter.class, int.class).invoke(object, opponent, roll);
    }

    protected Object createObjectForClass(String name, int level, String className) throws ClassNotFoundException, NoSuchMethodException {
        Class klass = Class.forName(className);
        try {
            return klass.getConstructor(String.class, int.class).newInstance(name, level);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
