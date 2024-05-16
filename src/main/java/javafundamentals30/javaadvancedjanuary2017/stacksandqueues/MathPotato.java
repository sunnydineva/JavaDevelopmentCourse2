package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class MathPotato
{
    //Rework the previous problem so that a child is removed only on a prime cycle (cycles start from 1)
    //If a cycle is not prime, just print the child's name.
    //As before, print the name of the child that is left last.
    //Examples
    //Input
    //Output
    //Mimi Pepi Toshko
    //2
    //Removed Pepi
    //Prime Mimi
    //Prime Toshko
    //Removed Mimi
    //Last is Toshko
    //Gosho Pesho Misho Stefan Krasi
    //10
    //Removed Krasi
    //Prime Pesho
    //Prime Misho
    //Removed Stefan
    //Prime Gosho
    //Removed Gosho
    //Prime Misho
    //Removed Pesho
    //Last is Misho

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        Queue<String> queue = new ArrayDeque<>(Arrays.asList(input));

        hotPotato(queue, n);
    }

    private static void hotPotato(Queue<String> queue, int n)
    {
        int count = 1;
        while (queue.size() > 1)
        {
            for (int i = 1; i < n; i++)
            {
                queue.offer(queue.poll());
            }
            if(isPrime(count))
            {
                System.out.println("Prime " + queue.peek());
            }
            else
            {
                System.out.println("Removed " + queue.poll());
            }
            count ++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number)
    {
        if (number <= 1)
        {
            return false;
        }

        for (int divider = 2; divider <= Math.sqrt(number); divider++)
        {
            if (number % divider == 0)
            {
                return false;
            }
        }
        return true;
    }

}
