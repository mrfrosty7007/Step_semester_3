package oop.assignment_problems;

/**
 * Week 6 — S6: Classes and Objects Revision — Assignment Problem M2
 * Program: Payroll Salary Management
 * Concepts: Encapsulation, data protection, private fields, controlled mutating methods, read-only getter.
 */
public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Negative basic salary rejected. Starting at 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit bonus rejected: Amount must be positive.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Deduct tax rejected: Percentage must be between 0 and 100.");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        System.out.println("=== M2. Payroll Salary Management ===");

        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
