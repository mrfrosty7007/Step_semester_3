package array.class_problems;

import java.util.Arrays;

/**
 * Program: Rotate Array
 * Week 4 — S4: Category C Practice Problems — L5
 * Concepts: Modulo arithmetic for wraparound indexing, building a new array from calculated positions, array copying.
 */
public class RotateArray {

    /**
     * Rotates an array of integers to the right by k steps.
     * 
     * @param nums Array of integers to rotate.
     * @param k Number of positions to shift to the right.
     * @return The rotated array.
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        // Normalize k to avoid unnecessary full rotations
        k = k % n;
        if (k < 0) {
            k = k + n; // Handle negative rotation counts if supplied
        }

        if (k == 0) {
            return nums.clone();
        }

        int[] rotated = new int[n];

        // Place each element at its calculated rotated position
        for (int i = 0; i < n; i++) {
            int newPosition = (i + k) % n;
            rotated[newPosition] = nums[i];
        }

        // Copy back to original array as well
        System.arraycopy(rotated, 0, nums, 0, n);

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("=== L5. Rotate Array Demo ===");

        // Test Case 1: [1, 2, 3, 4, 5, 6, 7], k = 3
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.printf("nums = %s, k = %d\n", Arrays.toString(nums1), k1);
        int[] result1 = rotateArray(nums1, k1);
        System.out.printf("Output: %s\n\n", Arrays.toString(result1));

        // Test Case 2: [1, 2], k = 3
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.printf("nums = %s, k = %d\n", Arrays.toString(nums2), k2);
        int[] result2 = rotateArray(nums2, k2);
        System.out.printf("Output: %s (k %% length = %d %% %d = %d, a single rotation)\n",
                Arrays.toString(result2), k2, 2, (k2 % 2));
    }
}
