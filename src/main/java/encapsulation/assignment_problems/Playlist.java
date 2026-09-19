package encapsulation.assignment_problems;

import java.util.Arrays;

/**
 * Week 7 — S7: Encapsulation & Access Control — Assignment Problem 2
 * Program: The Playlist
 * Concepts: Defensive copying of arrays, protecting internal data structures, encapsulation.
 */
public class Playlist {

    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            return;
        }
        if (count < songs.length) {
            songs[count++] = song;
        } else {
            System.out.println("Warning: Playlist capacity reached (" + songs.length + ").");
        }
    }

    // Defensive copy: returns a brand-new array copy containing only added songs
    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.count);
    }

    public int getSongCount() {
        return this.count;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Playlist ===");
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Original playlist songs: " + Arrays.toString(p.getSongs()));

        copy[0] = "Hacked"; // Mutate external copy
        System.out.println("After mutating copy[0] to \"Hacked\":");
        System.out.println("copy[0] = \"" + copy[0] + "\"");
        System.out.println("p.getSongs()[0] is still: \"" + p.getSongs()[0] + "\" (Defensive copy verified!)");
        System.out.println("p.getSongCount() -> " + p.getSongCount());
    }
}
