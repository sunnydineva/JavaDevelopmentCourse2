package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class WrongMeasurements
{
    //You will be given the rows of a matrix. Then the matrix itself. Inside this matrix, there are mistaken values that need to be replaced.
    // You will receive the wrong value at the last line. Those values should be replaced with the sum of the nearest elements in the four directions,
    // up, down, left, and right, but only if they are valid values. In the end, you have to print the fixed measurements.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = readMatrix(sc);
        int wrongValue = Integer.parseInt(sc.nextLine());
        int[][] newMatrix = fixMeasurements(matrix, wrongValue);
        printMatrix(newMatrix);
    }

    public static int[][] readMatrix(Scanner sc)
    {
        int dimMatrix = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[dimMatrix][];

        for (int row = 0; row < dimMatrix; row++)
        {
            String[] line = sc.nextLine().split(" ");
            matrix[row] = new int[line.length];

            for (int col = 0; col < line.length; col++)
            {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return matrix;
    }

    public static int[][] fixMeasurements(int[][] matrix, int wrongValue)
    {
        int [][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                //borderPositions
                int leftBorder = 0;
                int rightBorder = matrix[i].length - 1;
                int topBorder = 0;
                int bottomBorder = matrix.length -1;

                int left = 0;
                int right = 0;
                int top = 0;
                int bottom = 0;

                if(matrix[i][j] == wrongValue)
                {
                    //surroundingValues
                    if(j > leftBorder)
                    {
                        left = (matrix[i][j-1] == wrongValue) ? 0 : matrix[i][j-1];
                    }
                    if(j < rightBorder)

                    {
                        right = (matrix[i][j + 1] == wrongValue) ? 0 : matrix[i][j + 1];
                    }
                    if(i < bottomBorder)
                    {
                        bottom = (matrix[i+1][j] == wrongValue) ? 0 : matrix[i+1][j];
                    }
                    if(i > topBorder)
                    {
                        top = (matrix[i-1][j] == wrongValue) ? 0 : matrix[i-1][j];
                    }

                    newMatrix[i][j] = left + right + top + bottom;
                } else
                {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
