package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HotPotato
{
    //Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the fist kid. Every nth toss the child left with the potato leaves the game. When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.
    //Create a program that simulates the game of Hot Potato.  Print every kid that is removed from the circle. In the end, print the kid that is left last.
    //Examples
    //Input
    //Output
    //Mimi Pepi Toshko
    //2
    //Removed Pepi
    //Removed Mimi
    //Last is Toshko
    //Gosho Pesho Misho Stefan Krasi
    //10
    //Removed Krasi
    //Removed Pesho
    //Removed Misho
    //Removed Gosho
    //Last is Stefan
    //Gosho Pesho Misho Stefan Krasi
    //1
    //Removed Gosho
    //Removed Pesho
    //Removed Misho
    //Removed Stefan
    //Last is Krasi

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        Queue<String> queue = new ArrayDeque<>(Arrays.asList(input));

        int counter = 1;
        while (!queue.isEmpty())
        {
            if (queue.size() == 1)
            {
                System.out.println("Last is " + queue.poll());
                break;
            }

            if(n == 1)
            {
                System.out.println("Removed " + queue.poll());
            }

            counter++;
            queue.add(queue.poll()); //преместване отзад на опашката

            if (counter == n)
            {
                System.out.println("Removed " + queue.poll());
                counter = 1;
            }

        }
    }
}
