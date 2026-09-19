package string.assignment_problems;

/**
 * Program: The Traffic Signal Streak Analyzer
 * Week 1 Assignment — Problem 3
 * Concepts: String traversal, character comparison, loops, tracking a running maximum.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Finds and prints the longest continuous streak of identical signal color readings.
     * 
     * @param signalLog String containing sequential signal readings (e.g., 'R', 'G', 'Y').
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Invalid input: Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char nextColor = signalLog.charAt(i);

            if (nextColor == currentColor) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    longestColor = currentColor;
                }
                currentColor = nextColor;
                currentStreakLength = 1;
            }
        }

        // Final check for trailing streak
        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times\n", longestColor, maxStreakLength);
    }

    public static void main(String[] args) {
        System.out.println("=== Traffic Signal Streak Analyzer Demo ===");

        String log1 = "RRGGGYRR";
        System.out.print("\"" + log1 + "\" -> ");
        findLongestStreak(log1);

        String log2 = "RRRRYYGG";
        System.out.print("\"" + log2 + "\" -> ");
        findLongestStreak(log2);
    }
}
