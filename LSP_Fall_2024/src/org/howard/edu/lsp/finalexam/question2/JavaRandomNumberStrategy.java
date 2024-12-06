package org.howard.edu.lsp.finalexam.question2;

import java.util.Random;

/**
 * Concrete strategy that uses Java's built-in Random class to generate
 * positive integers.
 */
public class JavaRandomNumberStrategy implements RandomNumberStrategy {
    private Random random = new Random();

    /**
     * Generates a positive integer random number using Java's built-in Random.
     * @return a positive integer.
     */
    @Override
    public int generateRandomNumber() {
        // Generate random positive integer in a certain range (e.g., 1 to 100)
        return random.nextInt(100) + 1;
    }
}
