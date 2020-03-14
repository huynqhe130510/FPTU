/**
 * This program counst the number of prime integers between 3000001 and 6000000.
 * The work is divided among one to five threads.  The number of threads is
 * chosen by the user.
 */
import java.util.*;
public class Main
   {
     private static final int start = 3000000;
     private static int total;
   
     synchronized private static void addToTotal(int x)
        {
          total = total + x;
          System.out.println(total + " primes found so far.");
        }
   
     private static class CountPrimesThread extends Thread
        {
          int count = 0;
          int min, max;
          public CountPrimesThread(int min, int max)
             {
               this.min = min;
               this.max = max;
             }
         public void run()
             {
               count = countPrimes(min,max);
               System.out.println("There are " + count + " primes between " + min + " and " + max);
               addToTotal(count);
             }
        }
   
     private static void countPrimesWithThreads(int numberOfThreads)
        {
          int increment = start/numberOfThreads;
         System.out.println("\nCounting primes between " + (start+1) + " and " + (2*start) + " using " + numberOfThreads + " threads...\n");
         long startTime = System.currentTimeMillis();
         CountPrimesThread[] worker = new CountPrimesThread[numberOfThreads];
         for (int i = 0; i < numberOfThreads; i++)
             worker[i] = new CountPrimesThread(  start+i*increment+1, 
         start+(i+1)*increment );
         total = 0;
         for (int i = 0; i < numberOfThreads; i++)
            worker[i].start();
         for (int i = 0; i < numberOfThreads; i++)
            {
              while (worker[i].isAlive())
                 {
                   try
                      {
                        worker[i].join();
                      }
                      catch (InterruptedException e) {   }
                 }
            }
          long elapsedTime = System.currentTimeMillis() - startTime;
          System.out.println("\nTotal elapsed time:  " + (elapsedTime/1000.0) + " seconds.\n");
        }
     public static void main(String[] args)
        {
          Scanner s = new Scanner(System.in); 
          int numberOfThreads = 0;
          while (numberOfThreads < 1 || numberOfThreads > 5)
              {
                System.out.print("How many threads do you want to use  (from 1 to 5) ?");
                numberOfThreads = s.nextInt();
                if (numberOfThreads < 1 || numberOfThreads > 5)
                    System.out.println("Please enter 1, 2, 3, 4, or 5 !");
              }
          countPrimesWithThreads(numberOfThreads);
       }
   
     private static int countPrimes(int min, int max)
       {
         int count = 0;
         for (int i = min; i <= max; i++)
            if (isPrime(i)) count++;
         return count;
       }
   
     private static boolean isPrime(int x)
       {
         int top = (int)Math.sqrt(x);
         for (int i = 2; i <= top; i++)
            if ( x % i == 0 )   return false;
        return true;
      }
   
  }
