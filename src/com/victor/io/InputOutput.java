package com.victor.io;

import com.victor.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class InputOutput {
    //метод который читает из файла и сохраняет данные в коллекцию
    public static HashSet<Person> readInfoFromFile(String fileName) {
        //создается коллекция для хранения телефонов
        List<String> phoneList = new ArrayList<>();
        HashSet<Person> hashSet = new HashSet<>();
        String str;
        //создается поток для чтения из файла (try-with-resourses)
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            //условие - если строка не равна null то цикл продолжить работать дальше
            while ((str = in.readLine()) != null) {
                phoneList.add(str);
            }
            for (String list : phoneList) {
                Person person = new Person();
                String[] array = list.split(" ");
                person.setId(Integer.parseInt(array[0]));
                person.setName((array[1]));
                person.setPhone(Integer.parseInt(array[2]));
                hashSet.add(person);
            }
        } catch (FileNotFoundException e1) {
            System.out.println("file not found!");
            e1.printStackTrace();

        } catch (IOException e) {
            System.out.println("io exception!");
            e.printStackTrace();
        }
        return hashSet;
    }

    public static void writeInFile(HashSet<Person> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\file.txt"))) {
            bufferedWriter.write(String.valueOf(list));
            Iterator<Person> iterator = list.iterator();
            while (iterator.hasNext()) {
                Person person = iterator.next();
                bufferedWriter.write(person.toString());
                bufferedWriter.newLine();
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
