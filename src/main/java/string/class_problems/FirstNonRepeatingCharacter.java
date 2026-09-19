package string.class_problems;

/**
 * Program: First Non-Repeating Character
 * Day 1 Live-Coding Session — Problem 4
 * Concepts: Character frequency counting, loops, array-based counting, early-exit scanning.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first non-repeating character in the given text.
     * 
     * @param text The input string to inspect.
     * @return The first unique character, or '\0' if none exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        // Frequency array for standard ASCII characters (0-255)
        int[] charFrequencies = new int[256];

        // First pass: count frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                charFrequencies[ch]++;
            }
        }

        // Second pass: find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && charFrequencies[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Sentinel indicating no unique character found
    }

    /**
     * Helper method to process input and display result matching sample output.
     */
    public static void displayFirstNonRepeatingChar(String text) {
        try {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("\"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + text + "\" -> No Non-Repeating Character Found");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game Demo ===");
        displayFirstNonRepeatingChar("swiss");
        displayFirstNonRepeatingChar("aabbcc");
    }
}
