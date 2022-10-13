package io.github.twibap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        long start = System.currentTimeMillis();

        System.out.println("Hello Prime!");
        System.out.println("Find Primes under "+ number);

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i))
                primes.add(i);
        }

        System.out.println("The Prime number Count is " + primes.size());

        long end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
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