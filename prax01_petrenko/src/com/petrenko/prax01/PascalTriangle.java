package com.petrenko.prax01;

import static com.petrenko.prax01.HelperFunctions.print;
import static com.petrenko.prax01.HelperFunctions.println;

public class PascalTriangle {

  public static int getFirstPositiveNumber(int[] sourceNumbers) {
    for (int sourceNumber : sourceNumbers) {
      if (sourceNumber > 0) {
        return sourceNumber;
      }
    }
    return 0;
  }

  public static void buildPascalTriangle(
      int[] sourceNumbers) {
    final int firstPositiveNumber = getFirstPositiveNumber(sourceNumbers);
    final String message = "Pascal Triangle for first positive number: ";
    if (firstPositiveNumber == 0) {
      println(message + "Sorry, there's no numbers > 0");
    }
    final int rows = 5;
    println(message);
    for (int y = 0; y < rows; y++) {
      int c = firstPositiveNumber;
      for (int i = 0; i < rows - y; i++) {
        print("   ");
      }
      for (int x = 0; x <= y; x++) {
        print("   " + c + " ");
        c = c * (y - x) / (x + 1);
      }

      println();
    }
  }
}
