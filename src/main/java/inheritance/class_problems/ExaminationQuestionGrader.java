package inheritance.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Practice Problem 4
 * Program: Examination Question Grader
 * Concepts: Abstract Question base, polymorphic grading strategies, string parsing, uniform evaluation.
 */
public class ExaminationQuestionGrader {

    // Common abstract base class for examination questions
    public static abstract class Question {
        protected final String questionType;
        protected final String questionText;
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final int points;

        public Question(String questionType, String questionText, String correctAnswer, String studentAnswer, int points) {
            this.questionType = questionType;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String getQuestionType() {
            return questionType;
        }

        public int getPoints() {
            return points;
        }

        // Each question type overrides with its specific scoring rubric
        public abstract double grade();
    }

    // Concrete Multiple Choice Question (MCQ): Full points if student answer matches exactly
    public static class McqQuestion extends Question {
        public McqQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("MCQ", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            return (studentAnswer != null && studentAnswer.trim().equals(correctAnswer.trim())) ? points : 0.0;
        }
    }

    // Concrete True/False Question (TF): Full points if student answer matches exactly
    public static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("TF", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            return (studentAnswer != null && studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) ? points : 0.0;
        }
    }

    // Concrete Essay Question: Partial credit based on comma-separated keyword matching
    public static class EssayQuestion extends Question {
        public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("ESSAY", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            if (studentAnswer == null || correctAnswer == null || studentAnswer.isEmpty()) {
                return 0.0;
            }

            String lowerStudentAnswer = studentAnswer.toLowerCase();
            String[] keywords = correctAnswer.split(",");
            int matchCount = 0;

            for (String kw : keywords) {
                String cleanKw = kw.trim().toLowerCase();
                if (!cleanKw.isEmpty() && lowerStudentAnswer.contains(cleanKw)) {
                    matchCount++;
                }
            }

            if (matchCount >= 2) {
                return points * 0.75;
            } else if (matchCount == 1) {
                return points * 0.50;
            } else {
                return 0.0;
            }
        }
    }

    // Regex pattern to extract: TYPE "Question" "Correct" "Student" Points
    private static final Pattern LINE_PATTERN = Pattern.compile(
            "^([A-Za-z]+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$"
    );

    public static Question parseQuestion(String line) {
        Matcher m = LINE_PATTERN.matcher(line.trim());
        if (!m.matches()) {
            throw new IllegalArgumentException("Malformed question line: " + line);
        }
        String type = m.group(1).toUpperCase();
        String text = m.group(2);
        String correct = m.group(3);
        String student = m.group(4);
        int points = Integer.parseInt(m.group(5));

        return switch (type) {
            case "MCQ" -> new McqQuestion(text, correct, student, points);
            case "TF" -> new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY" -> new EssayQuestion(text, correct, student, points);
            default -> throw new IllegalArgumentException("Unknown question type: " + type);
        };
    }

    // Central grader processing all question instances polymorphically
    public static void gradeExamination(List<Question> questions) {
        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf(Locale.US, "%s: %.2f%n", q.getQuestionType(), score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", totalScore);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine().trim();
                if (!firstLine.isEmpty()) {
                    int n = Integer.parseInt(firstLine);
                    List<Question> list = new ArrayList<>(n);
                    for (int i = 0; i < n; i++) {
                        String line = scanner.nextLine().trim();
                        list.add(parseQuestion(line));
                    }
                    gradeExamination(list);
                    return;
                }
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 4: Examination Question Grader ===");
        List<Question> questions = new ArrayList<>();
        questions.add(new McqQuestion("What is the capital of France?", "Paris", "Paris", 10));
        questions.add(new TrueFalseQuestion("The Earth is flat?", "False", "True", 5));
        questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
        questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));

        gradeExamination(questions);
    }
}
