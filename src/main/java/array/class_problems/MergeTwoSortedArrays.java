package array.class_problems;

import java.util.Arrays;

/**
 * Program: Merge Two Sorted Arrays
 * Week 4 — S4: Category C Practice Problems — L4
 * Concepts: Two-index (two-pointer) array traversal, while loops, comparing and copying elements, handling remaining elements.
 */
public class MergeTwoSortedArrays {

    /**
     * Merges two already-sorted integer arrays into a single combined sorted array.
     * 
     * @param arr1 First sorted array.
     * @param arr2 Second sorted array.
     * @return A new combined array containing all elements in sorted order.
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return new int[0];
        }
        if (arr1 == null) return arr2.clone();
        if (arr2 == null) return arr1.clone();

        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] mergedResult = new int[length1 + length2];

        int ptr1 = 0;
        int ptr2 = 0;
        int resultIndex = 0;

        // Compare elements from both arrays and copy smaller one
        while (ptr1 < length1 && ptr2 < length2) {
            if (arr1[ptr1] <= arr2[ptr2]) {
                mergedResult[resultIndex] = arr1[ptr1];
                ptr1++;
            } else {
                mergedResult[resultIndex] = arr2[ptr2];
                ptr2++;
            }
            resultIndex++;
        }

        // Copy remaining elements from arr1, if any
        while (ptr1 < length1) {
            mergedResult[resultIndex] = arr1[ptr1];
            ptr1++;
            resultIndex++;
        }

        // Copy remaining elements from arr2, if any
        while (ptr2 < length2) {
            mergedResult[resultIndex] = arr2[ptr2];
            ptr2++;
            resultIndex++;
        }

        return mergedResult;
    }

    public static void main(String[] args) {
        System.out.println("=== L4. Merge Two Sorted Arrays Demo ===");

        // Test Case 1: [1, 3, 5] and [2, 4, 6]
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result1 = mergeSortedArrays(arr1, arr2);
        System.out.printf("arr1 = %s, arr2 = %s -> %s\n",
                Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(result1));

        // Test Case 2: [] and [1, 2, 3]
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] result2 = mergeSortedArrays(arr3, arr4);
        System.out.printf("arr1 = %s, arr2 = %s -> %s\n",
                Arrays.toString(arr3), Arrays.toString(arr4), Arrays.toString(result2));
    }
}
