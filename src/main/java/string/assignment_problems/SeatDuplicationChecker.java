package string.assignment_problems;

/**
 * Program: The Exam Hall Seat Duplication Checker
 * Week 1 Assignment — Problem 1
 * Concepts: Arrays, nested loops, conditional logic, basic output formatting.
 */
public class SeatDuplicationChecker {

    /**
     * Scans the array of seat numbers using nested loops to identify any duplicates.
     * Note: No Collections classes are used — arrays and loops only.
     * 
     * @param seatNumbers Array of seat numbers assigned to students.
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("Invalid input: Seat numbers list is empty.");
            return;
        }

        boolean duplicateFound = false;
        int n = seatNumbers.length;

        // Array to track if an element has already been reported as a duplicate
        boolean[] alreadyReported = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (alreadyReported[i]) {
                continue;
            }

            boolean isCurrentDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isCurrentDuplicate = true;
                    alreadyReported[j] = true; // Mark subsequent occurrences
                }
            }

            if (isCurrentDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exam Hall Seat Duplication Checker Demo ===");

        // Test Case 1: Duplicates present
        int[] seatList1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> Output: ");
        checkDuplicateSeats(seatList1);

        // Test Case 2: No duplicates
        int[] seatList2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> Output: ");
        checkDuplicateSeats(seatList2);
    }
}
