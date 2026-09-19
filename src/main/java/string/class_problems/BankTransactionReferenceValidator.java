package string.class_problems;

/**
 * Program: Bank Transaction Reference Generator & Validator
 * Day 2 Live-Coding Session — Problem 5
 * Concepts: trim(), substring(), string concatenation, Character.isLetter()/isDigit(), StringBuilder, multi-stage validation.
 */
public class BankTransactionReferenceValidator {

    /**
     * Normalizes a raw transaction reference string by trimming whitespace
     * and uppercasing only the first 3 characters.
     * 
     * @param raw The raw un-normalized reference string.
     * @return Normalized reference string.
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String prefix = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return prefix + remainder;
    }

    /**
     * Validates a normalized reference code and formats it if valid.
     * Checks:
     *  - Exactly 14 characters.
     *  - First 3 characters are letters.
     *  - Remaining 11 characters are digits.
     * 
     * @param reference The reference string to validate and format.
     * @return Formatted reference string or specific invalid reason message.
     */
    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: reference cannot be null";
        }

        // Check 1: Length must be exactly 14
        if (reference.length() != 14) {
            return "Invalid: wrong length (must be exactly 14 characters)";
        }

        // Check 2: First 3 characters must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check 3: Remaining 11 characters must be digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body (date and sequence must be digits)";
            }
        }

        // Valid: Build formatted display line using StringBuilder
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(day).append("/").append(month).append("/").append(year).append(" | ");
        formatted.append("SEQ: ").append(seq);

        return formatted.toString();
    }

    public static void processReference(String rawReference) {
        String normalized = normalizeReference(rawReference);
        String result = validateAndFormat(normalized);
        System.out.printf("\"%s\" -> %s\n", rawReference, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Transaction Reference Validator Demo ===");

        processReference(" hdf03022600042 ");
        processReference("12F03022600042");
    }
}
