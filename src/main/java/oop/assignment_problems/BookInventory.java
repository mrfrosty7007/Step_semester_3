package oop.assignment_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Assignment Problem M1
 * Program: Library Inventory Management
 * Concepts: Class definition, instance fields, parameterized constructor, instance method, array of objects.
 */
public class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        System.out.println("=== M1. Library Inventory Management ===");

        BookInventory[] inventory = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
