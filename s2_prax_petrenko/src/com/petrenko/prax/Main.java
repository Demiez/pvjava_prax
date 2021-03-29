package com.petrenko.prax;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOps fo  = new FileOps();
        fo.reverseList();
        fo.writeToFile();
    }
}
