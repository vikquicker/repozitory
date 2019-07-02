package com.victor.socket;

import com.victor.Person;
import com.victor.crud.CommandContainer;
import com.victor.wrapper.Wrapper;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;


public class Client {
    static HashSet<Person> list;
    static Wrapper wrapper;

    public static void go() throws IOException {
        try {
            Socket socket = new Socket("localhost", 6000);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            try {
                wrapper = (Wrapper) objectInputStream.readObject();
                list = wrapper.getPersonContainer();
                for (Person person : list) {
                    System.out.println(person.getId() + " " + person.getName() + " " + person.getPhone());
                }
                CommandContainer.waitCommand(list,socket);
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Connection Failed");
        }
    }

    public static void main(String[] args) throws IOException {
        Client.go();
    }
}