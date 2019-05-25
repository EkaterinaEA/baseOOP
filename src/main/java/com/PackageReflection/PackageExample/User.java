package com.PackageReflection.PackageExample;

public class User {
    private String nameUser;

    @RandomInt(min = 1, max = 100)
    private int numberUser;

    private int userIP;

    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", numberUser=" + numberUser +
                ", userIP=" + userIP +
                '}';
    }

}