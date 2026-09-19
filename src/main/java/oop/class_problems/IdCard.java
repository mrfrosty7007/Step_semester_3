package oop.class_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Practice Problem M4
 * Program: Library ID Card Management
 * Concepts: Object references, memory heap vs reference variables, identity comparison using == operator.
 */
public class IdCard {

    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        System.out.println("=== M4. Library ID Card Management ===");

        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // points to the same object reference
        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3); // new object created with identical data

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
