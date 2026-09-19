package string.assignment_problems;

/**
 * Program: Product Inventory CSV Parser
 * Week 2 Assignment — Problem 3
 * Concepts: split(), array length validation, string concatenation, formatted output.
 */
public class ProductInventoryCsvParser {

    /**
     * Parses and validates a CSV inventory update line.
     * 
     * @param csvLine CSV string in format "ProductName,SKU,Quantity".
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        System.out.println("=== Product Inventory CSV Parser Demo ===");

        String record1 = "Wireless Mouse,WM-2201,150";
        System.out.println("Input: \"" + record1 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(record1);

        String record2 = "Wireless Mouse,150";
        System.out.println("\nInput: \"" + record2 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(record2);
    }
}
