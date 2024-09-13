/*
Name: Abdulmajeed Sulaiman
*/

package org.howard.edu.lsp.assignment2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        
        Map<String, Integer> wordCounts = new HashMap<>();
        String filePath = "words.txt";
        String currentLine;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((currentLine = reader.readLine()) != null) {
                String[] words = currentLine.split("\\s+");
                
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Z']", "").toLowerCase();
                    
                    if (cleanedWord.length() > 3) {
                        wordCounts.put(cleanedWord, wordCounts.getOrDefault(cleanedWord, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
