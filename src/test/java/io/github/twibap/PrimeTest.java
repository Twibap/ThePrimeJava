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
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(3)
    void primeNumberCountUnder3() {
        int number = 3;
        int expected = 2;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(4)
    void primeNumberCountUnder20() {
        int number = 20;
        int expected = 8;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(4)
    void primeNumberCountUnder23() {    // odd number
        int number = 23;
        int expected = 9;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);

    }

    @Test
    @Order(5)
    void primeNumberCountUnder1000() {
        int number = 1000;
        int expected = 168;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(5)
    void primeNumberCountUnder1013() {  // odd number
        int number = 1000;
        int expected = 169;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(6)
    void primeNumberCountUnder1000000() {
        int number = 1000000;
        int expected = 78498;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(6)
    void primeNumberCountUnder1000023() {
        int number = 1000023;
        int expected = 78499;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(7)
    void primeNumberCountUnder10000000() {
        int number = 10000000;
        int expected = 664579;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(7)
    void primeNumberCountUnder10000049() {
        int number = 10000049;
        int expected = 664580;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(8)
    void primeNumberCountUnder100000000() {
        int number = 100000000;
        int expected = 5761455;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

    @Test
    @Order(8)
    void primeNumberCountUnder100000111() {
        int number = 100000111;
        int expected = 5761461;
        Prime prime = new Prime(number);
        long count = prime.countUnder(number);

        assertEquals(expected, count);
    }

}