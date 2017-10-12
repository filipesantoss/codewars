package codewars.kata.kyu4;

import java.math.BigInteger;

public class LargeFactorials {

    /**
     * In mathematics, the factorial of integer 'n' is written as 'n!'.
     * It is equal to the product of n and every integer preceding it. For example: 5! = 1 x 2 x 3 x 4 x 5 = 120
     * <p>
     * Your mission is simple: write a function that takes an integer 'n' and returns 'n!'.
     * <p>
     * You are guaranteed an integer argument. For any values outside the positive range, return null, nil or None.
     * In C++, return an empty string.
     * For positive numbers a full length number is expected for example, return 25! = '15511210043330985984000000' as a String!
     * <p>
     * Note: 0! is always equal to 1. Negative values should return null or an empty string(in C++).
     */

    public static void main(String[] args) {
        System.out.println(factorial(25));
    }

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
