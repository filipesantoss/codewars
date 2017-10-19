package codewars.kata.kyu6;

import java.util.Set;
import java.util.TreeSet;

public class WichAreIn {

    // https://www.codewars.com/kata/550554fd08b86f84fe000a58

    public static String[] inArray(String[] array1, String[] array2) {

        Set<String> set = new TreeSet<>();

        for (String o : array2) {

            for (String i : array1) {

                if (o.contains(i)) {
                    set.add(i);
                }
            }
        }

        return set.toArray(new String[]{});
    }
}