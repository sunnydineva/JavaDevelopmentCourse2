package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class PositionsOf
{
    public static void main(String[] args)
    {
        //Write a program that reads a matrix of integers from the console, then a number, and prints all the positions at which that number appears in the matrix.
        //The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces), representing each row of the matrix.
        //The number you will need to find the positions will be entered on a single line after the matrix.
        //You should print each position on a single line – first print the row, then the column at which the number appears.
        //If the number does not appear in the matrix, print "not found".

        Scanner sc = new Scanner(System.in);

        //четем размерите на матрицата
        String[] dim = sc.nextLine().split(" ");

        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        //създаваме я
        int[][] matrix = new int[rows][cols];

        //пълнене от конзолата
        for (int row = 0; row < rows; row++)
        {
            String[] line = sc.nextLine().split(" ");
            for (int col = 0; col < cols; col++)
            {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        //четем числото, за което търсим координатите
        int digit = Integer.parseInt(sc.nextLine());

        //обхождане на матрицата
        boolean isFound = false;
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {

                if(matrix[row][col] == digit)
                {
                    isFound = true;
                    System.out.println(row + " " + col );
                }
            }
        }
        if(!isFound)
        {
            System.out.println("not found");
        }
    }
}
