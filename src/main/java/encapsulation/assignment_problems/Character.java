package encapsulation.assignment_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Assignment Problem 1
 * Program: The Health Bar
 * Concepts: Value clamping, private mutable state, final maximum boundary, read-only getter.
 */
public class Character {

    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Max health must be greater than 0.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health = Math.max(0, this.health - amount);
        System.out.println("takeDamage(" + amount + ") -> health = " + this.health + (this.health == 0 ? " (floored)" : ""));
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health = Math.min(this.maxHealth, this.health + amount);
        System.out.println("heal(" + amount + ") -> health = " + this.health + (this.health == this.maxHealth ? " (capped)" : ""));
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Health Bar ===");
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}
