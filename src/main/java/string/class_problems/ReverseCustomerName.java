package string.class_problems;

/**
 * Program: Reverse Customer Name
 * Day 1 Live-Coding Session — Problem 5
 * Concepts: String traversal, character array manipulation, string reconstruction.
 */
public class ReverseCustomerName {

    /**
     * Reverses the given customer name while keeping the original unchanged.
     * 
     * @param customerName The original customer name.
     * @return The reversed name string.
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null.");
        }

        char[] originalChars = customerName.toCharArray();
        int length = originalChars.length;
        char[] reversedChars = new char[length];

        for (int i = 0; i < length; i++) {
            reversedChars[i] = originalChars[length - 1 - i];
        }

        return new String(reversedChars);
    }

    /**
     * Helper method to display original and reversed customer names.
     */
    public static void displayCustomerNameReversal(String customerName) {
        try {
            String reversed = reverseCustomerName(customerName);
            System.out.println("Original Name: " + customerName);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.err.println("Error processing customer name: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System Demo ===");
        String sampleName = "Sunil";
        displayCustomerNameReversal(sampleName);
    }
}
