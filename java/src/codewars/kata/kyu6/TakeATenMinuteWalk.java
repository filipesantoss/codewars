package codewars.kata.kyu6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TakeATenMinuteWalk {

    // http://www.codewars.com/kata/54da539698b8a2ad76000228

    public static boolean isValid(char[] walk) {

        final int MAXIMUM_DISTANCE = 10;

        if (walk.length != MAXIMUM_DISTANCE) {
            return false;
        }

        int[] INITIAL_POSITION = new int[]{0, 0};
        int[] currentPosition = Arrays.copyOf(INITIAL_POSITION, 2);

        for (char c : walk) {
            currentPosition = move(currentPosition, c);
        }

        // Insert brilliant code here
        return Arrays.equals(INITIAL_POSITION, currentPosition);
    }

    private static int[] move(int[] p, final char c) {

        if (c == 'n') {
            p[1]++;
        }

        if (c == 's') {
            p[1]--;
        }

        if (c == 'w') {
            p[0]--;
        }

        if (c == 'e') {
            p[0]++;
        }

        return p;
    }
}