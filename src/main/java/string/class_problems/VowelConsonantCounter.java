package string.class_problems;

/**
 * Program: Vowel & Consonant Counter
 * Day 2 Live-Coding Session — Problem 1
 * Concepts: charAt(), length(), loops, case-insensitive character comparison.
 */
public class VowelConsonantCounter {

    /**
     * Counts vowels and consonants in the given text and prints the counts.
     * 
     * @param text The input string containing letters and spaces.
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Skip spaces and non-alphabet characters
            if (Character.isWhitespace(ch) || !Character.isLetter(ch)) {
                continue;
            }

            char lowerCh = Character.toLowerCase(ch);
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Vowel & Consonant Counter Demo ===");

        try {
            String sampleText = "Java Programming";
            System.out.println("Input: \"" + sampleText + "\"");
            System.out.print("Output: ");
            countVowelsAndConsonants(sampleText);
        } catch (Exception e) {
            System.err.println("Error processing text: " + e.getMessage());
        }
    }
}
