package org.howard.edu.lsp.midterm.question4;

import java.util.HashMap;

/**
 * Driver class to test the commonKeyValuePairs method in MapUtilities.
 */
public class MapUtilitiesDriver {
    /**
     * The main method where execution begins.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Initialize the first HashMap with candidate names and their statuses
        HashMap<String, String> hashmap1 = new HashMap<>();
        hashmap1.put("Alice", "Healthy");
        hashmap1.put("Mary", "Ecstatic");
        hashmap1.put("Bob", "Happy");
        hashmap1.put("Chuck", "Fine");
        hashmap1.put("Felix", "Sick");

        // Initialize the second HashMap with candidate names and their statuses
        HashMap<String, String> hashmap2 = new HashMap<>();
        hashmap2.put("Mary", "Ecstatic");
        hashmap2.put("Felix", "Healthy");
        hashmap2.put("Ricardo", "Superb");
        hashmap2.put("Tam", "Fine");
        hashmap2.put("Bob", "Happy");

        // Calculate the number of common key/value pairs between the two HashMaps
        int commonPairs = MapUtilities.commonKeyValuePairs(hashmap1, hashmap2);

        // Display the result
        System.out.println("Number of common key/value pairs is: " + commonPairs);
        // Expected Output: Number of common key/value pairs is: 2
    }
}
