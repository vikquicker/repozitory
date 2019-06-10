package com.victor.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void connection() {
        //Создается новое подключение с портом 6000
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            //ожидание ответа от клиента
            Socket client = serverSocket.accept();
            System.out.print("Connection complited");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
