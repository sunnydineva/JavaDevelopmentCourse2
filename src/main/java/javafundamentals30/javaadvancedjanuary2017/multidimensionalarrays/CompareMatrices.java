package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class CompareMatrices
{
    //Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element. 
    // For better code reusability, you could make the comparison in a method that returns true if they are equal and false if not.
    //Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix 
    // and C – the number of columns – followed by R lines containing the C numbers, separated by spaces 
    // (each line will have an equal amount of numbers.
    //The matrices will have at most 10 rows and at most 10 columns.
    //Print "equal" if the matrices match and "not equal" if they don't match.
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        int[][] matrixA = readMatrix(scanner);
        int[][] matrixB = readMatrix(scanner);

        boolean isEqual = isEqual(matrixA, matrixB);

        System.out.println(isEqual ? "equal" : "not equal");
    }

    private static boolean isEqual(int[][] matrixA, int[][] matrixB)
    {
        boolean isEqual = true;

        // Проверяваме дали матриците имат еднакъв брой редове и колони
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            isEqual = false;
        } else {
            // Обхождаме всеки ред от двете матрици и ги сравняваме
            for (int i = 0; i < matrixA.length; i++) { //пatrixA.length - броя на редовете в матрицата matrixA
                for (int j = 0; j < matrixA[i].length; j++) { //matrixA[i].length -  броя на елементите в i-тия ред на матрицата
                    // Ако намерим разлика, матриците не са еднакви
                    if (matrixA[i][j] != matrixB[i][j]) {
                        isEqual = false;
                        break; // Прекратяваме проверката на този ред
                    }
                }
                // Ако сме открили разлика, прекратяваме проверката на останалите редове
                if (!isEqual) {
                    break;
                }
            }
        }
        return isEqual;
    }

    private static int [][] readMatrix(Scanner scanner)
    {
        String[] dim = scanner.nextLine().split("\\s+");
        int R = Integer.parseInt(dim[0]);
        int C = Integer.parseInt(dim[1]);

        int [][] matrix = new int[R][C];

        for (int row = 0; row < R; row++)
        {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int column = 0; column < C; column++)
            {
                matrix[row][column] = Integer.parseInt(inputData[column]);
            }
        }
        return matrix;
    }



}
