package io.github.twibap;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
class PrimeTest {

    @Test
    @Order(1)
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
    @Order(2)
    void primeNumberCountUnder2() {
        int number = 2;
        int expected = 1;
        int count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(3)
    void primeNumberCountUnder3() {
        int number = 3;
        int expected = 2;
        int count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(4)
    void primeNumberCountUnder20() {
        int number = 20;
        int expected = 8;
        int count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(5)
    void primeNumberCountUnder10000000() {
        int number = 10000000;
        int expected = 664579;
        int count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(6)
    void primeNumberCountUnder100000000() {
        int number = 100000000;
        int expected = 5761455;
        int count = Prime.primeNumberCountUnder(number);

        assertEquals(expected, count);
    }

}