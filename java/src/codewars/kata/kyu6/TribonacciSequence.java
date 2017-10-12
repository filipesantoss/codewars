package codewars.kata.kyu6;

import java.util.Arrays;

public class TribonacciSequence {

    /**
     * Well met with Fibonacci bigger brother, AKA Tribonacci.
     * <p>
     * As the name may already reveal, it works basically like a Fibonacci,
     * but summing the last 3 (instead of 2) numbers of the sequence to generate the next. And, worse part of it, regrettably I won't get to hear non-native Italian speakers trying to pronounce it :(
     * <p>
     * So, if we are to start our Tribonacci sequence with [1,1,1] as a starting input (AKA signature), we have this sequence:
     * <p>
     * {1,1,1,3,5,9,17,31,...}
     * But what if we started with [0,0,1] as a signature?
     * As starting with [0,1] instead of [1,1] basically shifts the common Fibonacci sequence by once place,
     * you may be tempted to think that we would get the same sequence shifted by 2 places,
     * but that is not the case and we would get:
     * <p>
     * {0,0,1,1,2,4,7,13,24,...}
     */

    public static void main(String[] args) {

        double[] result = new TribonacciSequence().tribonacci(new double[]{1, 1, 1}, 10);
        System.out.println(Arrays.toString(result));

    }

    public double[] tribonacci(double[] s, int n) {

        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = i < s.length ? s[i] : sumLastThree(result, i);
        }

        return result;
    }

    private double sumLastThree(double[] array, int position) {
        return array[position - 3] + array[position - 2] + array[position - 1];
    }
}
