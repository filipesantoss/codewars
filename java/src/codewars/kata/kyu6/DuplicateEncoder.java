package codewars.kata.kyu6;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {

    // https://www.codewars.com/kata/54b42f9314d9229fd6000d9c

    static String encode(String word) {

        Map<String, Integer> map = new HashMap<>();
        map = count(word, map);
        return encodeWord(word, map);
    }

    private static String encodeWord(String word, Map<String, Integer> map) {

        final String UNIQUE = "(";
        final String REPEATED = ")";

        StringBuilder sb = new StringBuilder();

        for (String c : word.split("")) {

            if (map.get(c.toLowerCase()) == 1) {
                sb.append(UNIQUE);
                continue;
            }

            sb.append(REPEATED);
        }

        return sb.toString();
    }

    private static Map<String, Integer> count(String word, Map<String, Integer> map) {

        for (String c : word.split("")) {
            c = c.toLowerCase();

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }

            map.put(c, 1);
        }

        return map;
    }
}
