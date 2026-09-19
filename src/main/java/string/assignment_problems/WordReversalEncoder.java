package string.assignment_problems;

/**
 * Program: Word Reversal Encoder
 * Week 2 Assignment — Problem 2
 * Concepts: split(), StringBuilder / reverse(), loops, string joining.
 */
public class WordReversalEncoder {

    /**
     * Reverses each word individually within a sentence while preserving word order.
     * 
     * @param sentence A sentence string with words separated by spaces.
     * @return Transformed string with each word reversed.
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Sentence cannot be null.");
        }

        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Reverse current word using a loop and StringBuilder
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            resultBuilder.append(reversedWord);

            // Append space between words if not the last word
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Word Reversal Encoder Demo ===");

        try {
            String inputSentence = "hello club";
            String reversed = reverseEachWord(inputSentence);
            System.out.printf("\"%s\" -> %s\n", inputSentence, reversed);
        } catch (Exception e) {
            System.err.println("Error reversing sentence: " + e.getMessage());
        }
    }
}
