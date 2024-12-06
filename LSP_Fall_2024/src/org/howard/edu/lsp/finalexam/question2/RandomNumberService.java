package org.howard.edu.lsp.finalexam.question2;

/**
 * A singleton service that uses the Strategy pattern to generate a random number.
 * The client can select a strategy at runtime.
 */
public class RandomNumberService {
    private static RandomNumberService instance;
    private RandomNumberStrategy strategy;

    /**
     * Private constructor to enforce singleton pattern.
     */
    private RandomNumberService() {}

    /**
     * Returns the single instance of RandomNumberService.
     * If it does not yet exist, it is created.
     * @return the singleton instance of RandomNumberService.
     */
    public static synchronized RandomNumberService getInstance() {
        if (instance == null) {
            instance = new RandomNumberService();
        }
        return instance;
    }

    /**
     * Sets the strategy for generating random numbers.
     * @param strategy a RandomNumberStrategy implementation.
     */
    public void setStrategy(RandomNumberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Generates a positive integer random number using the current strategy.
     * @return a positive integer random number.
     * @throws IllegalStateException if no strategy is set.
     */
    public int getRandomNumber() {
        if (strategy == null) {
            throw new IllegalStateException("No strategy set for RandomNumberService.");
        }
        return strategy.generateRandomNumber();
    }
}
