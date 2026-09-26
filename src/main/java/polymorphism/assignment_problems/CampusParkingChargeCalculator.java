package polymorphism.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Assignment Problem 2
 * Program: The Campus Parking Charge Calculator
 * Concepts: Common base class, specialized charging algorithms, dynamic method dispatch, polymorphic collections.
 */
public class CampusParkingChargeCalculator {

    // Common abstract base class for parked vehicles
    public static abstract class Vehicle {
        protected final String vehicleType;
        protected final int hours;

        public Vehicle(String vehicleType, int hours) {
            this.vehicleType = vehicleType;
            this.hours = hours;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public int getHours() {
            return hours;
        }

        // Each vehicle type defines its own tariff rules
        public abstract double calculateCharge();
    }

    // Concrete Bike class: ₹10 per hour
    public static class Bike extends Vehicle {
        public Bike(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            return 10.0 * hours;
        }
    }

    // Concrete Car class: ₹30 for the first hour, plus ₹20 for each additional hour
    public static class Car extends Vehicle {
        public Car(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + ((hours - 1) * 20.0);
        }
    }

    // Concrete Truck class: ₹50 per hour, with a minimum charge of ₹100
    public static class Truck extends Vehicle {
        public Truck(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            return Math.max(100.0, 50.0 * hours);
        }
    }

    // Factory method to instantiate the appropriate Vehicle subclass
    public static Vehicle createVehicle(String vehicleType, int hours) {
        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null.");
        }
        return switch (vehicleType.trim().toUpperCase()) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        };
    }

    // Central parking system calculating charges without explicit type checking
    public static void processVehicles(List<Vehicle> vehicles) {
        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf(Locale.US, "%s: %.2f%n", v.getVehicleType(), charge);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Vehicle> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    int hours = scanner.nextInt();
                    list.add(createVehicle(type, hours));
                }
                processVehicles(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 2: The Campus Parking Charge Calculator ===");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bike(3));
        vehicles.add(new Car(4));
        vehicles.add(new Truck(1));
        vehicles.add(new Car(1));

        processVehicles(vehicles);
    }
}

