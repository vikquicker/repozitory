package com.victor.socket;

import com.victor.io.InputOutput;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void connection() {
        //Создается новое подключение с портом 6000
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server started on port " + 6000);

            //ожидание ответа от клиента
            System.out.println("Waiting for client...");
            Socket client = serverSocket.accept();
            System.out.println("Connection complited!");

            List<String> str = InputOutput.readInfoFromFile("E:\\file.txt");
            synchronized (str) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
                objectOutputStream.writeObject(str);

                objectOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Client.go();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (true) {
                Server.connection();
//                }
            }
        });
        thread2.start();
        thread1.start();
    }
}
