package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PalindromeChecker
{
    //Palindrome is a string that reads the same forward and backward.
    // Your task is to create a simple program that checks if a given string is a palindrome using an ArrayDeque<>.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s)
    {
        ArrayDeque<Character> chars = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++)
        {
            chars.add(s.charAt(i));
        }

        boolean isPalindrome = true;

        while (chars.size() > 1)
        {
            isPalindrome = chars.pollFirst() == chars.pollLast();
        }
        return isPalindrome;
    }

}
