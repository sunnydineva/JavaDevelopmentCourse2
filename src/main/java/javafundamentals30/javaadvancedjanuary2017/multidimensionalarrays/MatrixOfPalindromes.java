package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class MatrixOfPalindromes
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //размери на матрицата
        String[] dim = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        //матрицата
        int[][] matrix = new  int[rows][cols];

        //пълнене на стойности в нея
        for (int row = 0; row < rows ; row++)
        {
            String[] inputRow = scanner.nextLine().split("\\s+");

            for (int column = 0; column < cols; column++)
            {
                matrix[row][column] = Integer.parseInt(inputRow[column]);
            }

        }


    }
}
