package string.assignment_problems;

/**
 * Program: The Movie Review Word Length Profiler
 * Week 1 Assignment — Problem 5
 * Concepts: String splitting (split()), loops, conditional logic, counting/categorization.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits a review into words and classifies them into Short (1-4 letters),
     * Medium (5-8 letters), and Long (9+ letters) categories.
     * 
     * @param review The movie review text.
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Invalid input: Review is empty.");
            return;
        }

        // Split by one or more whitespace characters
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;   // 1–4 letters
        int mediumCount = 0;  // 5–8 letters
        int longCount = 0;    // 9+ letters

        for (String word : words) {
            // Remove common trailing/leading punctuation to get clean word length
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int wordLength = cleanWord.length();

            if (wordLength == 0) {
                continue;
            }

            if (wordLength <= 4) {
                shortCount++;
            } else if (wordLength <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Movie Review Word Length Profiler Demo ===");

        String reviewText = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + reviewText + "\"");
        System.out.print("Output: ");
        classifyWordLengths(reviewText);
    }
}
