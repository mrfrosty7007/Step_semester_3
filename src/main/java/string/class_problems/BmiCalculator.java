package string.class_problems;

/**
 * Program: BMI Calculator for a Team
 * Day 1 Live-Coding Session — Problem 3
 * Concepts: Parallel/2D arrays, arithmetic operations, conditional logic, formatted tabular output.
 */
public class BmiCalculator {

    /**
     * Determines health status category based on BMI value.
     * 
     * @param bmi Computed BMI value.
     * @return Category string: Underweight, Normal, Overweight, or Obese.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Computes BMI and prints a formatted wellness report for a team.
     * 
     * @param heights Array of heights in meters.
     * @param weights Array of weights in kilograms.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null) {
            throw new IllegalArgumentException("Height and weight arrays cannot be null.");
        }
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must have equal length.");
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];

            if (height <= 0 || weight <= 0) {
                System.out.printf("Person %-3d | Invalid measurements (must be > 0)\n", (i + 1));
                continue;
            }

            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s\n",
                    (i + 1), height, weight, bmi, status);
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        try {
            System.out.println("=== Corporate Wellness Program — BMI Report Demo ===");
            // Test sample data matching prompt
            double[] sampleHeights = {1.75, 1.60, 1.80, 1.65, 1.70};
            double[] sampleWeights = {70.0, 90.0, 60.0, 80.0, 52.0};

            printWellnessReport(sampleHeights, sampleWeights);
        } catch (Exception e) {
            System.err.println("Error generating BMI wellness report: " + e.getMessage());
        }
    }
}
