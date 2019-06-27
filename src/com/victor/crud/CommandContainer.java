package com.victor.crud;

import com.victor.Person;

import java.util.HashSet;
import java.util.Scanner;

public class CommandContainer {
    private static CommandContainer instance;

    public static void waitCommand(HashSet<Person> hashSet) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("waiting for command...");
            String input = scanner.nextLine();
            String[] splitedCommand = input.split(" ");
            switch (splitedCommand[0]) {
                case "CREATE":
                    Create.execute(splitedCommand, hashSet);
                    break;
                case "DELETE":
                    Delete.execute(splitedCommand, hashSet);
                    break;
                case "CLOSE":
                    Close.execute();
                    break;
                default:
                    System.out.println("incorrect data");
                    break;
            }
            for (Person person : hashSet) {
                System.out.println(person.getId() + " " + person.getName() + " " + person.getPhone());
            }
        }
    }

    private CommandContainer() {
    }

    public static CommandContainer getInstance() {
        if (instance == null) {
            instance = new CommandContainer();
        }
        return instance;
    }
}
