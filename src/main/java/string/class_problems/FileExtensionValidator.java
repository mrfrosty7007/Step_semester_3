package string.class_problems;

/**
 * Program: File Extension Validator
 * Day 2 Live-Coding Session — Problem 3
 * Concepts: lastIndexOf(), substring(), equalsIgnoreCase(), conditional logic.
 */
public class FileExtensionValidator {

    // Allowed extensions
    private static final String[] ALLOWED_EXTENSIONS = {"pdf", "docx", "zip"};

    /**
     * Validates whether a given filename has an acceptable extension.
     * 
     * @param filename Name of the file being evaluated.
     * @return "Accepted" if the extension is allowed, otherwise "Rejected — invalid file type".
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        // Check that a dot exists and is not the last character
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        for (String allowed : ALLOWED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(allowed)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("=== File Extension Validator Demo ===");

        String file1 = "Assignment1.PDF";
        System.out.println("\"" + file1 + "\" -> " + validateFileExtension(file1));

        String file2 = "notes.txt";
        System.out.println("\"" + file2 + "\" -> " + validateFileExtension(file2));
    }
}
