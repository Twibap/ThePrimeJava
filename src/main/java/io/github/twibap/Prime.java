package io.github.twibap;

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
            number = Integer.MAX_VALUE;
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
        long count = 0;
        for (int i = 0; i <= number; i++) {
            if (isPrime(i)) {
                queue.add(i);
                count++;
            }
        }
        return count;
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