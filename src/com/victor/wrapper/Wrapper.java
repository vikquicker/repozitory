package com.victor.wrapper;

import com.victor.Person;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Wrapper implements Serializable {
     private HashSet<Person> personContainer;

    public HashSet<Person> getPersonContainer() {
        return personContainer;
    }

    public Wrapper(){}
    public Wrapper(HashSet<Person> personSet) {this.personContainer = personSet; }

    public void setPersonContainer(HashSet<Person> personContainer){
        this.personContainer = personContainer;
    }
}
