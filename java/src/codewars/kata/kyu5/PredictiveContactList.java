package codewars.kata.kyu5;

import java.util.*;
import java.util.regex.Pattern;

public class PredictiveContactList {

    // https://www.codewars.com/kata/56d48fe6df521074e0001140

    private static Map<String, String> map;

    private static void init() {
        map = new LinkedHashMap<>();

        map.put("2", "[abc]");
        map.put("3", "[def]");
        map.put("4", "[ghi]");
        map.put("5", "[jkl]");
        map.put("6", "[mno]");
        map.put("7", "[pqrs]");
        map.put("8", "[tuv]");
        map.put("9", "[wxyz]");
    }

    public static List<String> predict(List<String> contacts, String keystrokes) {

        if (keystrokes.isEmpty()) {
            return contacts;
        }

        if (contacts.isEmpty()) {
            return Collections.emptyList();
        }

        if (map == null) {
            init();
        }

        List<String> wanted = new LinkedList<>();
        StringBuilder regex = new StringBuilder("^");

        for (String k : keystrokes.split("")) {
            regex.append(map.get(k));
        }

        for (String c : contacts) {
            if (Pattern.compile(regex.toString()).matcher(c).find()) {
                wanted.add(c);
            }
        }

        return wanted;
    }
}