package encapsulation.assignment_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Assignment Problem 3
 * Program: The Password Checker
 * Concepts: Immutable sensitive data, no getter for secret state, dynamic property evaluation.
 */
public final class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Password Checker ===");
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> \"" + pc.getStrength() + "\"");

        PasswordChecker pcMedium = new PasswordChecker("abcdefgh");
        System.out.println("pcMedium.getStrength() -> \"" + pcMedium.getStrength() + "\"");

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> \"" + pc2.getStrength() + "\"");
    }
}
