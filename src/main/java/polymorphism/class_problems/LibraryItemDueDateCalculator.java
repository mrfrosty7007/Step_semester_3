package polymorphism.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Week 8 — S8: Inheritance & Runtime Polymorphism — Practice Problem 2
 * Program: Library Item Due Date Calculator
 * Concepts: Abstract classes, inheritance of state and behavior, method overriding, polymorphic date calculation.
 */
public class LibraryItemDueDateCalculator {

    // Common abstract base class for all library items
    public static abstract class LibraryItem {
        protected final String title;

        public LibraryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        // Specific borrowing period defined by each item type
        public abstract int getBorrowingPeriodDays();

        // Shared concrete method calculating the exact due date
        public LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(getBorrowingPeriodDays());
        }
    }

    // Concrete Book class: Standard borrowing period of 14 days
    public static class BookItem extends LibraryItem {
        public BookItem(String title) {
            super(title);
        }

        @Override
        public int getBorrowingPeriodDays() {
            return 14;
        }
    }

    // Concrete DVD class: Standard borrowing period of 7 days
    public static class DvdItem extends LibraryItem {
        public DvdItem(String title) {
            super(title);
        }

        @Override
        public int getBorrowingPeriodDays() {
            return 7;
        }
    }

    // Concrete Magazine class: Standard borrowing period of 3 days
    public static class MagazineItem extends LibraryItem {
        public MagazineItem(String title) {
            super(title);
        }

        @Override
        public int getBorrowingPeriodDays() {
            return 3;
        }
    }

    // Factory method to create appropriate LibraryItem instance
    public static LibraryItem createLibraryItem(String itemType, String title) {
        if (itemType == null) {
            throw new IllegalArgumentException("Item type cannot be null.");
        }
        return switch (itemType.trim().toUpperCase()) {
            case "BOOK" -> new BookItem(title);
            case "DVD" -> new DvdItem(title);
            case "MAGAZINE" -> new MagazineItem(title);
            default -> throw new IllegalArgumentException("Unknown library item type: " + itemType);
        };
    }

    // Central library service processing due dates without type-checking
    public static void displayDueDates(List<LibraryItem> items, LocalDate currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }
    }

    public static void main(String[] args) {
        LocalDate baseDate = LocalDate.of(2023, 10, 26);

        if (args.length > 0 && args[0].equals("--cli")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine().trim();
                if (!firstLine.isEmpty()) {
                    int n = Integer.parseInt(firstLine);
                    List<LibraryItem> list = new ArrayList<>(n);
                    Pattern pattern = Pattern.compile("^([A-Z]+)\\s+\"?([^\"]+)\"?$");
                    for (int i = 0; i < n; i++) {
                        String line = scanner.nextLine().trim();
                        Matcher m = pattern.matcher(line);
                        if (m.matches()) {
                            list.add(createLibraryItem(m.group(1), m.group(2)));
                        }
                    }
                    displayDueDates(list, baseDate);
                    return;
                }
            }
        }

        // Standard Sample Demo matching expected PDF output
        System.out.println("=== Problem 2: Library Item Due Date Calculator ===");
        List<LibraryItem> items = new ArrayList<>();
        items.add(new BookItem("1984"));
        items.add(new DvdItem("The Matrix"));
        items.add(new MagazineItem("Forbes Issue 500"));

        displayDueDates(items, baseDate);
    }
}

