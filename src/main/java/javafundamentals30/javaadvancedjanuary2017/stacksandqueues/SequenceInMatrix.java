package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SequenceInMatrix
{
    private static int SEQUENCE_COUNT = 0;
    private static String SEQUENCE_STRING = "";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] dim = sc.nextLine().split(" ");
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++)
        {
            matrix[i] = sc.nextLine().split(" ");
        }

        List<String> sequence = new ArrayList<>();

        //by line
        for (int i = 0; i < rows; i++)
        {
            sequence.addAll(Arrays.asList(matrix[i]));
            checkForSequence(sequence);
        }
        
        //by column
        for (int col = 0; col < cols; col++)
        {
            for (int row = 0; row < rows; row++)
            {
                sequence.add(matrix[row][col]);
            }
            checkForSequence(sequence);
        }

        //by diagonal
        int diagSize = Math.min(rows, cols);
        for (int i = 0; i < diagSize; i++)
        {
            sequence.add(matrix[i][i]);
        }
        checkForSequence(sequence);

        //print result
        for (int i = 0; i < SEQUENCE_COUNT; i++)
        {
            System.out.printf("%s ", SEQUENCE_STRING);
        }

    }

    private static void checkForSequence(List<String> sequence)
    {
        for (int startPos = 0; startPos < sequence.size() -1; startPos++)
        {
            int counter = 1;
            String symbol = sequence.get(startPos);
            int currentPos = startPos + 1;

            while(symbol.equals(sequence.get(currentPos)))
            {
                counter++;

                if (counter >= SEQUENCE_COUNT)
                {
                    SEQUENCE_COUNT = counter;
                    SEQUENCE_STRING = symbol;
                }

                currentPos ++;

                if(currentPos >= sequence.size())
                {
                    break;
                }
            }
            sequence.clear();
        }
    }
}
