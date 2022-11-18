package io.github.twibap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        int number;
        if (value < 0)
            number = Integer.MAX_VALUE;
        else
            number = value;

        System.out.println("Find Primes under "+ number);

        int count = primeNumberCountUnder(number);
        System.out.println("Primes of under "+number+" is " + count);
    }

    static int primeNumberCountUnder(int number){
        int pseudoCount = primeCountingFunction(number);
        ArrayList<Integer> primes = new ArrayList<>(pseudoCount);
        System.out.println("Pseudo count is "+pseudoCount);
        for (int i = 2; i <= number; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        return primes.size();
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