package javafundamentals30.javaadvancedjanuary2017.multidimensionalarrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices
        //Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints the third matrix C[][], which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines, you receive M and N, then on 2 * M lines N characters – the matrices elements.
        //The matrix elements may be any ASCII char except '*'.
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine()); //брой редове за двете матрици
        int N = Integer.parseInt(sc.nextLine()); //брой колони за матриците

        char[][] matrixA = readMatrix(M, N, sc);
        char[][] matrixB = readMatrix(M, N, sc);

        char[][] matrixC = new char[M][N];

        //обхождане на двете матрици
        for (int i = 0; i < matrixA.length; i++)//matrixA.length - броя на редовете в матрицата matrixA
        {
            for (int j = 0; j < matrixA[i].length; j++) //matrixA[i].length -  броя на елементите в i-тия ред на матрицата
            {
                if (matrixA[i][j] == matrixB[i][j])
                {
                    matrixC[i][j] = matrixA[i][j];
                } else
                {
                    matrixC[i][j] = '*';
                }
            }
        }

        //принтиране на третата
        for(char[] row : matrixC)
        {
            for(char aChar : row)
            {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int M, int N, Scanner sc)
    {
        char[][] matrix = new char[M][N];

        //пълнене на матрицата от конзолата
        for (int row = 0; row < M; row++)
        {
            String[] line = sc.nextLine().split(" ");
            for (int col = 0; col < N; col++)
            {
                matrix[row][col] = line[col].charAt(0);
            }
        }
        return matrix;
    }
}
