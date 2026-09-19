package string.assignment_problems;

/**
 * Program: ATM PIN Length Validator
 * Week 2 Assignment — Problem 1
 * Concepts: length(), if / else, comparison operators.
 */
public class AtmPinLengthValidator {

    /**
     * Checks if the entered PIN has an exact length of 4 characters.
     * 
     * @param pin The PIN string entered by the user.
     */
    public static void checkPinLength(String pin) {
        if (pin == null) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
            return;
        }

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM PIN Length Validator Demo ===");

        String pin1 = "482";
        System.out.print("\"" + pin1 + "\" -> ");
        checkPinLength(pin1);

        String pin2 = "4820";
        System.out.print("\"" + pin2 + "\" -> ");
        checkPinLength(pin2);
    }
}
