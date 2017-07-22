package codewars.katas.kyu7;

/**
 * Developed @ <Academia de Código_>
 * Created by
 * <Code Cadet> Filipe Santos Sá
 */

public class JadenCase {

    /**
     * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
     * Jaden is also known for some of his philosophy that he delivers via Twitter.
     * When writing on Twitter, he is known for almost always capitalizing every word.
     * Your task is to convert strings to how they would be written by Jaden Smith.
     * The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.
     */

    public static void main(String[] args) {
        new JadenCase().toJadenCase("How can mirrors be real if our eyes aren't real");
    }


    private String toJadenCase(String phrase) {

        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        String[] words = phrase.split(" ");

        String result = "";

        for (String s : words) {

            String letter = s.substring(0, 1);

            s = letter.toUpperCase() + s.substring(1);

            result += s + " ";
        }

        result = result.substring(0, result.length() - 1);

        return result;
    }

}
