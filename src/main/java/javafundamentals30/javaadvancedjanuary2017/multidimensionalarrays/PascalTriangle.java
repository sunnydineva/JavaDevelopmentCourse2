package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class PascalTriangle
{
    //      1
    //     1 1 -
    //    1 2 1
    //   1 3 3 1
    //  1 4 6 4 1

    // неформатиран, минава през Judge:
    //            1
    //            1 1
    //            1 2 1
    //            1 3 3 1
    //            1 4 6 4 1

    // напишете програма, която принтира Pascal Triangle
    // най-горния ред е 1, всеки по-долен ред събира в себе си сбора от елементите на горния ред

    //    Ако излиза indexOutOfBoundException -приемаме, че е нула
    //     0 1 0
    //      1 1
    public static void main(String[] args)
    {
        System.out.println("Въведете integer за височина на pascal triangle");
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());

        int[][] pascal = new int[height][]; //създаваме матрица с височина height

        for (int i = 0; i < height; i++)
        {
            pascal[i] = new int[i + 1]; //създаваме редове
        }

        pascal[0][0] = 1; //върхът = 1

        //пълним матрицата
        for (int row = 1; row < height; row++)
        {
            pascal[row][0] = 1; // първото = 1
            pascal[row][pascal[row].length - 1] = 1; //последното = 1

            for (int col = 1; col < pascal[row].length - 1; col++)
            {
                pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col]; // изчислената стойност на елемента
            }
        }

        //принтиране
        for (int[] ints : pascal)
        {
            for (int anInt : ints)
            {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
