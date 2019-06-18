package com.victor.socket;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    static List<String> list;
    public static void go() {
        try {
            Socket socket = new Socket("localhost", 6000);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            try {
                list = (List<String>) objectInputStream.readObject();
                System.out.println(list.get(0));
                objectInputStream.close();
            } catch(Exception e){

            }



           // objectInputStream.close();

        } catch (IOException e) {
            System.out.println("Connection Failed");
        }

    }

    public static void main(String[] args) {
        Client.go();
    }
}
//