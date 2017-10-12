package codewars.kata.kyu6;

import java.util.*;

public class CountingDuplicates {
    /**
     * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string.
     * The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
     * <p>
     * Example
     * <p>
     * "abcde" -> 0 # no characters repeats more than once
     * "aabbcde" -> 2 # 'a' and 'b'
     * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (bandB)
     * "indivisibility" -> 1 # 'i' occurs six times
     * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
     * "aA11" -> 2 # 'a' and '1'
     * "ABBA" -> 2 # 'A' and 'B' each occur twice
     */

    public static void main(String[] args) {
        System.out.println(CountingDuplicates.duplicateCount("Indivisibilities"));
    }

    public static int duplicateCount(String text) {

        int count = 0;
        List<String> chars = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            String c = text.substring(i, i + 1);
            chars.add(c.toLowerCase());
        }

        //List to set
        Set<String> set = new HashSet<>(chars);

        for (String s: set) {
            if (Collections.frequency(chars, s) > 1) {
                count++;
            }
        }

        return count;
    }
}
