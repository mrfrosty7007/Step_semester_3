package inheritance.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Assignment Problem 4
 * Program: The Festival Bonus Calculator
 * Concepts: Common base class sharing name and salary state, polymorphic bonus calculation, payroll iteration.
 */
public class FestivalBonusCalculator {

    // Common abstract base class for all employees
    public static abstract class Employee {
        protected final String employeeType;
        protected final String name;
        protected final double monthlySalary;

        public Employee(String employeeType, String name, double monthlySalary) {
            this.employeeType = employeeType;
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getEmployeeType() {
            return employeeType;
        }

        public String getName() {
            return name;
        }

        public double getMonthlySalary() {
            return monthlySalary;
        }

        // Overridden by derived classes according to employment category
        public abstract double calculateBonus();
    }

    // Concrete Full-time employee: 10% of monthly salary
    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super("FULLTIME", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    // Concrete Part-time employee: 5% of monthly salary
    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super("PARTTIME", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    // Concrete Intern: Fixed bonus of ₹2,000 irrespective of monthly salary
    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double monthlySalary) {
            super("INTERN", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return 2000.0;
        }
    }

    // Factory method to create specific Employee subclass
    public static Employee createEmployee(String employeeType, String name, double salary) {
        if (employeeType == null) {
            throw new IllegalArgumentException("Employee type cannot be null.");
        }
        return switch (employeeType.trim().toUpperCase()) {
            case "FULLTIME" -> new FullTimeEmployee(name, salary);
            case "PARTTIME" -> new PartTimeEmployee(name, salary);
            case "INTERN" -> new InternEmployee(name, salary);
            default -> throw new IllegalArgumentException("Unknown employee type: " + employeeType);
        };
    }

    // Payroll system calculating bonuses across diverse employee types uniformly
    public static void processPayroll(List<Employee> employees) {
        double grandTotal = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf(Locale.US, "%s: %.2f%n", emp.getName(), bonus);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Employee> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    String name = scanner.next();
                    double salary = scanner.nextDouble();
                    list.add(createEmployee(type, name, salary));
                }
                processPayroll(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 4: The Festival Bonus Calculator ===");
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("Asha", 50000));
        employees.add(new PartTimeEmployee("Ravi", 30000));
        employees.add(new InternEmployee("Neha", 15000));

        processPayroll(employees);
    }
}
