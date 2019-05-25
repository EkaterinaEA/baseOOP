package com.Annotation;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntProcessor {

    public static void process(Object object) throws IllegalAccessException { // sets the value of the field marked with the annotation @RandomInt

        final Class objectClass = object.getClass(); // setting the values of RandomInt using reflection
        // final - cannot be changed in the method
        final Field[] fields = objectClass.getDeclaredFields(); // get all the fields of the class to find where the annotation stands,
        // because we do not know where @
        for (Field field : fields) {
            final RandomInt annotation = field.getAnnotation(RandomInt.class);
            // final RandomInt annotation - created annotation object
            // RandomInt - class object Class for annotation
            // RandomInt.class - got a class using a literal, you can use the same with .getClass
            if(annotation != null){
                int random = new Random().nextInt(annotation.max() - annotation.min()) + annotation.min();
                // creates a value from 0 to annotation.max()
                field.setAccessible(true);
                field.set(object, random);
            }
        }

    }
}
