package string.class_problems;

/**
 * Program: Masked Phone Number Formatter
 * Day 2 Live-Coding Session — Problem 4
 * Concepts: String length/digit validation, substring(), StringBuilder insert(), masking patterns.
 */
public class MaskedPhoneNumberFormatter {

    /**
     * Validates a 10-digit numeric phone number and masks all but the last 4 digits.
     * 
     * @param phone The raw phone number string.
     * @return Masked phone number (e.g., "XXXXXX-3210") or "Invalid phone number".
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null) {
            return "Invalid phone number";
        }

        String trimmedPhone = phone.trim();

        // Must be exactly 10 characters
        if (trimmedPhone.length() != 10) {
            return "Invalid phone number";
        }

        // Must consist only of numeric digits
        for (int i = 0; i < trimmedPhone.length(); i++) {
            if (!Character.isDigit(trimmedPhone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = trimmedPhone.substring(6);

        StringBuilder maskedBuilder = new StringBuilder();
        maskedBuilder.append("XXXXXX");
        maskedBuilder.append("-");
        maskedBuilder.append(lastFourDigits);

        return maskedBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Masked Phone Number Formatter Demo ===");

        String phone1 = "9876543210";
        System.out.println("\"" + phone1 + "\" -> " + maskPhoneNumber(phone1));

        String phone2 = "98765";
        System.out.println("\"" + phone2 + "\" -> " + maskPhoneNumber(phone2));
    }
}
