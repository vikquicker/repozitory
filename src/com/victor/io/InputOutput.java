package com.victor.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutput {
    //метод который читает из файла и сохраняет данные в коллекцию
    public static List<String> readInfoFromFile(String fileName) {
        //создается коллекция для хранения телефонов
        List<String> phoneList = new ArrayList<>();
        String str;
        //создается поток для чтения из файла (try-with-resourses)
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            //условие - если строка не равна null то цикл продолжить работать дальше
            while ((str = in.readLine()) != null) {
                phoneList.add(str);
            }

        } catch (FileNotFoundException e1) {
            System.out.println("file not found!");
            e1.printStackTrace();

        } catch (IOException e) {
            System.out.println("io exception!");
            e.printStackTrace();
        }
        return phoneList;
    }

    public static void writeInFile(String str) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\file"))) {
            bufferedWriter.write(str);
        } catch (FileNotFoundException e1) {
            System.out.println("file not found!");
            e1.printStackTrace();

        } catch (IOException e) {
            System.out.println("io exception!");
            e.printStackTrace();
        }
    }
}
