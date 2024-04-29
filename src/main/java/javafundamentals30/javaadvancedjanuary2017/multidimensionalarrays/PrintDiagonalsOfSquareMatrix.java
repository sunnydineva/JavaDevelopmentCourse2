package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix
{
    //Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square. On the first line, you read a single integer N the matrix size.
    // Then on each line N elements. The first diagonal should always start with the element at the first row and col.
    // The second diagonal should start with the element at the last row and first col.
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];

        // Попълване на матрицата
        for (int row = 0; row < dimension; row++)
        {
            String[] line = scanner.nextLine().split(" ");
            for (int column = 0; column < dimension; column++)
            {
                matrix[row][column] = Integer.parseInt(line[column]);
            }
        }

        // Печат на диагоналите
        printDiagonals(matrix);
    }

    private static void printDiagonals(int[][] matrix)
    {
        // Първи диагонал: от първия ред и колона до последния
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        // Втори диагонал: от последния ред и първа колона до първия ред и последна колона
        for (int i = matrix.length - 1, j = 0; i >= 0 && j < matrix.length; i--, j++)
        {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
}
