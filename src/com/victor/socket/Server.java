package com.victor.socket;

import com.victor.io.InputOutput;

import java.io.IOException;
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
            System.out.print("Waiting for client");
            Socket client = serverSocket.accept();
            System.out.print("Connection complited");

            List<String> str = InputOutput.readInfoFromFile("C:\\file");
            PrintWriter printWriter = new PrintWriter(client.getOutputStream());
            printWriter.println(str.get(0));

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server.connection();
    }
}
