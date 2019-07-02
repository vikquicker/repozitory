package com.victor.crud;


import com.victor.Person;
import com.victor.wrapper.Wrapper;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;

public class Close {

    public static void execute(String[] array, HashSet<Person> hashSet,Socket socket) throws IOException {
        if (array.length > 1) {
            System.out.println("incorrect data...");
            return;
        }
        Wrapper wrapper = new Wrapper(hashSet);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(wrapper);
        objectOutputStream.close();
        System.exit(0);
    }
}
