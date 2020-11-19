package com.petrenko.prax03;

import java.util.Random;

class Matrix {
    private int n,m;
    private boolean[][] firstMatrix, secondMatrix;

    Matrix(int nSize, int mSize) {
        n = nSize;
        m = mSize;
        firstMatrix = new boolean[n][m];
        secondMatrix = new boolean[n][m];
    }

    private void fillMatrixWithRandom(boolean[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextBoolean();
            }
        }
    }

    private void printMatrix(boolean[][] matrix, String name) {
        System.out.println(name);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((matrix[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }

    private void invertMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = !matrix[i][j];
            }
        }
        System.out.println();
    }


    private boolean[][] addMatrix(boolean[][] matrix ,boolean[][] addedMatrix) {
        boolean[][] addResult = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                addResult[i][j] = matrix[i][j] | addedMatrix[i][j];
            }
        }
        System.out.println();
        return addResult;
    }

    private boolean[][] multiplyMatrix(boolean[][] matrix ,boolean[][] multMatrix) {
        boolean[][] multResult = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                multResult[i][j] |= matrix[i][j] && multMatrix[i][j];
            }
        }

        System.out.println();
        return multResult;
    }

    private void countOnesInMatrix(boolean[][] matrix, String name){
        System.out.print(name + " ");
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j]) count++;
            }
        }
        System.out.println(count);
    }


    void run() {
        fillMatrixWithRandom(firstMatrix);
        printMatrix(firstMatrix, "First Matrix");
        fillMatrixWithRandom(secondMatrix);
        printMatrix(secondMatrix, "Second Matrix");
        invertMatrix(firstMatrix);
        printMatrix(firstMatrix, "First matrix after inversion");
        invertMatrix(secondMatrix);
        printMatrix(secondMatrix, "Second matrix after inversion");
        printMatrix(addMatrix(firstMatrix,secondMatrix), "Result of addition of two inverted matrixes");
        printMatrix(multiplyMatrix(firstMatrix,secondMatrix),"Result of multiplication of two inverted matrixes");
        invertMatrix(firstMatrix);
        countOnesInMatrix(firstMatrix,"Ones in first matrix");
    }
}

public class BooleanMatrix {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(7,7);
        matrix.run();
    }
}
