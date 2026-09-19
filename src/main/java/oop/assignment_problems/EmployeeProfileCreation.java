package oop.assignment_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Assignment Problem M3
 * Program: Employee Profile Creation
 * Concepts: Multiple constructors, constructor chaining via this(...), object state initialization.
 */
public class EmployeeProfileCreation {

    public static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        // Permanent employee constructor
        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        // Intern constructor chaining to the 3-argument constructor
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== M3. Employee Profile Creation ===");

        Employee permanentEmp = new Employee("E-101", "Divya", 65000);
        Employee internEmp = new Employee("E-102", "Arjun");

        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}
