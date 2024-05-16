package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator
{
    public static void main(String[] args)
    {
        //Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction.
        // There will not be parentheses or operator precedence.
        //Solve the problem using a Stack.

        Scanner sc = new Scanner(System.in);
        String[] expression = sc.nextLine().split(" ");

        Deque<String> stack = new ArrayDeque<>(Arrays.asList(expression));

        int result = 0;

        while (!stack.isEmpty())
        {
            String element = stack.pop();
            boolean isOperator = element.equals( "+") || element.equals("-");

            if (isOperator)
            {
                switch (element)
                {
                    case "+":
                    {
                        //int nextInt = Integer.parseInt(String.valueOf(stack.pop()));
                        result += Integer.parseInt(String.valueOf(stack.pop()));
                        break;
                    }
                    case  "-":
                    {
                        result -= Integer.parseInt(String.valueOf(stack.pop()));
                        break;
                    }
                }
            } else
            {
                result = Integer.parseInt(element);
            }

        }
        System.out.println(result);
    }
}

