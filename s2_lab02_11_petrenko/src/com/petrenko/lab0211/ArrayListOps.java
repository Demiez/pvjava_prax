package com.petrenko.lab0211;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListOps {
    public ArrayList<String> list = new ArrayList<String>();

    public ArrayListOps () {
        Scanner s = null;
        try {
            s = new Scanner(new File("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine()){
            this.list.add(s.nextLine());
        }
        s.close();
    }

    public void sortStrings () {
        System.out.println("Before Sorting:");
        printList(this.list);

        Collections.sort(this.list);

        System.out.println("After Sorting:");
        printList(this.list);
    }

    private void printList(ArrayList<String> listToPrint) {
        for(String item: list){
            System.out.println(item);
        }
        System.out.println("\n");
    }
}
