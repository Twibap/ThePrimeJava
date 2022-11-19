package io.github.twibap;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Prime {

    Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    PrimeWriter writer;

    public Prime(int value) {
        writer = new PrimeWriter(queue, value);
    }

    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        int number;
        if (value < 0)
            number = Integer.MAX_VALUE - 8; // Jvm limitation of Array size
        else
            number = value;

        System.out.println("Find Primes under "+ number);

        Prime prime = new Prime(number);
        prime.writer.start();

        long count = prime.countUnder(number);
        System.out.println("Primes of under "+number+" is " + count);

        prime.writer.done();
        try {
            prime.writer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    long countUnder(int number){
        int[] numbers = new int[number];    // Integer.MAX_VALUE 의 경우 Heap size 10G 이상 필요함
        for (int i = 1; i <= number; i++) {
            numbers[i-1] = i;
        }

        int pseudoCount = primeCountingFunction(number);
        System.out.println("Pseudo count is "+pseudoCount);

        return Arrays.stream(numbers)
                .parallel()
                .filter(Prime::isPrime)
                .peek(queue::add)
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