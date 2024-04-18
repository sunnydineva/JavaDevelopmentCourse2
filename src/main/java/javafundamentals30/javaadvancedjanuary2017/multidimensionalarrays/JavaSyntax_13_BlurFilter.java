package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class JavaSyntax_13_BlurFilter
{
    //Bojo is a bad photou will be given a matrix with pixels. Each pixel has weight. The blur filter is applied to a certain cell (pixel) and all cells around it.
    // The blur has amount, which needs to be added to the weight of the pixel that it blurs. Print the matrix after the blur applied as output.
    //
    //Example: on the picture on the left apply blur with amount 2 over the pixel at position [2, 2].

    //1  2  3   4     1  2 3  4
    //5  6  7   8     5  8 9  10
    //9 10 11 -12     9 12 13 -10
    //-13 14 15 16   -13 16 17 18

    //input
//9
//3 3
//1 1 1
//1 1 1
//1 1 1
//1 1

    //output
//        10 10 10
//        10 10 10
//        10 10 10


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int blurFilter = Integer.parseInt(scanner.nextLine());

        String [] dim = scanner.nextLine().split("\\s+"); //когато в split използваме " " е по-бързо от "\\s"

        //четем rows & columns
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        long [][] pixels = new long[rows][cols];

        //пълним матрицата
        for (int row = 0; row < rows; row++)
        {
            String[] inputData = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++)
            {
                pixels[row][col] = Long.parseLong(inputData[col]); //не Integer, защото
            }
        }

        //четем координатите
        String[] coordinates = scanner.nextLine().split("\\s+");
        int targetRow = Integer.parseInt(coordinates[0]);
        int targetCol = Integer.parseInt(coordinates[1]);

        //взимаме граничните случаи около таргета, обхождаме в границите на матрицата
        int left = Math.max(0, targetCol-1);
        int right = Math.min(targetCol + 1, cols); //cols or cols-1 може да е, защото когато обхождаме по-долу в матрицата, ще бъдем в границите й
        int top = Math.max(0, targetRow -1);
        int bottom = Math.max(targetRow + 1, rows);

        //обхождаме матрицата
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                if((left <= col && col <= right) && (top <= row && row <= bottom))
                {
                    System.out.printf("%d ", pixels[row][col] + blurFilter); // 1 + 9 = 10
                } else
                {
                    System.out.printf("%d ", pixels[row][col]);
                }

            }
            System.out.println();
        }
    }
}
