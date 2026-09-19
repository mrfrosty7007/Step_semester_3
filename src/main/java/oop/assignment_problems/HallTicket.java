package oop.assignment_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Assignment Problem M4
 * Program: Exam Hall Ticket Reference Management
 * Concepts: Reference variables, object aliasing, instance variable mutations, reference equality (==).
 */
public class HallTicket {

    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        System.out.println("=== M4. Exam Hall Ticket Reference Management ===");

        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya; // Points to the same object
        copy.seatNumber = 45;

        HallTicket separate = new HallTicket("Priya", 45); // Distinct object with identical values

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
