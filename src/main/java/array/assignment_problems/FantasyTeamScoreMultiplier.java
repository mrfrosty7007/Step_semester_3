package array.assignment_problems;

import java.util.Arrays;

/**
 * Category C Assignment Problems — Problem 1 (Easy)
 * Program: Fantasy Team Score Multiplier
 * Topics: Creating/Modifying Arrays, Arrays Passed by Reference
 */
public class FantasyTeamScoreMultiplier {

    /**
     * Applies Captain (2x) and Vice-Captain (1.5x) multipliers directly to the original array.
     * Modifies the caller's original array directly — returns nothing at all.
     *
     * @param playerScores     Array of player scores (up to 15 elements).
     * @param captainIndex     0-based index of the chosen Captain.
     * @param viceCaptainIndex 0-based index of the chosen Vice-Captain.
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            throw new IllegalArgumentException("Scores array cannot be null.");
        }
        if (captainIndex < 0 || captainIndex >= playerScores.length) {
            throw new IndexOutOfBoundsException("Invalid captain index: " + captainIndex);
        }
        if (viceCaptainIndex < 0 || viceCaptainIndex >= playerScores.length) {
            throw new IndexOutOfBoundsException("Invalid vice-captain index: " + viceCaptainIndex);
        }
        if (captainIndex == viceCaptainIndex) {
            throw new IllegalArgumentException("Captain and Vice-Captain indices must be distinct.");
        }

        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fantasy Team Score Multiplier ===");
        double[] scores = {40, 55, 30, 62};
        System.out.println("Original Scores: " + Arrays.toString(scores));

        applyMultipliers(scores, 1, 3);
        System.out.println("After Multipliers (Captain=1, ViceCaptain=3): " + Arrays.toString(scores));
        // Expected: [40.0, 110.0, 30.0, 93.0]
    }
}
