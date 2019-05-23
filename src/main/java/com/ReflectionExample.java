package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User("Ekaterina", "Krasnova");
        Class userClass = user.getClass();

        Field nameField = userClass.getDeclaredField("name");

        nameField.getName();

        System.out.println("Before: " + user.getName());

        nameField.setAccessible(true);
        nameField.set(user, "Kate");
        System.out.println("After: " + user.getName());

        Method method = userClass.getDeclaredMethod("concatString");
        method.setAccessible(true);
        String s = (String) method.invoke(user);

        System.out.println(s);

    }
}
