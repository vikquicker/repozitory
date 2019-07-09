package com.victor;

import java.io.Serializable;

public class Person implements Serializable {
    private long id;
    private String name;
    private long phone;
    private Status statusOfPerson;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Status getStatusOfPerson(){
        return this.statusOfPerson;
    }

    public void  setStatusOfPerson(Status status){
        this.statusOfPerson = status;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id && phone == person.phone && name == person.name;
    }
}
