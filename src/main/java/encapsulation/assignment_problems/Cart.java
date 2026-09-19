package encapsulation.assignment_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Assignment Problem 5
 * Program: The Shopping Cart
 * Concepts: Encapsulating internal array, computed properties on demand, data hiding.
 */
public class Cart {

    private final String cartId;
    private final int[] itemPrices;
    private int count;

    public Cart(String cartId, int maxItems) {
        if (maxItems <= 0) {
            throw new IllegalArgumentException("Max items must be greater than 0.");
        }
        this.cartId = cartId;
        this.itemPrices = new int[maxItems];
        this.count = 0;
    }

    public void addItem(int price) {
        if (price < 0) {
            System.out.println("Warning: Negative price not allowed.");
            return;
        }
        if (count < itemPrices.length) {
            itemPrices[count++] = price;
        } else {
            System.out.println("Warning: Cart is full (" + itemPrices.length + " items max).");
        }
    }

    // Computed on request: loops over the private array and sums up
    public int getTotal() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += itemPrices[i];
        }
        return sum;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Shopping Cart ===");
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
