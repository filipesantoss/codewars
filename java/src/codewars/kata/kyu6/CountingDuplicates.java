package codewars.kata.kyu6;

import java.util.*;

public class CountingDuplicates {

    // https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1

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
