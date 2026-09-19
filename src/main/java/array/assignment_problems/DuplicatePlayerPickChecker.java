package array.assignment_problems;

import java.util.Arrays;

/**
 * Category C Assignment Problems — Problem 2 (Easy)
 * Program: Duplicate Player Pick Checker
 * Topics: Arrays, Strings, Nested Loops (No Collections)
 */
public class DuplicatePlayerPickChecker {

    /**
     * Checks for repeated player names using nested loops.
     * Scans pairwise in order and reports the first duplicate found.
     *
     * @param playerNames Array of player names in the lineup (up to 11 players).
     * @return "Duplicate Found: <name>" or "No Duplicates Found".
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            if (playerNames[i] == null) continue;
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Player Pick Checker ===");

        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Lineup: " + Arrays.toString(lineup1));
        System.out.println("Result: " + findDuplicatePick(lineup1));
        // Expected: Duplicate Found: Kohli

        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("\nLineup: " + Arrays.toString(lineup2));
        System.out.println("Result: " + findDuplicatePick(lineup2));
        // Expected: No Duplicates Found
    }
}
