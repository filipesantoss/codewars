package codewars.kata.kyu8;

import java.util.Arrays;

public class InvertValues {

    // https://www.codewars.com/kata/5899dc03bc95b1bf1b0000ad

    public static int[] invert(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }

        return array;
    }
}
