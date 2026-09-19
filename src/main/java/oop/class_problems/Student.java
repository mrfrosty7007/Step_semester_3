package oop.class_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Practice Problem M5
 * Program: Student and College Information Management
 * Concepts: Static vs instance members, shared class-level variables, static methods without instance state.
 */
public class Student {

    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        System.out.println("=== M5. Student and College Information Management ===");

        new Student("Ravi", 85);
        new Student("Meera", 92);

        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}
