package com.victor.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void go() {
        try {
            Socket socket = new Socket("localhost", 6000);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(objectInputStream);

            String str = bufferedInputStream.toString();
            System.out.println(str);

            objectInputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            System.out.println("Connection Failed");
        }
    }
}
//