package org.howard.edu.lsp.finalexam.question2;

/**
 * Client program that demonstrates the use of the RandomNumberService
 * with different strategies.
 */
public class RandomNumberClient {
    public static void main(String[] args) {
        // Get the singleton instance of the service
        RandomNumberService service = RandomNumberService.getInstance();

        // Set the strategy to JavaRandomNumberStrategy and generate a number
        service.setStrategy(new JavaRandomNumberStrategy());
        int javaRandom = service.getRandomNumber();
        System.out.println("Random number using Java built-in strategy: " + javaRandom);

        // Set the strategy to CustomRandomNumberStrategy with a chosen seed
        service.setStrategy(new CustomRandomNumberStrategy(System.currentTimeMillis()));
        int customRandom = service.getRandomNumber();
        System.out.println("Random number using Custom strategy: " + customRandom);
    }
}
