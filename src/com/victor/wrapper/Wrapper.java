package com.victor.wrapper;

import com.victor.Person;

import java.io.Serializable;
import java.util.HashSet;

public class Wrapper implements Serializable {
    HashSet<Person> personContainer;

    public HashSet<Person> getPersonContainer() {
        return personContainer;
    }

    public Wrapper(HashSet<Person> personSet) {
        this.personContainer = personSet;
    }
}
