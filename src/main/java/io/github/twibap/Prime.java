package io.github.twibap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Prime {
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
        int count = 0;
        System.out.println("Pseudo count is "+pseudoCount);
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                writePrime(i);
                count++;
            }
        }
        return count;
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

    static void writePrime(int number) {
        String strNumber = String.valueOf(number);
        File file = new File("./out/PrimeNumbers.txt");
        FileWriter writer;
        try {
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            if (file.length() != 0)
                bufferedWriter.newLine();
            bufferedWriter.write(strNumber);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}