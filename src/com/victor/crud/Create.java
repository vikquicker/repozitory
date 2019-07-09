package com.victor.crud;

import com.victor.Person;
import com.victor.Status;

import java.util.HashSet;

public class Create {
//CREATE dfgdg 123321
    public static void execute(String[] array, HashSet<Person> personSet) {
        if (array.length != 3 || array[1] == null || array[2] == null) {
            System.out.println("incorrect data...");
            return;
        }
        if ("CREATE".equals(array[0]) && array[1].matches("[a-zA-Z]+") && array[2].matches("\\d+")) {
            Person person = new Person();
            person.setId(findMatch(personSet) + 1);
            person.setName(array[1]);
            person.setPhone(Long.parseLong(array[2]));
            person.setStatusOfPerson(Status.ADDED);
            personSet.add(person);
        } else
            System.out.println("incorrect data...");
    }

    public static long findMatch(HashSet<Person> personHashMap) {
        long x = 0;
        for (Person person : personHashMap) {
            if (person.getId() > x) {
                x = person.getId();
            }
        }
        return x;
    }
}
