package com.petrenko.prax01;

import java.util.*;

import static com.petrenko.prax01.HelperFunctions.print;

public class Main {
    private static int[] convertToArray(Collection<Integer> list) {
        int[] result = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            result[i] = it.next();
        }
        return result;
    }

    private static int[] readInput(Scanner sc) {
        List<Integer> input = new ArrayList<Integer>();
        print("Input integers with space, after finish enter q: ");
        while (sc.hasNext()) {
            String number = sc.next();
            if (number.equals("q")) {
                break;
            } else {
                try {
                    input.add(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                    System.err.println("Bad format: " + e + "\n");
                }
            }
        }
        return convertToArray(input);
    }

    public static void main(String[] args) {
        int[] numbers = readInput(new Scanner(System.in));
        PascalTriangle.buildPascalTriangle(numbers);
    }
}
