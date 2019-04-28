package com.victor.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutput {
    List<String> writeInfoFromFile(String fileName){
        List<String> phoneList = new ArrayList<>();
        String str;
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            while((str = in.readLine()) != null){
                phoneList.add(str);
            }

        }catch(FileNotFoundException e1){
            System.out.println("file not found!");
            e1.printStackTrace();

        }catch (IOException e){
            System.out.println("io exception!");
            e.printStackTrace();
        }
        return phoneList;
    }


}
