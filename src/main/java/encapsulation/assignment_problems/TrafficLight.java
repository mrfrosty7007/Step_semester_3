package encapsulation.assignment_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Assignment Problem 4
 * Program: The Traffic Light
 * Concepts: Controlled state transition machine, private mutable state, preventing arbitrary state mutation.
 */
public class TrafficLight {

    private final String lightId;
    private String color;

    public TrafficLight(String lightId) {
        this.lightId = lightId;
        this.color = "RED"; // Starts on RED
    }

    public String next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
                this.color = "RED";
                break;
            default:
                this.color = "RED";
        }
        return this.color;
    }

    public String getColor() {
        return this.color;
    }

    public String getLightId() {
        return this.lightId;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Traffic Light ===");
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
