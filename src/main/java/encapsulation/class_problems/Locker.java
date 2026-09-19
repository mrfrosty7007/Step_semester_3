package encapsulation.class_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Practice Problem 4
 * Program: The Locker Code
 * Concepts: Write-only sensitive fields, state validation, authorization check before mutation.
 */
public class Locker {

    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode != null && this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> success");
            return true;
        } else {
            System.out.println("changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> rejected, code is unchanged");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Locker Code ===");
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
