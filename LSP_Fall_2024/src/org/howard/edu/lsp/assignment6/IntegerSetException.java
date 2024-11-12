package org.howard.edu.lsp.assignment6;

/**
 * Custom exception class for IntegerSet operations.
 * Thrown when attempting to perform operations on an empty set.
 */
public class IntegerSetException extends Exception {
    /**
     * Constructs a new IntegerSetException with the specified detail message.
     *
     * @param message The detail message.
     */
    public IntegerSetException(String message) {
        super(message);
    }
}
