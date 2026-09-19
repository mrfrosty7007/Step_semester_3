package string.assignment_problems;

import java.util.*;

/**
 * Program: Stop-Word-Filtered Word Frequency Report
 * Week 2 Assignment — Problem 5
 * Concepts: replace(), split() with whitespace pattern, stop-word filtering, frequency counting, sorting by count.
 */
public class StopWordFilteredFrequencyReport {

    // Fixed stop words list to exclude common filler words
    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Filters out stop words and prints word frequencies sorted in descending order.
     * 
     * @param feedback Paragraph text containing user feedback.
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("Invalid input: Feedback is empty.");
            return;
        }

        // Normalize: convert to lowercase and strip punctuation using replace()
        String normalized = feedback.toLowerCase();
        normalized = normalized.replace(".", "")
                               .replace(",", "")
                               .replace("!", "")
                               .replace("?", "")
                               .replace(";", "")
                               .replace(":", "")
                               .replace("\"", "");

        // Split cleaned text into words
        String[] words = normalized.trim().split("\\s+");

        // Map to store frequency of words
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            String trimmedWord = word.trim();
            if (trimmedWord.isEmpty() || STOP_WORDS.contains(trimmedWord)) {
                continue; // Skip filler words
            }

            frequencyMap.put(trimmedWord, frequencyMap.getOrDefault(trimmedWord, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print formatted frequency report
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stop-Word-Filtered Word Frequency Report Demo ===");

        String feedbackText = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + feedbackText + "\"\nOutput:");
        printFilteredWordFrequency(feedbackText);
    }
}
