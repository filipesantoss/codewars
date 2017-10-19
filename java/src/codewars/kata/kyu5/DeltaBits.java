package codewars.kata.kyu5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class DeltaBits {

    // http://www.codewars.com/kata/538948d4daea7dc4d200023f

    public static int convertBits(int a, int b) {

        int bitCount = bitsIn(a) > bitsIn(b) ? bitsIn(a) : bitsIn(b);

        int[] aBits = getBits(a, bitCount);
        int[] bBits = getBits(b, bitCount);

        int difference = 0;

        for (int i = 0; i < aBits.length; i++) {
            if (aBits[i] != bBits[i]) {
                difference++;
            }
        }

        return difference;
    }

    private static int bitsIn(int number) {
        return Integer.toBinaryString(number).length();
    }

    private static int[] getBits(int number, int bitCount) {
        Stack<Integer> bits = new Stack<>();

        while (number != 0 || bits.size() < bitCount) {
            if (number != 0) {
                bits.push(number % 2);
                number /= 2;
                continue;
            }
            bits.push(0);
        }

        Collections.reverse(bits);

        //stream() - stream over the elements in collection
        //mapToInt(function) - int stream, applies function to every value
        //value -> value - function to be applied
        //toArray() - array containing elements in the stream
        return bits.stream().mapToInt(value -> value).toArray();
    }
}
