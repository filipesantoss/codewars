package codewars.kata.kyu6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DecodeTheMorseCode {

    // https://www.codewars.com/kata/54b724efac3d5402db00065e

    public static String decode(String morseCode) {

        morseCode = morseCode.trim();

        String[] words = morseCode.split(" {3}");

        StringBuilder sb = new StringBuilder();

        for (String w : words) {

            for (String l : w.split(" ")) {
                sb.append(MorseCode.get(l));
            }

            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static class MorseCode {
        private static Map<String, String> map;

        static String get(String character) {

            if (map == null) {
                init();
            }

            return map.get(character);
        }

        private static void init() {
            map = new LinkedHashMap<>();

            map.put(".-", "A");
            map.put("-...", "B");
            map.put("-.-.", "C");
            map.put("-..", "D");
            map.put(".", "E");
            map.put("..-.", "F");
            map.put("--.", "G");
            map.put("....", "H");
            map.put("..", "I");
            map.put(".---", "J");
            map.put("-.-", "K");
            map.put(".-..", "L");
            map.put("--", "M");
            map.put("-.", "N");
            map.put("---", "O");
            map.put(".--.", "P");
            map.put("--.-", "Q");
            map.put(".-.", "R");
            map.put("...", "S");
            map.put("-", "T");
            map.put("..-", "U");
            map.put("...-", "V");
            map.put(".--", "W");
            map.put("-..-", "X");
            map.put("-.--", "Y");
            map.put("--..", "Z");
            map.put(".----", "1");
            map.put("..---", "2");
            map.put("...--", "3");
            map.put("....-", "4");
            map.put(".....", "5");
            map.put("-....", "6");
            map.put("--...", "7");
            map.put("---..", "8");
            map.put("----.", "9");
            map.put("-----", "0");
        }
    }
}
