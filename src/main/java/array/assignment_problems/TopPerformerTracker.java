package array.assignment_problems;

import java.util.Arrays;

/**
 * Category C Assignment Problems — Problem 3 (Intermediate)
 * Program: Top Performer Tracker
 * Topics: Arrays, Loops, Logical Thinking, Single-Pass Min/Max Tracking
 */
public class TopPerformerTracker {

    /**
     * Finds the minimum score, maximum score, and spread in a single pass without sorting.
     *
     * @param scores Array of scores (length >= 2, up to 10,000).
     * @return Formatted string: "Min: <min> | Max: <max> | Spread: <spread>".
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Scores array must contain at least 2 elements.");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top Performer Tracker ===");
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Result: " + findMinMaxSpread(scores));
        // Expected: Min: 33 | Max: 90 | Spread: 57
    }
}
