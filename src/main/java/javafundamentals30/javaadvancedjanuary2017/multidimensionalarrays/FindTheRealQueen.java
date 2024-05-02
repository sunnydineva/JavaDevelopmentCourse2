package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

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

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int dimension = 8;
        String[][] matrix = readMatrix(sc, dimension);

        int queenRow;
        int queenCol = 0;
        int queenDiagonal = 0;

        for (int matrixRow = 0; matrixRow < dimension; matrixRow++)
        {
            int isOneQueenOnTheRow = 0;
            for (int matrixCol = 0; matrixCol < dimension; matrixCol++)
            {
                if (matrix[matrixRow][matrixCol].equals("q"))
                {
                    if (isOneQueenOnTheRow >= 1) break;
                    isOneQueenOnTheRow++;
                    queenRow = matrixRow;

                    if (queenCol == matrixCol) break; //there is a queen on the column
                    queenCol = matrixCol;


                    //isQueenOnTheDiagonals


                    System.out.println(queenRow + " " + queenCol);
                    //принтирм диагоналите на оставащите кралици
                    printDiagonals(matrix, queenRow, queenCol);
                    //2 2
                    //p a q a p a q a
                    //p a q a p
                    //4 3
                    //p a p q p a p
                    //p a p q p a p a
                    //6 2
                    //p a q a
                    //a q a p a q a


                    //имам 3 кралици, обходих диагоналите им
                   //остава да направя да ги трупа в масив и ако се повтаря - да го маха

                }
            }

        }


        sc.close();
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

    private static void printDiagonals(String[][] matrix, int queenRow, int queenCol)
    {

        // Първи диагонал: от първия ред и колона до последния
        for (int i =  Math.max(queenRow - queenCol, 0), j = Math.max(queenCol-queenRow, 0); i < matrix.length && j < matrix.length ; j++, i++)
        {
            System.out.print(matrix[i][j] + " ");

            if(matrix[i][j].equals("q"))
            {

            }
        }
        System.out.println();

        // Втори диагонал: от последния ред и първа колона до първия ред и последна колона

        for (int i = Math.min(queenRow + queenCol, matrix.length -1), j = queenRow+queenCol-i; i >= 0 && j < matrix.length; i--, j++)
        {
            System.out.print(matrix[i][Math.min(j, matrix.length)] + " ");
        }
        System.out.println();
    }

}
