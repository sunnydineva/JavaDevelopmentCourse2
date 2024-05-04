package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FindTheRealQueen
{
    // Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chessboard with figures on it.
    // The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen, but only one queen
    // will have a valid position, which is not attacked by any other queen and does not attack any other queen.
    // In another word, in the way of the valid queen, there are no other queens, but there may be any other ASCII symbol.
    // Your task is to read the chessboard and find the position of the valid queen.
    // According to chess rules, the queen can attack all the cells in horizontal verticals and both diagonals,
    // which cross the queen position.
    //Input
    //Output
    //p a p a p a p a
    //p a p a p a p a
    //p a q a p a q a
    //p a p a p a p a
    //p a p q p a p a
    //p a p a p a p a
    //p a q a p a q a
    //p a p a p a p a
    //4 3

    //2 2
    //2 6
    //4 3
    //6 2
    //6 6

    //1 q q q 1 q q q
    //q 1 q q 1 q q 1
    //q q 1 q 1 q 1 q
    //q q q 1 1 1 q q
    //1 1 1 1 q 1 1 1
    //q q q 1 1 1 q q
    //q q 1 q 1 q 1 q
    //q 1 q q 1 q q 1
    //4 4

    public static ArrayList<Point> queens = new ArrayList<>();
    public static String queen = "q";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int dimension = 8;

        String[][] matrix = readMatrix(sc, dimension);
        processAllQueens(dimension, matrix);
        System.out.println(queens.get(0).x + " " + queens.get(0).y); //принтиране на координатите на истинската кралица
        sc.close();
    }

    private static void processAllQueens(int dimension, String[][] matrix)
    {
        int queenRow = -1;
        int queenCol = -1;
        for (int matrixRow = 0; matrixRow < dimension; matrixRow++)
        {
            for (int matrixCol = 0; matrixCol < dimension; matrixCol++)
            {
                if (matrix[matrixRow][matrixCol].equals(queen))
                {
                    if (queenRow == matrixRow )
                    {
                        queens.remove(new Point(queenRow, queenCol));
                        continue;  //there is a queen on the row
                    }
                    if (queenCol == matrixCol)
                    {
                        queens.remove(new Point(queenRow, queenCol));
                        continue; //there is a queen on the column
                    }
                    queenRow = matrixRow;
                    queenCol = matrixCol;
                    queens.add(new Point(queenRow, queenCol));

                    checkDiagonals(matrix, queenRow, queenCol); //маха от queens, ако се повтаря по диагонали
                }
            }
        }
    }

    public static String[][] readMatrix(Scanner scanner, int dimension)
    {
        String[][] matrix = new String[dimension][dimension];
        for (int row = 0; row < dimension; row++)
        {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < dimension; col++)
            {
                matrix[row][col] = line[col];
            }
        }
        return matrix;
    }

    private static void checkDiagonals(String[][] matrix, int queenRow, int queenCol)
    {
        int queensOnBothDiagonals = 0;
        // Първи диагонал: от първия ред и колона до последния
        for (int i = Math.max(queenRow - queenCol, 0), j = Math.max(queenCol - queenRow, 0); i < matrix.length && j < matrix.length; j++, i++)
        {
            //System.out.print(matrix[i][j] + " "); //принт на целия диагонал
            if (matrix[i][j].equals(queen))
            {
                if (queensOnBothDiagonals > 1)
                {
                    queens.remove(new Point(queenRow, queenCol));
                    return;
                }
                queensOnBothDiagonals++;
            }
        }
        System.out.println();
        // Втори диагонал: от последния ред и първа колона до първия ред и последна колона
        for (int i = Math.min(queenRow + queenCol, matrix.length - 1), j = Math.max( queenRow + queenCol - i, 0); i >= 0 && j < matrix.length; i--, j++)
       // for (int i = Math.min(queenRow + queenCol, matrix.length - 1), j =   Math.max(queenCol - (matrix.length - queenRow -1), 0) ; i >= 0 && j < matrix.length; i--, j++) //също работи
        {
            //System.out.print(matrix[i][j] + " ");  //принт на целия диагонал
            if (matrix[i][j].equals(queen))
            {
                if (queensOnBothDiagonals > 1)
                {
                    queens.remove(new Point(queenRow, queenCol));
                    return;
                }
                queensOnBothDiagonals++;
            }
        }
    }
}
