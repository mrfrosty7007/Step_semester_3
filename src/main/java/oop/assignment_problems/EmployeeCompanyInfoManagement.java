package oop.assignment_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Assignment Problem M5
 * Program: Employee and Company Information Management
 * Concepts: Instance vs static members, class-level shared data, static method access without instance context.
 */
public class EmployeeCompanyInfoManagement {

    public static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== M5. Employee and Company Information Management ===");

        new Employee("Aditi", 50000);
        new Employee("Rohit", 60000);
        new Employee("Kavya", 75000);

        System.out.println("3 Employee objects created");
        Employee.printCompanyInfo();
    }
}
