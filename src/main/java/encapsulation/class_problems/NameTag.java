package encapsulation.class_problems;

/**
 * Week 7 — S7: Encapsulation & Access Control — Practice Problem 3
 * Program: The Nickname Tag
 * Concepts: Immutable class design, final instance fields, string parsing inside constructor.
 */
public final class NameTag {

    private final String firstName;
    private final String lastNameInitial;

    public NameTag(String fullName) {
        if (fullName == null || !fullName.contains(" ")) {
            throw new IllegalArgumentException("Full name must contain first and last name separated by a space.");
        }
        String[] parts = fullName.trim().split("\\s+");
        this.firstName = parts[0];
        this.lastNameInitial = parts[1].substring(0, 1) + ".";
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Nickname Tag ===");
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> \"" + tag.getNickname() + "\"");
    }
}
