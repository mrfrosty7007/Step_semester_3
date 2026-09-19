package oop.class_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Practice Problem M2
 * Program: Hostel Mess Wallet Management
 * Concepts: Encapsulation, private fields, controlled mutations, input validation.
 */
public class MessWallet {

    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance rejected. Initialized to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be positive");
        } else {
            this.balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: Amount must be positive");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        System.out.println("=== M2. Hostel Mess Wallet Management ===");

        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());

        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
