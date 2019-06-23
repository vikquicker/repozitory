package com.victor.socket;

import com.victor.Person;
import com.victor.wrapper.Wrapper;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Client {
    static HashSet<Person> list;
    static Wrapper wrapper = new Wrapper(list);
    public static void go() {
        try {
            Socket socket = new Socket("localhost", 6000);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            try {
                wrapper = (Wrapper) objectInputStream.readObject();

                System.out.println(wrapper);
                objectInputStream.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Connection Failed");
        }

    }

    public static void main(String[] args) {
        Client.go();
    }
}