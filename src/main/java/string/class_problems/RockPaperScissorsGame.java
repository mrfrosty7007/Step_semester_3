package string.class_problems;

import java.util.Random;

/**
 * Program: Rock-Paper-Scissors Game
 * Day 1 Live-Coding Session — Problem 1
 * Concepts: Random generation, conditional logic, loops, arrays, formatted output, statistics.
 */
public class RockPaperScissorsGame {

    // Constant array of valid moves
    private static final String[] VALID_MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the outcome of a single round of Rock-Paper-Scissors.
     * 
     * @param playerMove The move chosen by the player.
     * @param computerMove The move chosen by the computer.
     * @return Result string ("Player Wins", "Computer Wins", or "Draw").
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Moves cannot be null.");
        }

        String normalizedPlayer = playerMove.trim();
        String normalizedComputer = computerMove.trim();

        if (normalizedPlayer.equalsIgnoreCase(normalizedComputer)) {
            return "Draw";
        }

        if ((normalizedPlayer.equalsIgnoreCase("Rock") && normalizedComputer.equalsIgnoreCase("Scissors")) ||
            (normalizedPlayer.equalsIgnoreCase("Paper") && normalizedComputer.equalsIgnoreCase("Rock")) ||
            (normalizedPlayer.equalsIgnoreCase("Scissors") && normalizedComputer.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    /**
     * Generates a random move for the computer.
     * 
     * @param random Random instance to use.
     * @return A randomly selected move: "Rock", "Paper", or "Scissors".
     */
    public static String generateComputerMove(Random random) {
        int index = random.nextInt(VALID_MOVES.length);
        return VALID_MOVES[index];
    }

    /**
     * Runs a multi-round simulation and prints the summary report.
     * 
     * @param playerMoves Predefined player moves for demonstration.
     * @param computerMoves Predefined computer moves for demonstration.
     */
    public static void runGameSimulation(String[] playerMoves, String[] computerMoves) {
        int totalRounds = playerMoves.length;
        int winCount = 0;
        int lossCount = 0;
        int drawCount = 0;

        String[] results = new String[totalRounds];

        for (int i = 0; i < totalRounds; i++) {
            String pMove = playerMoves[i];
            String cMove = computerMoves[i];
            String result = playRound(pMove, cMove);
            results[i] = result;

            if (result.equals("Player Wins")) {
                winCount++;
            } else if (result.equals("Computer Wins")) {
                lossCount++;
            } else {
                drawCount++;
            }

            System.out.println("Round " + (i + 1) + " — Player: " + pMove + ", Computer: " + cMove + " -> " + result);
        }

        double winPercentage = ((double) winCount / totalRounds) * 100.0;

        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                winCount, lossCount, drawCount, winPercentage);
    }

    public static void main(String[] args) {
        try {
            System.out.println("=== Rock-Paper-Scissors Demo ===");
            // Predefined test case matching sample input
            String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
            String[] computerMoves = {"Scissors", "Paper", "Rock", "Scissors", "Scissors"};

            runGameSimulation(playerMoves, computerMoves);
        } catch (Exception e) {
            System.err.println("Error running game simulation: " + e.getMessage());
        }
    }
}
