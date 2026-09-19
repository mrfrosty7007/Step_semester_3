package string.class_problems;

/**
 * Program: Palindrome Checker (3 Approaches)
 * Day 1 Live-Coding Session — Problem 2
 * Concepts: Loops, recursion, array manipulation, string comparison.
 */
public class PalindromeChecker {

    /**
     * Approach 1: Iterative check comparing characters from both ends moving toward middle.
     * 
     * @param text Input text.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        int leftIndex = 0;
        int rightIndex = text.length() - 1;

        while (leftIndex < rightIndex) {
            if (text.charAt(leftIndex) != text.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check comparing first and last characters, shrinking substring.
     * 
     * @param text Input text.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        // Base case: length 0 or 1 is always palindrome
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array-reversal check converting string to char array, reversing, and comparing.
     * 
     * @param text Input text.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        char[] originalChars = text.toCharArray();
        int length = originalChars.length;
        char[] reversedChars = new char[length];

        for (int i = 0; i < length; i++) {
            reversedChars[i] = originalChars[length - 1 - i];
        }

        for (int i = 0; i < length; i++) {
            if (originalChars[i] != reversedChars[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to format palindrome status string.
     */
    private static String formatStatus(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    /**
     * Evaluates a string using all three methods and prints results.
     */
    public static void checkAllApproaches(String text) {
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean reversalResult = isPalindromeArrayReversal(text);

        System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s\n",
                text,
                formatStatus(iterativeResult),
                formatStatus(recursiveResult),
                formatStatus(reversalResult));
    }

    public static void main(String[] args) {
        try {
            System.out.println("=== Palindrome Checker (3 Approaches) Demo ===");
            checkAllApproaches("madam");
            checkAllApproaches("hello");
        } catch (Exception e) {
            System.err.println("Error running Palindrome Checker: " + e.getMessage());
        }
    }
}
