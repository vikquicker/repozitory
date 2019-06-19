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
            String string = phoneList.toString();
            String[] array = str.split(" ");
            for (int i = 0; i < array.length; i++) {
                Person person = new Person();
                if (array[i] == "[a-zA-Z]") {
                    person.setName(array[i]);
                    person.getName();
                    hashSet.add(person);
                } else if (array[i] == "[0-9]" || array[i].length() <= 4) {
                    person.setId(Integer.parseInt(array[i]));
                    person.getId();
                    hashSet.add(person);
                } else if (array[i] == "[0-9]" || array[i].length() > 4) {
                    person.setPhone(Long.parseLong(array[i]));
                    person.getPhone();
                    hashSet.add(person);
                }

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
