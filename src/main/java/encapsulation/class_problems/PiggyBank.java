package encapsulation.class_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Practice Problem 1
 * Program: The Piggy Bank
 * Concepts: Data hiding, private state, boundary validation, final identifier.
 */
public class PiggyBank {

    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("deposit(" + amount + ") -> savings = " + savings);
        } else {
            System.out.println("Deposit rejected: amount must be positive.");
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
        } else if (amount > savings) {
            System.out.println("withdraw(" + amount + ") -> rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("withdraw(" + amount + ") -> savings = " + savings);
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Piggy Bank ===");
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}
