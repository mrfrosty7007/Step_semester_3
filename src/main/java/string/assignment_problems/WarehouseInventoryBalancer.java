package string.assignment_problems;

/**
 * Program: The Warehouse Inventory Balancer
 * Week 1 Assignment — Problem 4
 * Concepts: Arrays, loops, sum accumulation, conditional comparison, tracking maximum with index.
 */
public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory across Section A and Section B to check total balance
     * and locate the item with the highest individual quantity.
     * 
     * @param sectionA Array of item quantities in Section A.
     * @param sectionB Array of item quantities in Section B.
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            throw new IllegalArgumentException("Section arrays cannot be null.");
        }

        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("Section A and Section B must have equal number of categories.");
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemNumber = -1; // 1-based index

        // Process Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1;
            }
        }

        // Process Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemNumber);
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Balancer Demo ===");

        try {
            int[] sectionA = {20, 15, 30};
            int[] sectionB = {25, 10, 30};

            System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
            System.out.print("Output: ");
            analyzeInventory(sectionA, sectionB);
        } catch (Exception e) {
            System.err.println("Error analyzing warehouse inventory: " + e.getMessage());
        }
    }
}
