package com.PackageReflection.ClassFinder;

import com.PackageReflection.ClassFinder.ClassFinder;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Class<?>> classes = ClassFinder.find("PackageReflection.PackageExample");
        System.out.println(classes.isEmpty());
        System.out.println(classes.toString());
    }
}
