package inheritance.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Practice Problem 5
 * Program: Public Transport Fare Calculator
 * Concepts: Abstract Transport base, caps and multipliers in derived classes, uniform fare calculation.
 */
public class PublicTransportFareCalculator {

    // Common abstract base class for transport modes
    public static abstract class Transport {
        protected final String transportType;
        protected final double distance;

        public Transport(String transportType, double distance) {
            this.transportType = transportType;
            this.distance = distance;
        }

        public String getTransportType() {
            return transportType;
        }

        public double getDistance() {
            return distance;
        }

        // Each transport mode overrides with its specific fare model
        public abstract double calculateFare();
    }

    // Concrete Bus Transport: Base fare $2 + $0.10/km, capped at maximum $10
    public static class BusTransport extends Transport {
        public BusTransport(double distance) {
            super("BUS", distance);
        }

        @Override
        public double calculateFare() {
            double calculated = 2.0 + (0.10 * distance);
            return Math.min(10.0, calculated);
        }
    }

    // Concrete Train Transport: Base fare $3 + $0.15/km
    public static class TrainTransport extends Transport {
        public TrainTransport(double distance) {
            super("TRAIN", distance);
        }

        @Override
        public double calculateFare() {
            return 3.0 + (0.15 * distance);
        }
    }

    // Concrete Metro Transport: (Base fare $1.50 + $0.20/km) * PeakHourFactor
    public static class MetroTransport extends Transport {
        private final double peakHourFactor;

        public MetroTransport(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        public double getPeakHourFactor() {
            return peakHourFactor;
        }

        @Override
        public double calculateFare() {
            return (1.50 + (0.20 * distance)) * peakHourFactor;
        }
    }

    // Factory method to parse line tokens into Transport instance
    public static Transport createTransport(String[] tokens) {
        String type = tokens[0].trim().toUpperCase();
        double distance = Double.parseDouble(tokens[1]);

        return switch (type) {
            case "BUS" -> new BusTransport(distance);
            case "TRAIN" -> new TrainTransport(distance);
            case "METRO" -> {
                double factor = tokens.length > 2 ? Double.parseDouble(tokens[2]) : 1.0;
                yield new MetroTransport(distance, factor);
            }
            default -> throw new IllegalArgumentException("Unknown transport type: " + type);
        };
    }

    // Central ticketing service calculating fares without explicit type checking
    public static void processJourneys(List<Transport> journeys) {
        double grandTotal = 0.0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotal += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", t.getTransportType(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Transport> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double distance = scanner.nextDouble();
                    if (type.equalsIgnoreCase("METRO")) {
                        double factor = scanner.nextDouble();
                        list.add(new MetroTransport(distance, factor));
                    } else if (type.equalsIgnoreCase("BUS")) {
                        list.add(new BusTransport(distance));
                    } else if (type.equalsIgnoreCase("TRAIN")) {
                        list.add(new TrainTransport(distance));
                    }
                }
                processJourneys(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 5: Public Transport Fare Calculator ===");
        List<Transport> journeys = new ArrayList<>();
        journeys.add(new BusTransport(15));
        journeys.add(new TrainTransport(50));
        journeys.add(new MetroTransport(10, 1.5));

        processJourneys(journeys);
    }
}
