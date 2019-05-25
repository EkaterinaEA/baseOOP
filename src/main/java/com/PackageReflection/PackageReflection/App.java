package com.PackageReflection.PackageReflection;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<Class<?>> classesForPackage = GetClassesForPackage.getClassesForPackage("PackageReflection.PackageExample");
        System.out.println(classesForPackage.isEmpty());

    }
}
