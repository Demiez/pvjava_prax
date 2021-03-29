package com.petrenko.lab0232;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {
    public HashMap<Long,String> book = new HashMap<>();

    public void addPhone (long phoneNumber, String surname) {
        this.book.put(phoneNumber, surname);
    }

    public void removePhone (long phoneNumber) {
        if (this.book.containsKey(phoneNumber)) {
            this.book.remove(phoneNumber);
            System.out.printf("Removed: %d \n", phoneNumber);
        } else {
            System.out.println("Can't find number");
        }
    }

    public void checkAll () {
        System.out.println("Current notes in phoneBook: ");
        System.out.println(book);
    }

    public void fingByNumber(long phoneNumber) {
        if (this.book.containsKey(phoneNumber)) {
            System.out.printf("Such number exists, it belongs to: %s \n", this.book.get(phoneNumber));
        } else {
            System.out.println("Can't find number");
        }
    }

    public void findBySurname(String surname) {
        if (this.book.containsValue(surname)) {
            System.out.println("Such surname exists, the notes are:");
            Iterator it = this.book.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (pair.getValue() == surname) {
                    System.out.println(pair.getKey() + " = " + pair.getValue());
                }
                it.remove();
            }
        } else {
            System.out.println("Can't find surname");
        }
    }
}
