package encapsulation.class_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Practice Problem 2
 * Program: The Quiz Scorecard
 * Concepts: Encapsulating internal array state, controlled updates, read-only aggregation.
 */
public class Scorecard {

    private final boolean[] answers;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException("Total questions must be greater than 0.");
        }
        this.answers = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < answers.length) {
            answers[recordedCount++] = isCorrect;
        } else {
            System.out.println("Warning: Cannot record more answers than the fixed total questions (" + answers.length + ").");
        }
    }

    public int getScore() {
        int correctCount = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public int getRecordedCount() {
        return recordedCount;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Quiz Scorecard ===");
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}
