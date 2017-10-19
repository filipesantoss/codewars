package codewars.kata.kyu5;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Scramblies {

    // https://www.codewars.com/kata/55c04b4cc56a697bb0000048

    public static boolean scramble(String str1, String str2) {

        Map<String, Integer> map1 = histogram(str1);
        Map<String, Integer> map2 = histogram(str2);

        return containsAll(map1, map2);
    }

    private static boolean containsAll(Map<String, Integer> map1, Map<String, Integer> map2) {

        for (String s : map2.keySet()) {

            if (!map1.containsKey(s)) {
                return false;
            }
            if (map1.get(s) < map2.get(s)) {
                return false;
            }
        }

        return true;
    }

    private static Map<String, Integer> histogram(String text) {

        List<String> characters = Arrays.asList(text.split(""));
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String c : characters) {

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }

            map.put(c, 1);
        }

        return map;
    }
}