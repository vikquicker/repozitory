package com.victor.crud;

import com.victor.Person;

import java.util.HashSet;
import java.util.Random;
import java.util.regex.Pattern;

public class Create {
    public static void execute(String[] array, HashSet<Person> personSet) {
        if (array[0].equals("CREATE") && array[1].matches("[a-zA-Z]") && array[2].matches("[0-9]")) {
            Random random = new Random();
            Person person = new Person();
            person.setId(random.nextInt(3900) + 1 + random.nextInt(100) + 1);
            person.setName(array[1]);
            person.setPhone(Long.parseLong(array[2]));
            personSet.add(person);
        } else
            System.out.println("incorrect data...");
    }
}
