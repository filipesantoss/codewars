package codewars.kata.kyu7;

public class JadenCasingStrings {

    // https://www.codewars.com/kata/5390bac347d09b7da40006f6

    private String toJadenCase(String phrase) {

        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        String[] words = phrase.split(" ");

        StringBuilder result = new StringBuilder();

        for (String s : words) {

            String letter = s.substring(0, 1);

            s = letter.toUpperCase() + s.substring(1);

            result.append(s).append(" ");
        }

        result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }

}
