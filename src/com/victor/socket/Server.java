package com.victor.socket;

import com.victor.Person;
import com.victor.io.InputOutput;
import com.victor.wrapper.Wrapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server implements Runnable {
    static ServerSocket serverSocket;
    static HashSet<Person> list;

    public Server() {
        try {
            serverSocket = new ServerSocket(6000);
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        connection();
    }

    public static void connection() {
        //Создается новое подключение с портом 6000
        try {
            System.out.println("Server started on port " + 6000);

            //ожидание ответа от клиента
            System.out.println("Waiting for client...");
            Socket client = serverSocket.accept();
            new Thread(new Server()).start();
            System.out.println("Connection complited!");

            HashSet<Person> personSet = InputOutput.readInfoFromFile("E:\\file.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            Wrapper wrapper = new Wrapper(personSet);
            objectOutputStream.writeObject(wrapper);

            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            try {
                wrapper = (Wrapper) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("server could not read clients answer...");
                e.printStackTrace();
            }
            list = wrapper.getPersonContainer();
            for (Person person : list) {
                System.out.println(person.getId() + " " + person.getName() + " " + person.getPhone());
            }
            InputOutput.writeInFile(list);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Server());
        thread.start();
    }
}
