package string.assignment_problems;

/**
 * Program: The Typing Speed Test Accuracy Checker
 * Week 1 Assignment — Problem 2
 * Concepts: String traversal, charAt(), loops, conditional logic, percentage calculation.
 */
public class TypingSpeedAccuracyChecker {

    /**
     * Compares the user's typed passage against the original passage character by character.
     * 
     * @param original The expected original text.
     * @param typed The user's typed submission.
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            throw new IllegalArgumentException("Passages cannot be null.");
        }

        if (original.length() != typed.length()) {
            throw new IllegalArgumentException("Original and typed strings must be of equal length for comparison.");
        }

        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char originalMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typeChar = typed.charAt(i);

            if (origChar == typeChar) {
                matchedChars++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based indexing for display
                originalMismatchChar = origChar;
                typedMismatchChar = typeChar;
            }
        }

        double accuracyPercentage = ((double) matchedChars / totalChars) * 100.0;

        StringBuilder report = new StringBuilder();
        report.append(String.format("Matched: %d/%d | Accuracy: %.2f%%", matchedChars, totalChars, accuracyPercentage));

        if (firstMismatchPos != -1) {
            report.append(String.format(" | First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, originalMismatchChar, typedMismatchChar));
        } else {
            report.append(" | No Mismatches");
        }

        System.out.println(report.toString());
    }

    public static void main(String[] args) {
        System.out.println("=== Typing Speed Test Accuracy Checker Demo ===");

        try {
            // Test Case 1: With mismatch
            String orig1 = "hello world";
            String typed1 = "hello worlt";
            System.out.println("original=\"" + orig1 + "\", typed=\"" + typed1 + "\"");
            checkTypingAccuracy(orig1, typed1);

            // Test Case 2: Perfect match
            String orig2 = "coding";
            String typed2 = "coding";
            System.out.println("\noriginal=\"" + orig2 + "\", typed=\"" + typed2 + "\"");
            checkTypingAccuracy(orig2, typed2);
        } catch (Exception e) {
            System.err.println("Error evaluating typing accuracy: " + e.getMessage());
        }
    }
}
