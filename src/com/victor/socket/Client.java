package com.victor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void go() {
        try {
            Socket socket = new Socket("localhost", 6000);
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = bufferedReader.readLine();
            System.out.println(str);

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Connection Failed");
        }
    }
}
