package codewars.kata.kyu6;

import java.util.Arrays;

public class TribonacciSequence {

    // https://www.codewars.com/kata/556deca17c58da83c00002db

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
