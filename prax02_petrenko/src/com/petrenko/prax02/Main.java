package com.petrenko.prax02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Please enter the size of the future matrix: ");
        Scanner sc = new Scanner(System.in);
        String sizeTmp = sc.next();
        int size = Matrix.checkSize(sizeTmp);
        int[][] matrix = Matrix.createMatrix(size);
        System.out.println("Generated matrix: ");
        Matrix.printMatrix(matrix);

        System.out.println("Sorted matrix by line increment sum: ");
        Matrix.printMatrix((Matrix.sortByLineSum(matrix)));
    }
}
