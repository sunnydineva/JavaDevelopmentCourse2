package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class SumMatrixElements
{
    //Write a program that reads a matrix from the console and prints:
    //    • The count of rows
    //    • The count of columns
    //    • The sum of all matrix's elements
    //On the first line, you will get the matrix dimensions in the format "{rows, columns}".
    // On the next lines, you will get the elements for each row separated by a comma.
    public static void main(String[] args)
    {
        //размери на матрицата
        Scanner sc = new Scanner(System.in);
        String[] dim = sc.nextLine().split(", ");

        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        int[][] matrix = new int[rows][cols];

        int sum = 0;

        //пълнене на стойности в нея
        for (int row = 0; row < rows; row++)
        {
            String[] line = sc.nextLine().split(", ");
            for (int column = 0; column < cols; column++)
            {
                matrix[row][column] = Integer.parseInt(line[column]);
                sum += matrix[row][column];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
