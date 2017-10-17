package codewars.kata.kyu4;

import java.math.BigInteger;

public class LargeFactorials {

    // https://www.codewars.com/kata/557f6437bf8dcdd135000010

    public static String factorial(int n) {

        if (n < 0) {
            return null;
        }

        return calculateFactorial(n).toString();
    }

    private static BigInteger calculateFactorial(int n) {
        if (n == 0) {
            return BigInteger.valueOf(1);
        }

        return BigInteger.valueOf(n).multiply(calculateFactorial(--n));
    }

}
