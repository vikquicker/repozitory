package com.victor.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
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

    public static void writeInFile(List<String> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\file.txt"))) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                bufferedWriter.write(String.valueOf(iterator));
            }
        } catch (FileNotFoundException e1) {
            System.out.println("file not found!");
            e1.printStackTrace();

        } catch (IOException e) {
            System.out.println("io exception!");
            e.printStackTrace();
        }
    }
}
