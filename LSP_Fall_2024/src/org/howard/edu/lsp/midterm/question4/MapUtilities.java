package org.howard.edu.lsp.midterm.question4;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class providing methods for HashMap operations.
 */
public class MapUtilities {

    /**
     * Counts the number of common key/value pairs between two HashMaps.
     *
     * @param map1 The first HashMap with String keys and values.
     * @param map2 The second HashMap with String keys and values.
     * @return The number of common key/value pairs. Returns 0 if either map is empty.
     */
    public static int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2) {
        // Check if either map is null or empty
        if (map1 == null || map2 == null || map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }

        int commonCount = 0;

        // Iterate through entries of the first map
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            // Check if the second map contains the same key and value
            if (map2.containsKey(key) && value.equals(map2.get(key))) {
                commonCount++;
            }
        }

        return commonCount;
    }
}
