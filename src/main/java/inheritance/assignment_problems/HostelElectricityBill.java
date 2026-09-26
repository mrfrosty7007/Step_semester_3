package inheritance.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Assignment Problem 3
 * Program: The Hostel Electricity Bill
 * Concepts: Encapsulating subclass-specific state (occupants), polymorphic bill calculation, uniform collection iteration.
 */
public class HostelElectricityBill {

    // Common abstract base class for all hostel rooms
    public static abstract class Room {
        protected final String roomType;
        protected final int units;

        public Room(String roomType, int units) {
            this.roomType = roomType;
            this.units = units;
        }

        public String getRoomType() {
            return roomType;
        }

        public int getUnits() {
            return units;
        }

        // Overridden by derived room types with specific billing models
        public abstract double calculateBill();
    }

    // Concrete Single Room: ₹8 per unit
    public static class SingleRoom extends Room {
        public SingleRoom(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            return units * 8.0;
        }
    }

    // Concrete Shared Room: ₹6 per unit, split equally among occupants
    public static class SharedRoom extends Room {
        private final int occupants;

        public SharedRoom(int units, int occupants) {
            super("SHARED", units);
            if (occupants <= 0) {
                throw new IllegalArgumentException("Occupants count must be positive.");
            }
            this.occupants = occupants;
        }

        public int getOccupants() {
            return occupants;
        }

        @Override
        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    // Concrete AC Room: ₹10 per unit plus ₹200 fixed charge
    public static class AcRoom extends Room {
        public AcRoom(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            return (units * 10.0) + 200.0;
        }
    }

    // Factory method parsing line tokens into Room objects
    public static Room createRoom(String[] tokens) {
        String type = tokens[0].trim().toUpperCase();
        int units = Integer.parseInt(tokens[1]);

        return switch (type) {
            case "SINGLE" -> new SingleRoom(units);
            case "SHARED" -> {
                int occupants = tokens.length > 2 ? Integer.parseInt(tokens[2]) : 2;
                yield new SharedRoom(units, occupants);
            }
            case "AC" -> new AcRoom(units);
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        };
    }

    // Central billing engine iterating polymorphically across all rooms
    public static void processBills(List<Room> rooms) {
        double grandTotal = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", r.getRoomType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Room> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    int units = scanner.nextInt();
                    if (type.equalsIgnoreCase("SHARED")) {
                        int occupants = scanner.nextInt();
                        list.add(new SharedRoom(units, occupants));
                    } else if (type.equalsIgnoreCase("SINGLE")) {
                        list.add(new SingleRoom(units));
                    } else if (type.equalsIgnoreCase("AC")) {
                        list.add(new AcRoom(units));
                    }
                }
                processBills(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 3: The Hostel Electricity Bill ===");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom(120));
        rooms.add(new SharedRoom(150, 3));
        rooms.add(new AcRoom(100));

        processBills(rooms);
    }
}
