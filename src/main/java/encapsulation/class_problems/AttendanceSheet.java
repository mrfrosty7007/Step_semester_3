package encapsulation.class_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Practice Problem 5
 * Program: The Attendance Sheet
 * Concepts: Encapsulated internal collection, duplicate suppression, membership lookup, hidden arrays.
 */
public class AttendanceSheet {

    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        if (maxClassSize <= 0) {
            throw new IllegalArgumentException("Class size must be positive.");
        }
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            return;
        }
        // Avoid duplicate counting
        if (isPresent(studentName)) {
            return;
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount++] = studentName;
        } else {
            System.out.println("Warning: Attendance sheet is full for class size " + presentStudents.length);
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        if (studentName == null) return false;
        for (int i = 0; i < presentCount; i++) {
            if (studentName.equalsIgnoreCase(presentStudents[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Attendance Sheet ===");
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
