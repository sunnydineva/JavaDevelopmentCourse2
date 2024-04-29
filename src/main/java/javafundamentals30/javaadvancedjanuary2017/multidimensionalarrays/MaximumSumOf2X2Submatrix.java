package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class MaximumSumOf2X2Submatrix
{
    //Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix. Print the submatrix and its sum.
    //On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines, you will get the elements for each row separated by a comma.

    public static void main(String[] args)
    {
        //размери на матрицата
        Scanner scanner = new Scanner(System.in);
        String[] dim = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        int[][] matrix = new int[rows][cols];

        //пълнене на матрицата
        for (int row = 0; row < rows; row++)
        {
            String[] line = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++)
            {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        //инициализираме максималните стойности
        int firstDigit = Integer.MIN_VALUE;
        int rightDigit = Integer.MIN_VALUE;
        int bottomDigit = Integer.MIN_VALUE;
        int botRightDigit = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        //обхождане на матрицата
        for (int row = 0; row < rows - 1; row++)
        {
            for (int col = 0; col < cols - 1; col++)
            {
                int first = matrix[row][col];
                int right = matrix[row][col + 1];
                int bottom = matrix[row + 1][col];
                int botRight = matrix[row + 1][col + 1];

                int currentSum = first + right + bottom + botRight;
                if (currentSum > maxSum)
                {
                    firstDigit = first;
                    rightDigit = right;
                    bottomDigit = bottom;
                    botRightDigit = botRight;
                    maxSum = currentSum;
                }
            }
        }
        System.out.println(firstDigit + " " + rightDigit);
        System.out.println(bottomDigit + " " + botRightDigit);
        System.out.println(maxSum);
    }
}
