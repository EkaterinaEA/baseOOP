package com.DataSerialization;


import java.io.*;
import java.lang.reflect.Field;

public class DataSerialization {

    public static void main(String[] args) throws IOException {

        //   String fileName = "C:\\JavaProjects\\file.txt";

        String line = "";

        try {
            FileReader file = new FileReader("C:\\JavaProjects\\file.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                String items[] = line.split(",");

                Monitor monitor = new Monitor();
                Class userMonitor = monitor.getClass();
                Field nameField = userMonitor.getDeclaredField("name");
                nameField.setAccessible(true);
                nameField.set(monitor, items[1]);

                Field modelField = userMonitor.getDeclaredField("model");
                modelField.setAccessible(true);
                modelField.set(monitor, items[2]);

                Field priceField = userMonitor.getDeclaredField("price");
                priceField.setAccessible(true);
                priceField.set(monitor, Integer.parseInt(items[3]));

                System.out.println("object: " + items[0].toString() + "\nname: " + monitor.getName() +
                        "\nmodel: " + monitor.getModel() + "\nprice: " + monitor.getPrice());

                bufferedReader.close();

            }
        } catch (IOException e){
            System.out.println();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
