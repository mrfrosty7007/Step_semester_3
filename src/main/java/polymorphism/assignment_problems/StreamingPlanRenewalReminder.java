package polymorphism.assignment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Assignment Problem 5
 * Program: The Streaming Plan Renewal Reminder
 * Concepts: Abstract SubscriptionPlan hierarchy, polymorphic validity periods, calendar math with LocalDate, subscriber encapsulation.
 */
public class StreamingPlanRenewalReminder {

    // Common abstract base class for subscription plans
    public static abstract class SubscriptionPlan {
        protected final String planType;

        public SubscriptionPlan(String planType) {
            this.planType = planType;
        }

        public String getPlanType() {
            return planType;
        }

        // Each subscription plan defines its validity duration in days
        public abstract int getValidityDays();

        // Polymorphic renewal date calculation using java.time.LocalDate
        public LocalDate calculateRenewalDate(LocalDate startDate) {
            return startDate.plusDays(getValidityDays());
        }
    }

    // Concrete Basic Plan: Valid for 30 days
    public static class BasicPlan extends SubscriptionPlan {
        public BasicPlan() {
            super("BASIC");
        }

        @Override
        public int getValidityDays() {
            return 30;
        }
    }

    // Concrete Standard Plan: Valid for 90 days
    public static class StandardPlan extends SubscriptionPlan {
        public StandardPlan() {
            super("STANDARD");
        }

        @Override
        public int getValidityDays() {
            return 90;
        }
    }

    // Concrete Premium Plan: Valid for 365 days
    public static class PremiumPlan extends SubscriptionPlan {
        public PremiumPlan() {
            super("PREMIUM");
        }

        @Override
        public int getValidityDays() {
            return 365;
        }
    }

    // Encapsulated Subscriber associating subscriber info with a polymorphic plan
    public static class Subscriber {
        private final String name;
        private final LocalDate startDate;
        private final SubscriptionPlan plan;

        public Subscriber(String name, LocalDate startDate, SubscriptionPlan plan) {
            this.name = name;
            this.startDate = startDate;
            this.plan = plan;
        }

        public String getName() {
            return name;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public SubscriptionPlan getPlan() {
            return plan;
        }

        // Delegates to plan's polymorphic date computation
        public LocalDate getRenewalDate() {
            return plan.calculateRenewalDate(startDate);
        }
    }

    // Factory method to instantiate the appropriate SubscriptionPlan
    public static SubscriptionPlan createPlan(String planType) {
        if (planType == null) {
            throw new IllegalArgumentException("Plan type cannot be null.");
        }
        return switch (planType.trim().toUpperCase()) {
            case "BASIC" -> new BasicPlan();
            case "STANDARD" -> new StandardPlan();
            case "PREMIUM" -> new PremiumPlan();
            default -> throw new IllegalArgumentException("Unknown plan type: " + planType);
        };
    }

    // Central reminder system processing subscribers without explicit type checking
    public static void displayRenewalReminders(List<Subscriber> subscribers) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Subscriber sub : subscribers) {
            LocalDate renewalDate = sub.getRenewalDate();
            System.out.println(sub.getName() + ": " + renewalDate.format(formatter));
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                List<Subscriber> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String planType = scanner.next();
                    String name = scanner.next();
                    String dateStr = scanner.next();
                    LocalDate startDate = LocalDate.parse(dateStr);
                    list.add(new Subscriber(name, startDate, createPlan(planType)));
                }
                displayRenewalReminders(list);
                return;
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 5: The Streaming Plan Renewal Reminder ===");
        List<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber("Asha", LocalDate.of(2024, 1, 15), new BasicPlan()));
        subscribers.add(new Subscriber("Ravi", LocalDate.of(2024, 2, 1), new StandardPlan()));
        subscribers.add(new Subscriber("Neha", LocalDate.of(2024, 3, 10), new PremiumPlan()));
        subscribers.add(new Subscriber("Kiran", LocalDate.of(2024, 12, 20), new BasicPlan()));

        displayRenewalReminders(subscribers);
    }
}

