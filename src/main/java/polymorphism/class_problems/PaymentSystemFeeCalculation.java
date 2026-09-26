package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Practice Problem 1
 * Program: Payment System Fee Calculation
 * Concepts: Common base class, method overriding, dynamic method dispatch, polymorphic collection.
 */
public class PaymentSystemFeeCalculation {

    // Abstract base class representing a generic payment method
    public static abstract class PaymentMethod {
        protected final String type;

        public PaymentMethod(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        // Overridden by derived classes with specialized fee calculation rules
        public abstract double calculateAdjustedAmount(double amount);
    }

    // Concrete derived class: Card payment applies a 2% fee
    public static class CardPayment extends PaymentMethod {
        public CardPayment() {
            super("CARD");
        }

        @Override
        public double calculateAdjustedAmount(double amount) {
            return amount * 1.02;
        }
    }

    // Concrete derived class: Wallet payment applies a 1% fee
    public static class WalletPayment extends PaymentMethod {
        public WalletPayment() {
            super("WALLET");
        }

        @Override
        public double calculateAdjustedAmount(double amount) {
            return amount * 1.01;
        }
    }

    // Concrete derived class: Bank Transfer payment applies no fee (0%)
    public static class BankTransferPayment extends PaymentMethod {
        public BankTransferPayment() {
            super("BANKTRANSFER");
        }

        @Override
        public double calculateAdjustedAmount(double amount) {
            return amount;
        }
    }

    // Encapsulated transaction record linking payment method with transaction amount
    public static class Transaction {
        private final PaymentMethod paymentMethod;
        private final double amount;

        public Transaction(PaymentMethod paymentMethod, double amount) {
            this.paymentMethod = paymentMethod;
            this.amount = amount;
        }

        public PaymentMethod getPaymentMethod() {
            return paymentMethod;
        }

        public double getAmount() {
            return amount;
        }

        // Polymorphic delegation: executes derived class fee calculation
        public double getAdjustedAmount() {
            return paymentMethod.calculateAdjustedAmount(amount);
        }
    }

    // Factory method to instantiate the appropriate PaymentMethod object
    public static PaymentMethod createPaymentMethod(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null.");
        }
        return switch (type.trim().toUpperCase()) {
            case "CARD" -> new CardPayment();
            case "WALLET" -> new WalletPayment();
            case "BANKTRANSFER" -> new BankTransferPayment();
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }

    // Central processing engine operating polymorphically on Transaction collections
    public static void processTransactions(List<Transaction> transactions) {
        double grandTotal = 0.0;
        for (Transaction tx : transactions) {
            double adjusted = tx.getAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf(Locale.US, "%s: %.2f%n", tx.getPaymentMethod().getType(), adjusted);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Transaction> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double amount = scanner.nextDouble();
                    list.add(new Transaction(createPaymentMethod(type), amount));
                }
                processTransactions(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 1: Payment System Fee Calculation ===");
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(new CardPayment(), 1000.0));
        transactions.add(new Transaction(new WalletPayment(), 500.0));
        transactions.add(new Transaction(new BankTransferPayment(), 2000.0));

        processTransactions(transactions);
    }
}

