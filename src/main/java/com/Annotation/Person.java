package com.Annotation;

public class Person {
    @RandomInt(min = 1, max = 43)
    private int age;

    public int getAge(){
        return age;
    }

}
