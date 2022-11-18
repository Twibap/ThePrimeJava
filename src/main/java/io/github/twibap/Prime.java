package io.github.twibap;

import java.util.Arrays;

public class Prime {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        int number;
        if (value < 0)
            number = Integer.MAX_VALUE;
        else
            number = value;

        System.out.println("Find Primes under "+ number);

        long count = primeNumberCountUnder(number);
        System.out.println("Primes of under "+number+" is " + count);
    }

    static long primeNumberCountUnder(int number){
        int[] numbers = new int[number];
        for (int i = 1; i <= number; i++) {
            numbers[i-1] = i;
        }

        int pseudoCount = primeCountingFunction(number);
        System.out.println("Pseudo count is "+pseudoCount);

        return Arrays.stream(numbers)
                .parallel()
                .filter(Prime::isPrime)
                .count();
    }

    static int primeCountingFunction(int number) {
        return (int) (number / Math.log(number));
    }

    static boolean isPrime(int number) {
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;

        int rootOfNumber = (int) Math.sqrt(number);
        for (int i = 3; i <= rootOfNumber; i += 2) {
            if (number % i == 0)
                return number == i;
        }
        return true;
    }
}