package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter
{
    //Create a simple program that can convert a decimal number to its binary representation. Implement an elegant solution using a Stack.
    //Print the binary representation back at the terminal.
    //Examples
    //Input
    //Output
    //10
    //1010
    //1024
    //10000000000
    //Hints
    //    • If the given number is 0, just print 0
    //    • Else, while the number is greater than zero, divide it by 2 and push the reminder into the stack

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int decimal = Integer.parseInt(sc.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();
        while (decimal != 0)
        {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop()); //decimal
        }
    }
}
