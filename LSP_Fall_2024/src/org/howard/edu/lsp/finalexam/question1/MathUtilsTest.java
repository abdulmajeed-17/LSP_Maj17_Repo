package org.howard.edu.lsp.finalexam.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    // ---------------------------
    // Tests for factorial(int n)
    // ---------------------------

    /**
     * Tests that factorial of a positive integer is computed correctly.
     * For example, factorial(5) should be 120.
     */
    @Test
    void testFactorial_givenPositiveNumber_returnsCorrectFactorial() {
        assertEquals(120, mathUtils.factorial(5), "factorial(5) should return 120");
    }

    /**
     * Tests that factorial(0) returns 1, which is a defined base case.
     */
    @Test
    void testFactorial_givenZero_returnsOne() {
        assertEquals(1, mathUtils.factorial(0), "factorial(0) should return 1");
    }

    /**
     * Tests that factorial(1) returns 1, which is another base case.
     */
    @Test
    void testFactorial_givenOne_returnsOne() {
        assertEquals(1, mathUtils.factorial(1), "factorial(1) should return 1");
    }

    /**
     * Tests that a negative input throws an IllegalArgumentException, 
     * since factorial is not defined for negative integers.
     */
    @Test
    void testFactorial_givenNegativeNumber_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> mathUtils.factorial(-3),
                "factorial(-3) should throw IllegalArgumentException");
    }

    // ---------------------------
    // Tests for isPrime(int n)
    // ---------------------------

    /**
     * Tests that a known prime number (2) returns true.
     */
    @Test
    void testIsPrime_givenPrimeNumber_returnsTrue() {
        assertTrue(mathUtils.isPrime(2), "2 is prime, so isPrime(2) should return true");
    }

    /**
     * Tests that a known non-prime number (15) returns false.
     */
    @Test
    void testIsPrime_givenNonPrimeNumber_returnsFalse() {
        assertFalse(mathUtils.isPrime(15), "15 is not prime, so isPrime(15) should return false");
    }

    /**
     * Tests boundary values: 1, 0, and negative numbers are not prime.
     */
    @Test
    void testIsPrime_givenBoundaryValues_returnsFalse() {
        assertFalse(mathUtils.isPrime(1), "1 is not prime, so isPrime(1) should return false");
        assertFalse(mathUtils.isPrime(0), "0 is not prime, so isPrime(0) should return false");
        assertFalse(mathUtils.isPrime(-5), "-5 is not prime, so isPrime(-5) should return false");
    }

    // ---------------------------
    // Tests for gcd(int a, int b)
    // ---------------------------

    /**
     * Tests gcd with two positive numbers.
     * gcd(54, 24) should be 6.
     */
    @Test
    void testGcd_givenPositiveNumbers_returnsCorrectGcd() {
        assertEquals(6, mathUtils.gcd(54, 24), "gcd(54, 24) should return 6");
    }

    /**
     * Tests gcd when one number is zero and the other is non-zero.
     * gcd(0, 5) should return 5 and gcd(5, 0) should return 5.
     */
    @Test
    void testGcd_givenZeroAndNonZero_returnsAbsoluteNonZero() {
        assertEquals(5, mathUtils.gcd(0, 5), "gcd(0, 5) should return 5");
        assertEquals(5, mathUtils.gcd(5, 0), "gcd(5, 0) should return 5");
    }

    /**
     * Tests gcd when both inputs are zero.
     * This should throw an IllegalArgumentException.
     */
    @Test
    void testGcd_givenBothZero_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> mathUtils.gcd(0, 0),
                "gcd(0, 0) should throw IllegalArgumentException");
    }

    /**
     * Tests gcd with negative numbers.
     * gcd(-18, -24) should be 6 and gcd(-8, 4) should be 4.
     */
    @Test
    void testGcd_givenNegativeNumbers_returnsPositiveGcd() {
        assertEquals(6, mathUtils.gcd(-18, -24), "gcd(-18, -24) should return 6");
        assertEquals(4, mathUtils.gcd(-8, 4), "gcd(-8, 4) should return 4");
    }
}
