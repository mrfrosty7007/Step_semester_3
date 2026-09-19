package string.class_problems;

/**
 * Program: CSV Student Record Parser
 * Day 2 Live-Coding Session — Problem 2
 * Concepts: split(), array length validation, string concatenation, formatted output.
 */
public class CsvStudentRecordParser {

    /**
     * Splits a CSV record line and validates that exactly three fields exist.
     * 
     * @param csvLine A CSV formatted string: "Name,RollNumber,Department".
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        // Validate that exactly 3 non-empty fields exist
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String studentName = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        if (studentName.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", studentName, rollNumber, department);
    }

    public static void main(String[] args) {
        System.out.println("=== CSV Student Record Parser Demo ===");

        String record1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("Input: \"" + record1 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(record1);

        String record2 = "Ananya Verma,CSE";
        System.out.println("\nInput: \"" + record2 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(record2);
    }
}
