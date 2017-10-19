package codewars.kata.kyu6;

import java.util.Arrays;

public class FoldAnArray {

    // https://www.codewars.com/kata/57ea70aa5500adfe8a000110

    public static int[] foldArray(int[] array, int runs) {

        int middle;
        int length = array.length;
        int[] numbers = Arrays.copyOf(array, length);

        for (int i = 0; i < runs; i++) {

            middle = length % 2 == 0 ? (numbers.length / 2) : (numbers.length / 2) + 1;

            for (int j = 0; j < middle; j++) {

                if (j == length - j - 1) {
                    break;
                }
                numbers[j] += numbers[length - j - 1];

            }

            length = middle;
            numbers = Arrays.copyOf(numbers, middle);
        }

        return numbers;
    }
}
