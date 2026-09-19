package array.assignment_problems;

import java.util.Arrays;

/**
 * Category C Assignment Problems — Problem 4 (Intermediate)
 * Program: Match Day Grid Analyzer
 * Topics: 2D Arrays, User-Defined Methods (reused), Loops
 */
public class MatchDayGridAnalyzer {

    /**
     * Computes the average runs per over for a single match row.
     * Reusable private helper method.
     *
     * @param row Array representing runs in each over of one match.
     * @return Average runs per over.
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    /**
     * Classifies each match as "Power Surge" (average >= threshold) or "Normal" (average < threshold).
     *
     * @param runsPerOver 2D array where each row represents one match.
     * @param threshold   Threshold average.
     * @return Formatted summary string.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "No matches to classify.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Match Day Grid Analyzer ===");
        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println("Grid: " + Arrays.deepToString(grid) + ", Threshold = " + threshold);
        System.out.println("Result: " + classifyMatches(grid, threshold));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
