package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The IntegerSet class represents a collection of unique integers.
 * It provides methods to perform standard set operations such as union,
 * intersection, difference, and complement. This class ensures that
 * no duplicate integers are present in the set.
 */
public class IntegerSet {
    // Internal storage for the set elements.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor.
     * Initializes an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set with an existing list of integers.
     * Ensures that only unique integers are added to the set.
     *
     * @param set An ArrayList of integers to initialize the set.
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (Integer item : set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return The size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if another object is equal to this set.
     * Two IntegerSet objects are considered equal if they contain
     * the same integers, regardless of their order.
     *
     * @param o The object to compare with.
     * @return true if both sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof IntegerSet))
            return false;
        IntegerSet otherSet = (IntegerSet) o;
        if (this.length() != otherSet.length())
            return false;
        List<Integer> sortedThis = new ArrayList<>(this.set);
        List<Integer> sortedOther = new ArrayList<>(otherSet.set);
        Collections.sort(sortedThis);
        Collections.sort(sortedOther);
        return sortedThis.equals(sortedOther);
    }

    /**
     * Checks whether the set contains a specific integer.
     *
     * @param value The integer to search for.
     * @return true if the integer is present, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Retrieves the largest integer in the set.
     *
     * @return The maximum integer in the set.
     * @throws IllegalStateException if the set is empty.
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Retrieves the smallest integer in the set.
     *
     * @return The minimum integer in the set.
     * @throws IllegalStateException if the set is empty.
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds an integer to the set if it is not already present.
     *
     * @param item The integer to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an integer from the set if it exists.
     *
     * @param item The integer to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union of this set with another IntegerSet.
     * The resulting set contains all unique elements from both sets.
     *
     * @param intSetb The IntegerSet to unite with.
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Performs the intersection of this set with another IntegerSet.
     * The resulting set contains only elements that are present in both sets.
     *
     * @param intSetb The IntegerSet to intersect with.
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> intersection = new ArrayList<>();
        for (Integer item : this.set) {
            if (intSetb.set.contains(item)) {
                intersection.add(item);
            }
        }
        this.set = intersection;
    }

    /**
     * Performs the difference between this set and another IntegerSet (this set minus intSetb).
     * The resulting set contains elements that are in this set but not in intSetb.
     *
     * @param intSetb The IntegerSet to subtract from this set.
     */
    public void diff(IntegerSet intSetb) {
        List<Integer> difference = new ArrayList<>();
        for (Integer item : this.set) {
            if (!intSetb.set.contains(item)) {
                difference.add(item);
            }
        }
        this.set = difference;
    }

    /**
     * Performs the complement of this set with respect to another IntegerSet.
     * The resulting set contains elements that are in intSetb but not in this set.
     *
     * @param intSetb The IntegerSet to complement with.
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complement = new ArrayList<>();
        for (Integer item : intSetb.set) {
            if (!this.set.contains(item)) {
                complement.add(item);
            }
        }
        this.set = complement;
    }

    /**
     * Checks if the set is empty.
     *
     * @return true if the set has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * The elements are enclosed in square brackets and separated by commas.
     *
     * @return A string representing the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
