package com.WorkWithFile;

import java.io.*;

public class ReadLine {

    public static void main(String[] args) {
        try{
            FileInputStream stream = new FileInputStream("C:\\Users\\Екатерина\\IdeaProjects\\Romeo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }
}
