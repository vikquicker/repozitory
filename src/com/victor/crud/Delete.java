package com.victor.crud;

import com.victor.Person;

import java.util.HashSet;
import java.util.Iterator;

public class Delete {
    public static void execute(String[] array, HashSet<Person> personSet){
        if (array.length != 2 || array[1].matches("\\d{1,}")){
            System.out.println("incorrect data");
            return;
        }
        Long idToDelete = Long.parseLong(array[1]);
        Iterator<Person> iterator =  personSet.iterator();
        while(iterator.hasNext()){
            if (iterator.next().getId() == idToDelete){

            }
        }


    }
}
