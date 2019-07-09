package com.victor.crud;

import com.victor.Person;
import com.victor.Status;

import java.util.HashSet;
import java.util.Iterator;

public class Delete {
    public static void execute(String[] array, HashSet<Person> personSet){
        Person person;
        if (array.length != 2 || array[1].matches("\\d+")){
            System.out.println("incorrect data");
            return;
        }
        Long idToDelete = Long.parseLong(array[1]);
        Iterator<Person> iterator =  personSet.iterator();
        while(iterator.hasNext()){
            person = iterator.next();
            if (person.getId() == idToDelete){
                person.setStatusOfPerson(Status.DELETED);
            }
        }


    }
}
