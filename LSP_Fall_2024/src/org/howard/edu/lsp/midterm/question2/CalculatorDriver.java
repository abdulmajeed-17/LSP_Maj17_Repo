package org.howard.edu.lsp.midterm.question2;

/**
 * Demonstrates the functionality of the Calculator class.
 */
public class CalculatorDriver {
    /**
     * The main method to execute sum operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Sum of two integers
        int sumIntegers = Calculator.sum(5, 10);
        System.out.println(sumIntegers); // Outputs 15

        // Sum of two doubles
        double sumDoubles = Calculator.sum(3.5, 7.8);
        System.out.println(sumDoubles); // Outputs 11.3

        // Sum of an array of integers
        int[] intArray = {1, 2, 3, 4, 5};
        int sumArray = Calculator.sum(intArray);
        System.out.println(sumArray); // Outputs 15
    }
}
