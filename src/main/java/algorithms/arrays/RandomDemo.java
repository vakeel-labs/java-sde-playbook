package algorithms.arrays;

import java.util.Arrays;


import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {

        int N = 5;
        int iterations = 10_000_000; // 1cr

        Random random = new Random();
        int[] frequency = new int[N];

        // Generate random numbers
        for (int i = 0; i < iterations; i++) {
            int number = random.nextInt(N); // [0,1,2,3,4]
            frequency[number]++;
        }

        System.out.println("Random.nextInt(" + N + ") Distribution");
        System.out.println("--------------------------------------");

        int totalCount = 0;

        for (int i = 0; i < N; i++) {
            double percentage = (frequency[i] * 100.0) / iterations;
            totalCount += frequency[i];

            System.out.printf(
                    "Number %d -> %,10d times (%.4f%%)%n",
                    i,
                    frequency[i],
                    percentage
            );
        }

        System.out.println("--------------------------------------");
        System.out.printf("Total Count      : %,d%n", totalCount);
        System.out.printf("Expected Count   : %,d%n", iterations);
        System.out.println("Match?           : " + (totalCount == iterations));
    }
}
