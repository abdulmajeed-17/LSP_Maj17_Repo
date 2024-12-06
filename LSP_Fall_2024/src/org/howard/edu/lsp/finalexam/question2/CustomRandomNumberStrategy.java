package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete strategy implementing a custom random number generation algorithm.
 * 
 * This example uses a simple Linear Congruential Generator (LCG) approach:
 * X_{n+1} = (aX_n + c) mod m
 * 
 * Here, we use arbitrary constants:
 * a = 1664525, c = 1013904223, m = 2^31
 * 
 * This is a well-known LCG configuration used by some systems, though it's not cryptographically secure.
 */
public class CustomRandomNumberStrategy implements RandomNumberStrategy {
    private long seed;

    /**
     * Constructs the custom random number generator with a given seed.
     * @param seed the initial seed.
     */
    public CustomRandomNumberStrategy(long seed) {
        this.seed = seed;
    }

    /**
     * Generates a positive integer random number using an LCG approach.
     * @return a positive integer random number.
     */
    @Override
    public int generateRandomNumber() {
        long a = 1664525;
        long c = 1013904223;
        long m = (long) Math.pow(2, 31);
        
        seed = (a * seed + c) % m;
        // Ensure positive integer result
        int result = (int) Math.abs(seed % 100) + 1; 
        return result;
    }
}
