package com.petrenko.lab0222;

import java.util.HashSet;

public class IntegerDeposit {
    public HashSet<Integer> deposit = new HashSet<Integer>();

    public void addInteger(int number) {
        deposit.add(number);
        System.out.printf("Added integer: %d ", number);
    }

    public void removeInteger(int number) {
        if (deposit.contains(number)) {
            deposit.remove(number);
            System.out.printf("Removed integer: %d ", number);
        } else {
            System.out.println("Sorry, there's no such number");
        }
    }

    public void checkDeposit() {
        System.out.println("Current deposit includes:");

        for(Integer item: this.deposit){
            System.out.println(item);
        }
    }

    public void findInteger(int number) {

    }
}
