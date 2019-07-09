package com.victor.socket;

import com.victor.Person;
import com.victor.Status;
import com.victor.io.InputOutput;
import com.victor.wrapper.Wrapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Server implements Runnable {
    static ServerSocket serverSocket;
    static HashSet<Person> list;
    static HashSet<Person> clientList;

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

    public void connection() {
        Wrapper wrapper = new Wrapper();
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
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());

            ///
            wrapper.setPersonContainer(personSet);
            objectOutputStream.writeObject(wrapper);
            try {
                wrapper = (Wrapper) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("server could not read clients answer...");
                e.printStackTrace();
            }
            clientList = wrapper.getPersonContainer();
            for (Person person : clientList) {
                System.out.println(person.getId() + " " + person.getName() + " " + person.getPhone());
            }
            mergeList(clientList);
            InputOutput.writeInFile(list);
            ///
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mergeList(HashSet<Person> clientSet) {
        for (Person element : clientSet) {
            if (element.getStatusOfPerson().equals(Status.ADDED)){
                element.setStatusOfPerson(null);
                list.add(element);
            }else if(element.getStatusOfPerson().equals(Status.DELETED)){
                Iterator<Person> iterator =  clientSet.iterator();
                Person person;
                while(iterator.hasNext()){
                    person = iterator.next();
                    if (person.getId() == element.getId()){
                        list.remove(person);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Server());
        thread.start();
    }
}
