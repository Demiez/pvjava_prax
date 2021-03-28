package com.petrenko.lab0222;

import java.io.Console;
import java.util.Locale;

public class Main {

    public static void main(String... args){
        IntegerDeposit deposit = new IntegerDeposit();
        Console console = System.console();
        String input;

        do {
            input = console.readLine("Please make your input - {command} {value}: ").trim().toLowerCase(Locale.ROOT);
            String[] params = input.split(" ");
            int value = Integer.parseInt(params[1]);

            switch (params[0]) {
                case "add":
                    deposit.addInteger(value);
                    break;
                case "check":
                    deposit.checkDeposit();
                    break;

            }
        } while (!input.equals("exit"));



        console.printf("Bye.");
    }
}
