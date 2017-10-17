package codewars.kata.kyu6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversedWords {

    // http://www.codewars.com/kata/51c8991dee245d7ddf00000e

    public static String reverseWords(String str) {

        String[] words = str.split(" ");
        List<String> wordsList = Arrays.asList(words);
        Collections.reverse(wordsList);
        return String.join(" ", wordsList);
    }
}
