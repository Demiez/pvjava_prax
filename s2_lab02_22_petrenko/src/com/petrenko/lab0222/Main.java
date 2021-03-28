package com.petrenko.lab0222;

import java.io.Console;
import java.util.Locale;
import java.util.TreeSet;

public class Main {
    public static void main(String... args){
        IntegerDeposit deposit = new IntegerDeposit();
        Console console = System.console();
        String input;

        do {
            input = console.readLine("Please make your input - {command} {value}: ").trim().toLowerCase(Locale.ROOT);
            String[] params = input.split(" ");
            int value = params.length == 2 ? Integer.parseInt(params[1]) : 0;

            switch (params[0]) {
                case "add":
                    deposit.addInteger(value);
                    break;
                case "del":
                    deposit.removeInteger(value);
                    break;
                case "check":
                    deposit.checkDeposit();
                    break;
                case "find":
                    deposit.findInteger(value);
                    break;
            }
        } while (!input.equals("exit"));

        console.printf("Bye.");
    }
}

class IntegerDeposit {
    public TreeSet<Integer> deposit = new TreeSet<Integer>();

    public void addInteger(int number) {
        deposit.add(number);
        System.out.printf("Added integer: %d \n", number);
    }

    public void removeInteger(int number) {
        if (deposit.contains(number)) {
            deposit.remove(number);
            System.out.printf("Removed integer: %d \n", number);
        } else {
            System.out.println("Sorry, there's no such number \n");
        }
    }

    public void checkDeposit() {
        System.out.println("Current deposit includes:");

        for(Integer item: this.deposit){
            System.out.println(item);
        }
    }

    public void findInteger(int number) {
        if (deposit.contains(number)) {
            System.out.printf("Found your integer: %d \n", number);
        } else {
            var result = deposit.floor(number);

            if (result == null) {
                System.out.println("Sorry, couldn't find any number");
            } else {
                System.out.printf("Found closest integer by module: %d \n", result);
            }
        }
    }
}