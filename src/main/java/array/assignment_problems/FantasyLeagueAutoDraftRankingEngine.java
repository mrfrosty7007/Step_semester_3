package array.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Category C Assignment Problems — Problem 5 (Advanced)
 * Program: Fantasy League Auto-Draft Ranking Engine
 * Topics: Arrays, Method Overloading, Static Methods, Standard Library (Arrays.sort),
 *         Constructors & Encapsulation, Comparable interface
 */
public class FantasyLeagueAutoDraftRankingEngine {

    /**
     * Player class implementing Comparable<Player> to sort descending by batting average.
     */
    public static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            // Rank by fantasy points / batting average descending
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name + " (" + battingAverage + ")";
        }
    }

    /**
     * Overloaded Rule 1: Established player qualifies on experience alone (matches >= 10) regardless of fitness.
     *
     * @param matchesPlayed Total matches played.
     * @return true if matchesPlayed >= 10.
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded Rule 2: Newer players qualify if reasonably experienced (matches >= 5) and not currently injured.
     *
     * @param matchesPlayed Total matches played.
     * @param injured       Current injury status.
     * @return true if !injured and matchesPlayed >= 5.
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return !injured && matchesPlayed >= 5;
    }

    /**
     * Filters draftable players using overloaded checks, sorts them using Arrays.sort,
     * and produces the formatted ranking string.
     *
     * @param players Array of submitted players.
     * @return Formatted ranking string: "1. Name | 2. Name | 3. Name"
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "No players drafted.";
        }

        List<Player> eligible = new ArrayList<>();
        for (Player p : players) {
            if (p == null) continue;
            // Player qualifies if they meet the experience-only rule OR the combined fitness rule
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                eligible.add(p);
            }
        }

        if (eligible.isEmpty()) {
            return "No eligible players drafted.";
        }

        Player[] draftableArray = eligible.toArray(new Player[0]);
        // Plain Arrays.sort using Player's compareTo implementation
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Fantasy League Auto-Draft Ranking Engine ===");
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String ranking = draftAndRank(players);
        System.out.println("Result: " + ranking);
        // Expected: 1. Rahul | 2. Virat | 3. Dev
    }
}
