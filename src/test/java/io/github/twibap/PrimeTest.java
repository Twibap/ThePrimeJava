package io.github.twibap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeTest {

    @Test
    void isPrime() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17};
        int[] notPrimes = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16};

        for (int i : primes) {
            assertTrue(Prime.isPrime(i));
        }

        for (int i : notPrimes) {
            assertFalse(Prime.isPrime(i));
        }
    }

    @Test
    void primeNumberCountUnder10000000() {
        int number = 10000000;
        int expected = 664579;
        long count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);
    }

    @Test
    void primeNumberCountUnder100000000() {
        int number = 100000000;
        int expected = 5761455;
        long count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);
    }

}