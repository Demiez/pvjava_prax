package com.petrenko.prax07;

import java.util.ArrayList;
import java.util.List;

public class Cipher {
    public static void cipherString(String stringToCipher)
    {
        List<Character> characterList = new ArrayList<Character>();

        for(char c : stringToCipher.toCharArray()) {
            characterList.add(c);
        }

        StringBuilder strBuilder = new StringBuilder("");

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < characterList.size()-i; j+=3){
                strBuilder.append(characterList.get(i+j));
            }
        }

        System.out.printf("Code of the provided text is:\n \n%s", strBuilder.toString());
    }
}
