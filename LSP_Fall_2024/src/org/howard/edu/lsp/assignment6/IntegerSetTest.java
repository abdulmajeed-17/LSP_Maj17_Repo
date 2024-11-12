package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for the IntegerSet class.
 * This class contains comprehensive tests to verify the correctness
 * of each public method in the IntegerSet class.
 */
public class IntegerSetTest {

    /**
     * Helper method to create a new IntegerSet with given elements.
     * This method simplifies the creation of sets with predefined elements
     * for use in multiple test cases.
     *
     * @param elements The integers to add to the set.
     * @return A new IntegerSet containing the specified elements.
     */
    private IntegerSet createSet(int... elements) {
        IntegerSet set = new IntegerSet();
        for (int elem : elements) {
            set.add(elem);
        }
        return set;
    }

    /**
     * Test the clear method to ensure it removes all elements from the set.
     * Verifies that the set is empty and its length is zero after clearing.
     */
    @Test
    @DisplayName("Test clear method")
    public void testClear() {
        // Initialize the set with elements
        IntegerSet set = createSet(1, 2, 3);
        // Clear the set
        set.clear();
        // Assert that the set is empty
        assertEquals(0, set.length(), "Set should be empty after clear.");
        assertTrue(set.isEmpty(), "Set should be empty after clear.");
    }

    /**
     * Test the length method to ensure it accurately reflects the number
     * of elements in the set after various operations.
     */
    @Test
    @DisplayName("Test length method")
    public void testLength() {
        // Initialize the set with three elements
        IntegerSet set = createSet(1, 2, 3);
        // Assert initial length
        assertEquals(3, set.length(), "Set length should be 3.");

        // Add another element
        set.add(4);
        // Assert updated length
        assertEquals(4, set.length(), "Set length should be 4 after adding an element.");

        // Remove an element
        set.remove(2);
        // Assert updated length
        assertEquals(3, set.length(), "Set length should be 3 after removing an element.");
    }

    /**
     * Test the equals method to ensure it correctly determines set equality.
     * Verifies that sets with the same elements in different orders are equal,
     * and sets with different elements are not equal.
     */
    @Test
    @DisplayName("Test equals method")
    public void testEquals() {
        // Create two sets with the same elements in different orders
        IntegerSet set1 = createSet(1, 2, 3);
        IntegerSet set2 = createSet(3, 2, 1);
        // Create a set with different elements
        IntegerSet set3 = createSet(1, 2, 4);

        // Assert that set1 and set2 are equal
        assertTrue(set1.equals(set2), "Sets with same elements in different order should be equal.");
        // Assert that set1 and set3 are not equal
        assertFalse(set1.equals(set3), "Sets with different elements should not be equal.");
        // Assert that set1 is not equal to null
        assertFalse(set1.equals(null), "Set should not be equal to null.");
        // Assert that set1 is not equal to an object of a different type
        assertFalse(set1.equals(new Object()), "Set should not be equal to an object of different type.");
    }

    /**
     * Test the contains method to verify that it correctly identifies
     * whether specific elements are present in the set.
     */
    @Test
    @DisplayName("Test contains method")
    public void testContains() {
        // Initialize the set with elements
        IntegerSet set = createSet(1, 2, 3);
        // Assert that the set contains element 2
        assertTrue(set.contains(2), "Set should contain 2.");
        // Assert that the set does not contain element 4
        assertFalse(set.contains(4), "Set should not contain 4.");
    }

    /**
     * Test the largest method to ensure it correctly identifies the largest element
     * in the set. Also verifies that the largest element updates correctly
     * after adding a new maximum element.
     */
    @Test
    @DisplayName("Test largest method")
    public void testLargest() throws IntegerSetException {
        // Initialize the set with elements
        IntegerSet set = createSet(1, 3, 5, 7);
        // Assert that the largest element is 7
        assertEquals(7, set.largest(), "Largest element should be 7.");

        // Add a new largest element
        set.add(10);
        // Assert that the largest element is now 10
        assertEquals(10, set.largest(), "Largest element should be updated to 10.");
    }

    /**
     * Test the largest method to ensure it throws an IntegerSetException
     * when called on an empty set.
     */
    @Test
    @DisplayName("Test largest method with empty set")
    public void testLargestException() {
        // Initialize an empty set
        IntegerSet set = new IntegerSet();
        // Attempt to retrieve the largest element and expect an exception
        Exception exception = assertThrows(IntegerSetException.class, set::largest, 
            "Should throw IntegerSetException when set is empty.");
        // Assert that the exception message is as expected
        assertEquals("Set is empty.", exception.getMessage(), 
            "Exception message should indicate the set is empty.");
    }

    /**
     * Test the smallest method to ensure it correctly identifies the smallest element
     * in the set. Also verifies that the smallest element updates correctly
     * after removing the current smallest element.
     */
    @Test
    @DisplayName("Test smallest method")
    public void testSmallest() throws IntegerSetException {
        // Initialize the set with elements
        IntegerSet set = createSet(2, 4, 6, 8);
        // Assert that the smallest element is 2
        assertEquals(2, set.smallest(), "Smallest element should be 2.");

        // Remove the smallest element
        set.remove(2);
        // Assert that the smallest element is now 4
        assertEquals(4, set.smallest(), "Smallest element should be updated to 4.");
    }

    /**
     * Test the smallest method to ensure it throws an IntegerSetException
     * when called on an empty set.
     */
    @Test
    @DisplayName("Test smallest method with empty set")
    public void testSmallestException() {
        // Initialize an empty set
        IntegerSet set = new IntegerSet();
        // Attempt to retrieve the smallest element and expect an exception
        Exception exception = assertThrows(IntegerSetException.class, set::smallest, 
            "Should throw IntegerSetException when set is empty.");
        // Assert that the exception message is as expected
        assertEquals("Set is empty.", exception.getMessage(), 
            "Exception message should indicate the set is empty.");
    }

    /**
     * Test the add method to ensure it correctly adds elements to the set
     * and prevents duplicate entries.
     */
    @Test
    @DisplayName("Test add method")
    public void testAdd() {
        // Initialize an empty set
        IntegerSet set = new IntegerSet();
        // Add an element
        set.add(1);
        // Assert that the set contains the added element
        assertTrue(set.contains(1), "Set should contain 1 after adding.");
        // Assert that the length is updated correctly
        assertEquals(1, set.length(), "Set length should be 1 after adding one element.");

        // Attempt to add a duplicate element
        set.add(1);
        // Assert that the length remains unchanged
        assertEquals(1, set.length(), "Set length should remain 1 after adding duplicate.");
    }

    /**
     * Test the remove method to ensure it correctly removes elements from the set
     * and does not affect the set when attempting to remove non-existent elements.
     */
    @Test
    @DisplayName("Test remove method")
    public void testRemove() {
        // Initialize the set with elements
        IntegerSet set = createSet(1, 2, 3);
        // Remove an existing element
        set.remove(2);
        // Assert that the set no longer contains the removed element
        assertFalse(set.contains(2), "Set should not contain 2 after removal.");
        // Assert that the length is updated correctly
        assertEquals(2, set.length(), "Set length should be 2 after removal.");

        // Attempt to remove a non-existent element
        set.remove(4);
        // Assert that the length remains unchanged
        assertEquals(2, set.length(), "Set length should remain 2 when removing non-existent element.");
    }

    /**
     * Test the union method to ensure it correctly combines elements from two sets,
     * preserving uniqueness of elements.
     */
    @Test
    @DisplayName("Test union method")
    public void testUnion() {
        // Initialize two sets with overlapping elements
        IntegerSet set1 = createSet(1, 2, 3);
        IntegerSet set2 = createSet(3, 4, 5);

        // Perform the union operation
        set1.union(set2);
        // Assert that all unique elements are present in the resulting set
        assertTrue(set1.contains(1), "Set1 should contain 1 after union.");
        assertTrue(set1.contains(2), "Set1 should contain 2 after union.");
        assertTrue(set1.contains(3), "Set1 should contain 3 after union.");
        assertTrue(set1.contains(4), "Set1 should contain 4 after union.");
        assertTrue(set1.contains(5), "Set1 should contain 5 after union.");
        // Assert that the length reflects the total unique elements
        assertEquals(5, set1.length(), "Set1 length should be 5 after union.");
    }

    /**
     * Test the intersect method to ensure it correctly retains only common elements
     * between two sets.
     */
    @Test
    @DisplayName("Test intersect method")
    public void testIntersect() {
        // Initialize two sets with some common elements
        IntegerSet set1 = createSet(1, 2, 3, 4);
        IntegerSet set2 = createSet(3, 4, 5, 6);

        // Perform the intersection operation
        set1.intersect(set2);
        // Assert that only common elements are retained
        assertFalse(set1.contains(1), "Set1 should not contain 1 after intersection.");
        assertFalse(set1.contains(2), "Set1 should not contain 2 after intersection.");
        assertTrue(set1.contains(3), "Set1 should contain 3 after intersection.");
        assertTrue(set1.contains(4), "Set1 should contain 4 after intersection.");
        // Assert that the length reflects the number of common elements
        assertEquals(2, set1.length(), "Set1 length should be 2 after intersection.");
    }

    /**
     * Test the diff method to ensure it correctly computes the difference between two sets,
     * retaining only elements present in the first set but not in the second.
     */
    @Test
    @DisplayName("Test diff method")
    public void testDiff() {
        // Initialize two sets with overlapping elements
        IntegerSet set1 = createSet(1, 2, 3, 4);
        IntegerSet set2 = createSet(3, 4, 5, 6);

        // Perform the difference operation (set1 - set2)
        set1.diff(set2);
        // Assert that only elements unique to set1 are retained
        assertTrue(set1.contains(1), "Set1 should contain 1 after difference.");
        assertTrue(set1.contains(2), "Set1 should contain 2 after difference.");
        assertFalse(set1.contains(3), "Set1 should not contain 3 after difference.");
        assertFalse(set1.contains(4), "Set1 should not contain 4 after difference.");
        // Assert that the length reflects the number of unique elements
        assertEquals(2, set1.length(), "Set1 length should be 2 after difference.");
    }

    /**
     * Test the complement method to ensure it correctly computes the complement of a set
     * with respect to a universal set, retaining only elements present in the universal set
     * but not in the original set.
     */
    @Test
    @DisplayName("Test complement method")
    public void testComplement() {
        // Initialize the universal set and a subset
        IntegerSet universalSet = createSet(1, 2, 3, 4, 5, 6);
        IntegerSet set1 = createSet(2, 4, 6);

        // Perform the complement operation (universalSet - set1)
        set1.complement(universalSet);
        // Assert that elements not in set1 are present in the complement
        assertTrue(set1.contains(1), "Set1 should contain 1 after complement.");
        assertFalse(set1.contains(2), "Set1 should not contain 2 after complement.");
        assertTrue(set1.contains(3), "Set1 should contain 3 after complement.");
        assertFalse(set1.contains(4), "Set1 should not contain 4 after complement.");
        assertTrue(set1.contains(5), "Set1 should contain 5 after complement.");
        assertFalse(set1.contains(6), "Set1 should not contain 6 after complement.");
        // Assert that the length reflects the number of complemented elements
        assertEquals(3, set1.length(), "Set1 length should be 3 after complement.");
    }

    /**
     * Test the isEmpty method to ensure it accurately reports whether the set is empty.
     * Verifies the method in different scenarios: newly created, after adding elements,
     * and after clearing the set.
     */
    @Test
    @DisplayName("Test isEmpty method")
    public void testIsEmpty() {
        // Initialize an empty set
        IntegerSet set = new IntegerSet();
        // Assert that the new set is empty
        assertTrue(set.isEmpty(), "New set should be empty.");

        // Add an element to the set
        set.add(1);
        // Assert that the set is no longer empty
        assertFalse(set.isEmpty(), "Set should not be empty after adding an element.");

        // Clear the set
        set.clear();
        // Assert that the set is empty again
        assertTrue(set.isEmpty(), "Set should be empty after clearing.");
    }

    /**
     * Test the toString method to ensure it returns the correct string representation
     * of the set. Verifies the method after adding and removing elements.
     */
    @Test
    @DisplayName("Test toString method")
    public void testToString() {
        // Initialize the set with elements
        IntegerSet set = createSet(1, 2, 3);
        // Define the expected string representation
        String expected = "[1, 2, 3]";
        // Assert that toString returns the correct representation
        assertEquals(expected, set.toString(), "toString should return the correct string representation.");

        // Add another element
        set.add(4);
        // Update the expected string
        expected = "[1, 2, 3, 4]";
        // Assert the updated string representation
        assertEquals(expected, set.toString(), "toString should update after adding elements.");

        // Remove an element
        set.remove(2);
        // Update the expected string
        expected = "[1, 3, 4]";
        // Assert the updated string representation
        assertEquals(expected, set.toString(), "toString should update after removing elements.");
    }

    /**
     * Test adding negative numbers to ensure that the set correctly handles
     * negative integers.
     */
    @Test
    @DisplayName("Test adding negative numbers")
    public void testAddNegativeNumbers() {
        // Initialize an empty set
        IntegerSet set = new IntegerSet();
        // Add negative integers
        set.add(-1);
        set.add(-2);
        // Assert that the set contains the added negative integers
        assertTrue(set.contains(-1), "Set should contain -1.");
        assertTrue(set.contains(-2), "Set should contain -2.");
        // Assert that the length reflects the number of added elements
        assertEquals(2, set.length(), "Set length should be 2 after adding negative numbers.");
    }

    /**
     * Test adding large numbers to ensure that the set correctly handles
     * boundary integer values.
     */
    @Test
    @DisplayName("Test adding large numbers")
    public void testAddLargeNumbers() {
        // Initialize an empty set
        IntegerSet set = new IntegerSet();
        // Add maximum and minimum integer values
        set.add(Integer.MAX_VALUE);
        set.add(Integer.MIN_VALUE);
        // Assert that the set contains the added large integers
        assertTrue(set.contains(Integer.MAX_VALUE), "Set should contain Integer.MAX_VALUE.");
        assertTrue(set.contains(Integer.MIN_VALUE), "Set should contain Integer.MIN_VALUE.");
        // Assert that the length reflects the number of added elements
        assertEquals(2, set.length(), "Set length should be 2 after adding large numbers.");
    }

    /**
     * Test performing set operations on empty sets to ensure that methods
     * behave correctly when operating on empty collections.
     */
    @Test
    @DisplayName("Test operations on empty sets")
    public void testOperationsOnEmptySets() {
        // Initialize two empty sets
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // Perform union of two empty sets
        set1.union(set2);
        // Assert that the union of two empty sets is still empty
        assertTrue(set1.isEmpty(), "Union of two empty sets should be empty.");

        // Perform intersection of two empty sets
        set1.intersect(set2);
        // Assert that the intersection of two empty sets is still empty
        assertTrue(set1.isEmpty(), "Intersection of two empty sets should be empty.");

        // Perform difference of two empty sets
        set1.diff(set2);
        // Assert that the difference of two empty sets is still empty
        assertTrue(set1.isEmpty(), "Difference of two empty sets should be empty.");

        // Perform complement of two empty sets
        set1.complement(set2);
        // Assert that the complement of two empty sets is still empty
        assertTrue(set1.isEmpty(), "Complement of two empty sets should be empty.");
    }
}
