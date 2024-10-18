package org.howard.edu.lsp.midterm.question2;

/**
 * Utility class providing methods to perform sum operations on different data types.
 */
public class Calculator {

    /**
     * Sums two integer values.
     *
     * @param num1 The first integer.
     * @param num2 The second integer.
     * @return The sum of num1 and num2.
     */
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * Sums two double values.
     *
     * @param num1 The first double.
     * @param num2 The second double.
     * @return The sum of num1 and num2.
     */
    public static double sum(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Sums all elements in an array of integers.
     *
     * @param numbers An array of integers.
     * @return The sum of all elements in the array.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static int sum(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
