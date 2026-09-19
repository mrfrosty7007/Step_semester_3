package string.assignment_problems;

/**
 * Program: Library ISBN Normalizer & Validator
 * Week 2 Assignment — Problem 4
 * Concepts: trim(), substring(), string concatenation, Character.isLetter()/isDigit(), StringBuilder, multi-stage validation.
 */
public class LibraryIsbnValidator {

    /**
     * Normalizes raw input string by trimming spaces and uppercasing the first 3 characters.
     * 
     * @param raw The raw ISBN/code string.
     * @return Normalized string.
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String body = trimmed.substring(3);

        return pubCode + body;
    }

    /**
     * Validates normalized code and produces a formatted display line.
     * 
     * @param code Normalized code to validate.
     * @return Formatted display line or specific error message.
     */
    public static String validateAndFormat(String code) {
        if (code == null) {
            return "Invalid: code cannot be null";
        }

        // Check 1: Length must be exactly 13 characters
        if (code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // Check 2: First 3 characters must be letters (publisher code)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check 3: Remaining 10 characters must be digits (4 year digits + 6 catalog digits)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body (year and catalog number must be digits)";
            }
        }

        // Build formatted display line using StringBuilder
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] ");
        formatted.append("YEAR: ").append(year).append(" | ");
        formatted.append("CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void processIsbn(String rawCode) {
        String normalized = normalizeCode(rawCode);
        String result = validateAndFormat(normalized);
        System.out.printf("\"%s\" -> %s\n", rawCode, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Library ISBN Normalizer & Validator Demo ===");

        processIsbn(" pen2026004251 ");
        processIsbn("12N2026004251");
    }
}
