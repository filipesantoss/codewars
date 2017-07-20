package codewars.katas.kyu7;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed @ <Academia de Código_>
 * Created by
 * <Code Cadet> Filipe Santos Sá
 */

public class HighestAndLowest {

    /**
     * In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
     * <p>
     * Example:
     * <p>
     * HighAndLow("1 2 3 4 5") // return "5 1"
     * HighAndLow("1 2 -3 4 5") // return "5 -3"
     * HighAndLow("1 9 3 4 -5") // return "9 -5"
     * Notes:
     * <p>
     * All numbers are valid Int32, no need to validate them.
     * There will always be at least one number in the input string.
     * Output string must be two numbers separated by a single space, and highest number is first.
     */

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
