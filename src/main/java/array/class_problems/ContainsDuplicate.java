package array.class_problems;

import java.util.Arrays;

/**
 * Program: Contains Duplicate
 * Week 4 — S4: Category C Practice Problems — L3
 * Concepts: Nested loops, pairwise comparison, boolean return logic, early exit.
 */
public class ContainsDuplicate {

    /**
     * Checks if any value appears at least twice in the array using pairwise nested loop comparison.
     * 
     * @param nums Array of integers.
     * @return true if any element is duplicated, false otherwise.
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Duplicate found, early exit
                }
            }
        }

        return false;
    }

    /**
     * Helper method to evaluate and print duplicate status with descriptive details matching sample output.
     */
    public static void displayDuplicateCheck(int[] nums) {
        if (nums == null) {
            System.out.println("Invalid input: nums is null.");
            return;
        }

        int duplicateValue = 0;
        boolean hasDuplicate = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    hasDuplicate = true;
                    duplicateValue = nums[i];
                    break;
                }
            }
            if (hasDuplicate) break;
        }

        System.out.printf("nums = %s -> Output: %b ", Arrays.toString(nums), hasDuplicate);
        if (hasDuplicate) {
            System.out.printf("(the value %d appears at two different positions)\n", duplicateValue);
        } else {
            System.out.println("(every value is distinct)");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== L3. Contains Duplicate Demo ===");

        int[] nums1 = {1, 2, 3, 1};
        displayDuplicateCheck(nums1);

        int[] nums2 = {1, 2, 3, 4};
        displayDuplicateCheck(nums2);
    }
}
