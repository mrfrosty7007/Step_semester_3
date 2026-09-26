package inheritance.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Assignment Problem 1
 * Program: The Canteen Billing Counter
 * Concepts: Common base class, method overriding, eliminating if-else type checks, polymorphic billing calculation.
 */
public class CanteenBillingCounter {

    // Common abstract base class for all canteen customers
    public static abstract class Customer {
        protected final String customerType;
        protected final double amount;

        public Customer(String customerType, double amount) {
            this.customerType = customerType;
            this.amount = amount;
        }

        public String getCustomerType() {
            return customerType;
        }

        public double getAmount() {
            return amount;
        }

        // Overridden by derived classes to apply customer-specific discounts or charges
        public abstract double calculateFinalAmount();
    }

    // Concrete Student customer: 10% discount on base bill
    public static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) {
            super("STUDENT", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.90;
        }
    }

    // Concrete Staff customer: 5% discount on base bill
    public static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) {
            super("STAFF", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.95;
        }
    }

    // Concrete Guest customer: Full amount plus ₹10 service charge
    public static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) {
            super("GUEST", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount + 10.0;
        }
    }

    // Factory method to instantiate the appropriate Customer subclass
    public static Customer createCustomer(String customerType, double amount) {
        if (customerType == null) {
            throw new IllegalArgumentException("Customer type cannot be null.");
        }
        return switch (customerType.trim().toUpperCase()) {
            case "STUDENT" -> new StudentCustomer(amount);
            case "STAFF" -> new StaffCustomer(amount);
            case "GUEST" -> new GuestCustomer(amount);
            default -> throw new IllegalArgumentException("Unknown customer type: " + customerType);
        };
    }

    // Polymorphic billing counter processing diverse customers without type checks
    public static void processBills(List<Customer> customers) {
        double grandTotal = 0.0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", c.getCustomerType(), finalAmount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Customer> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double amount = scanner.nextDouble();
                    list.add(createCustomer(type, amount));
                }
                processBills(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 1: The Canteen Billing Counter ===");
        List<Customer> customers = new ArrayList<>();
        customers.add(new StudentCustomer(200));
        customers.add(new StaffCustomer(300));
        customers.add(new GuestCustomer(150));

        processBills(customers);
    }
}
