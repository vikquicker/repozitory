package com.victor.socket;

import com.victor.io.InputOutput;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void connection() {
        //Создается новое подключение с портом 6000
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server started on port " + 6000);
            //ожидание ответа от клиента
            System.out.print("Waiting for client");
            Socket client = serverSocket.accept();
            System.out.print("Connection complited");
            InputOutput.readInfoFromFile("file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
