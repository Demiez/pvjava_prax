package com.petrenko.prax;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileOps {
    public ArrayList<String> list = new ArrayList<String>();

    public FileOps() {
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

    public void reverseList () {
        System.out.println("Before Reverse:");
        printList(this.list);

        Collections.reverse(this.list);

        System.out.println("After Reverse:");
        printList(this.list);
    }

    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("text1.txt",StandardCharsets.UTF_8);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(String item: this.list){
            printWriter.print(item + "\n");
        }

        printWriter.close();
    }

    private void printList(ArrayList<String> listToPrint) {
        for(String item: listToPrint){
            System.out.println(item);
        }
        System.out.println("\n");
    }
}
