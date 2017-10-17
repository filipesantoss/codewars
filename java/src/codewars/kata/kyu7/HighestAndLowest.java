package codewars.kata.kyu7;

import java.util.ArrayList;
import java.util.List;

public class HighestAndLowest {

    // https://www.codewars.com/kata/554b4ac871d6813a03000035

    public static String HighAndLow(String numbers) {

        List<Integer> numbersList = new ArrayList<>();

        String[] numberArray = numbers.split(" ");

        for (String s : numberArray) {
            numbersList.add(Integer.parseInt(s));
        }

        int min = numbersList.get(0);
        int max = numbersList.get(0);

        for (Integer i : numbersList) {
            if (i < min) {
                min = i;
            }

            if (i > max) {
                max = i;
            }
        }

        // Code here or
        return String.valueOf(max) + " " + String.valueOf(min);
    }
}
