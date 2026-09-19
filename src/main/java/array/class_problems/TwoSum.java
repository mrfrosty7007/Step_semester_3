package array.class_problems;

import java.util.Arrays;

/**
 * Program: Two Sum
 * Week 4 — S4: Category C Practice Problems — L1
 * Concepts: Nested for loops, array indexing, basic pairwise search logic.
 */
public class TwoSum {

    /**
     * Finds two indices in the array whose values sum up to the target.
     * Uses two nested loops to check every possible pair of positions.
     * 
     * @param nums Array of integer numbers.
     * @param target Target sum value.
     * @return Array containing the two 0-based indices [i, j].
     * @throws IllegalArgumentException if input is null, has fewer than 2 elements, or no pair sums to target.
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution found for the given target.");
    }

    public static void displayTwoSum(int[] nums, int target) {
        try {
            int[] indices = twoSum(nums, target);
            int val1 = nums[indices[0]];
            int val2 = nums[indices[1]];
            System.out.printf("nums = %s, target = %d -> %s (nums[%d] + nums[%d] = %d + %d = %d)\n",
                    Arrays.toString(nums), target, Arrays.toString(indices),
                    indices[0], indices[1], val1, val2, target);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== L1. Two Sum Demo ===");

        // Test Case 1: [2, 7, 11, 15], target = 9
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        displayTwoSum(nums1, target1);

        // Test Case 2: [3, 2, 4], target = 6
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        displayTwoSum(nums2, target2);
    }
}
