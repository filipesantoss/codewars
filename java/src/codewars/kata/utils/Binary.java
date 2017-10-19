package codewars.kata.utils;

import java.util.Collections;
import java.util.Stack;

public class Binary {

    public static int[] getBits(int number, int bitCount) {
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

    public static long[] getBits(long number, int bitCount) {
        Stack<Long> bits = new Stack<>();

        while (number != 0 || bits.size() < bitCount) {
            if (number != 0) {
                bits.push(number % 2);
                number /= 2;
                continue;
            }
            bits.push(0L);
        }

        Collections.reverse(bits);

        return bits.stream().mapToLong(value -> value).toArray();
    }
}
