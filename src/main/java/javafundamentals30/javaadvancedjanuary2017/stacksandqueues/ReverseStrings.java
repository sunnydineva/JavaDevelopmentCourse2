package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrings
{
    public static void main(String[] args)
    {

        //Write program that reads:
        //    • Reads an input string
        //    • Reverses it using a Stack
        //    • Prints the result back at the terminal
        //Examples
        //Input
        //Output
        //Learning Java
        //avaJ gninraeL
        //Stacks and Queues
        //seueuQ dna skcatS

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

//        for (int i = 0; i < s.length(); i++)
//        {
//            stack.push((s.charAt(i)));
//        }

        for (Character ch : s.toCharArray())
        {
            stack.push(ch);
        }

        while (!stack.isEmpty())
        {
            System.out.print(stack.pop());
        }
    }
}
