package com.petrenko.prax02;

import java.util.Arrays;

public class Matrix {
  public static int checkSize (String x) throws IllegalArgumentException, NumberFormatException {
    int tmp;
    try {
      tmp = Integer.parseInt(x);
    } catch (Exception e) {
      throw e;
    }
    if (tmp < 0) {
      throw new IllegalArgumentException("Dimension can't be < 0");
    }
    return tmp;
  }

  public static int[][] createMatrix (int size) {
    int matrix[][] = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int rnd = (int) (Math.random() * (2 * size + 1)) - size;
        matrix[i][j] = rnd;
      }
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0, n = matrix.length; i < n; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  private static void swap(int[][] matrixSort, int j) {
    int[] tmp = matrixSort[j];
    matrixSort[j] = matrixSort[j + 1];
    matrixSort[j + 1] = tmp;
  }

  private static int sumLine(int[][] matrix, int line) {
    int result = 0;
    for (int i = 0; i < matrix.length; i++) {
      result = result + matrix[line][i];
    }
    return result;
  }

  public static int[][] sortByLineSum(int[][] matrix) {
    int[][] matrixSort = matrix.clone();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length - i - 1; j++) {
        if (sumLine(matrixSort, j) > sumLine(matrixSort, j + 1)) {
          swap(matrixSort, j);
        }
      }
    }
    return matrixSort;
  }
}
