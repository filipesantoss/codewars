package codewars.katas.kyu6;

import java.util.Arrays;

/**
 * Developed @ <Academia de Código_>
 * Created by
 * <Code Cadet> Filipe Santos Sá
 */

public class SrotTheInnerCtonnet {

    /**
     * You have to sort the inner content of every word of a string in descending order.
     * The inner content is the content of a word without first and the last char.
     * <p>
     * Some examples:
     * <p>
     * "sort the inner content in descending order" -> "srot the inner ctonnet in dsnnieedcg oredr"
     * "wait for me" -> "wiat for me"
     * "this kata is easy" -> "tihs ktaa is esay"
     * The string will never be null and will never be empty.
     * It will contain only lowercase-letters and whitespaces.
     */

    public static void main(String[] args) {

        System.out.println(SrotTheInnerCtonnet.sortTheInnerContent("wait for me"));
    }

    private static String sortTheInnerContent(String s) {

        if (s.length() <= 3) {
            return s;
        }

        String[] wordsInArgument = s.split(" ");
        String result = "";

        for (String string : wordsInArgument) {

            if (string.length() <= 3) {
                result += string + " ";
                continue;
            }

            char[] word = string.substring(1, string.length() - 1).toCharArray();
            Arrays.sort(word);

            String sort = "";
            for (int i = word.length - 1; i >= 0; i--) {
                sort += word[i];
            }

            sort = string.charAt(0) + sort + string.charAt(string.length() - 1);
            result += sort + " ";
        }

        return result.substring(0, result.length() - 1);
    }
}
