package com.victor.crud;

import com.victor.Person;

import java.util.HashSet;
import java.util.Scanner;

public class CommandContainer {
    private static CommandContainer instance;

    public static void waitCommand(HashSet<Person> hashSet) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitedCommand = input.split(" ");
        switch (splitedCommand[0]) {
            case "CREATE":
                Create.execute(splitedCommand,hashSet);
                break;
            case "DELETE":
                Delete.execute(splitedCommand,hashSet);
                break;
            case "CLOSE":
                Close.execute();
                break;
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
