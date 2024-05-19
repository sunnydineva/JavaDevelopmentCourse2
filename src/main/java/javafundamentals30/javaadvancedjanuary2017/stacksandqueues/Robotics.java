package javafundamentals30.javaadvancedjanuary2017.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] robotTokens = sc.nextLine().split(";");

        String[] robots = new String[robotTokens.length];
        int[] processTimes = new int[robotTokens.length];
        int[] robotsCounter = new int[robotTokens.length];

        for (int i = 0; i < robotTokens.length; i++)
        {
            String[] robotsToken = robotTokens[i].split("-");
            robots[i] = robotsToken[0];
            processTimes[i] = Integer.parseInt(robotsToken[1]);
        }

        String[] time = sc.nextLine().split(":");
        long hours = Long.parseLong(time[0]) * 60 * 60; //in secs
        long minutes = Long.parseLong(time[1]) * 60;
        long seconds = Long.parseLong(time[2]);

        long totalTime = hours + minutes + seconds;

        Deque<String> products = new ArrayDeque<>();

        String product = "";

        while (!"End".equals(product = sc.nextLine()))
        {
            products.offer(product);
        }

        while (!products.isEmpty())
        {
            totalTime++;
            for (int i = 0; i < robots.length; i++)
            {
                if (robotsCounter[i] > 0)//работещи роботи
                {
                    robotsCounter[i]--;
                }
            }

            String currentProduct = products.poll();
            boolean isProductTaken = false;

            for (int i = 0; i < robots.length; i++)
            {
                if (robotsCounter[i] == 0) //имаме свободен робот
                {
                    robotsCounter[i] = processTimes[i];
                    isProductTaken = true;
                    System.out.printf("%s - %s [%s]%n", robots[i], currentProduct, convertSecondsToHMmSs(totalTime));
                    break;
                }
            }

            if (!isProductTaken)
            {
                products.offer(currentProduct);
            }

        }
    }

    public static String convertSecondsToHMmSs(long totalTime)
    {
        long s = totalTime % 60;
        long m = (totalTime / 60) % 60;
        long h = (totalTime / (60 * 60)) % 24;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
