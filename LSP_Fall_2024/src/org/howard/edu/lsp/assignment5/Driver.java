package org.howard.edu.lsp.assignment5;

/**
 * The Driver class contains the main method to test the IntegerSet class.
 * It demonstrates the functionality of various set operations and ensures
 * that the IntegerSet class behaves as expected.
 */
public class Driver {
    public static void main(String[] args) {
        // Create first IntegerSet and add elements
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());

        // Create second IntegerSet and add elements
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        // Reset set1 for further operations
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Intersection
        System.out.println("\nIntersection of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Result of intersection of Set1 and Set2: " + set1.toString());

        // Difference
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("\nDifference of Set1 and Set2 (Set1 - Set2)");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.diff(set2);
        System.out.println("Result of difference of Set1 and Set2: " + set1.toString());

        // Complement
        System.out.println("\nComplement of Set1 with respect to Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.complement(set2);
        System.out.println("Result of complement of Set1 with respect to Set2: " + set1.toString());

        // Check if set is empty
        System.out.println("\nIs Set1 empty? " + set1.isEmpty());
        set1.clear();
        System.out.println("After clearing, is Set1 empty? " + set1.isEmpty());

        // Test equals method
        IntegerSet set3 = new IntegerSet();
        set3.add(4);
        set3.add(5);
        System.out.println("\nSet2: " + set2.toString());
        System.out.println("Set3: " + set3.toString());
        System.out.println("Does Set2 equal Set3? " + set2.equals(set3));

        set3.add(6);
        System.out.println("After adding 6 to Set3: " + set3.toString());
        System.out.println("Does Set2 equal Set3? " + set2.equals(set3));

        // Test contains method
        System.out.println("\nDoes Set2 contain 3? " + set2.contains(3));
        System.out.println("Does Set2 contain 6? " + set2.contains(6));
    }
}
