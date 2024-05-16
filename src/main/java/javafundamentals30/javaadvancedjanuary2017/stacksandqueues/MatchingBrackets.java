package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets
{
    //We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
    //Print the result back at the terminal.
    //Examples
    //Input
    //Output
    //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
    //(2 + 3)
    //(3 + 1)
    //(2 - (2 + 3) * 4 / (3 + 1))
    //(2 + 3) - (2 + 3)
    //(2 + 3)
    //(2 + 3)

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            char c = expression.charAt(i);

            if (c == '(')
            {
                stack.push(i);
            }
            else if (c == ')')
            {
                int startIndex = stack.pop();
                String content = expression.substring(startIndex, i+1);
                System.out.println(content);
            }
        }
    }
}
