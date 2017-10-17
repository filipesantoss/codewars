package codewars.kata.kyu7;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TwoToOne {

    // http://www.codewars.com/kata/5656b6906de340bd1b0000ac

    public static String longest (String s1, String s2) {

        Set<String> set = new TreeSet<>();
        Collections.addAll(set, s1.split(""));
        Collections.addAll(set, s2.split(""));

        StringBuilder sb = new StringBuilder();

        for (String s : set) {
            sb.append(s);
        }

        return sb.toString();
    }
}