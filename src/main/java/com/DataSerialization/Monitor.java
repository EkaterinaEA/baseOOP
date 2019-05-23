package com.DataSerialization;

public class Monitor {

    private String name;
    private String model;
    private int price;

    public Monitor(String name, String model, int price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public Monitor() {
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}
