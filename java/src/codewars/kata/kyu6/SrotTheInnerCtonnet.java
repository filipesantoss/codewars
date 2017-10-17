package codewars.kata.kyu6;

import java.util.Arrays;

public class SrotTheInnerCtonnet {

    // https://www.codewars.com/kata/5898b4b71d298e51b600014b

    private static String sortTheInnerContent(String s) {

        if (s.length() <= 3) {
            return s;
        }

        String[] wordsInArgument = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String string : wordsInArgument) {

            if (string.length() <= 3) {
                result.append(string).append(" ");
                continue;
            }

            char[] word = string.substring(1, string.length() - 1).toCharArray();
            Arrays.sort(word);

            StringBuilder sort = new StringBuilder();
            for (int i = word.length - 1; i >= 0; i--) {
                sort.append(word[i]);
            }

            sort = new StringBuilder(string.charAt(0) + sort.toString() + string.charAt(string.length() - 1));
            result.append(sort).append(" ");
        }

        return result.toString().substring(0, result.length() - 1);
    }
}
