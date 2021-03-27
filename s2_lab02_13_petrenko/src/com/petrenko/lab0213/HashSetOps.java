package com.petrenko.lab0213;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class HashSetOps {
    public HashSet<String> set = new HashSet<String>();

    public HashSetOps() {
        Scanner s = null;
        try {
            s = new Scanner(new File("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNext()){
            this.set.add(s.next().toLowerCase(Locale.ROOT));
        }
        s.close();
    }

    public void printSet() {
        System.out.println("Current set for text.txt:");

        for(String item: this.set){
            System.out.println(item);
        }
    }
}
