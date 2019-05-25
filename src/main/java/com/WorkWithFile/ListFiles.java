package com.WorkWithFile;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File dir = new File ("C:\\Users\\Екатерина\\IdeaProjects");
        if (dir.exists()){
            String[] files = dir.list();
            System.out.println(files.length + " файлов найдено");
            for (int i = 0; i<files.length;  i++){
                System.out.println(files[i]);
            }
        }
        else{
            System.out.println("Каталог не найден");
        }

    }
}
