package codewars.kata.kyu7;

public class MakeAFunctionThatDoesArithmetic {

    /**
     * Given two numbers and an arithmetic operator (the name of it, as a string), return the result of the two numbers having that operator used on them.

     a and b will both be positive integers, and a will always be the first number in the operation, and b always the second.

     The four operators are "add", "subtract", "divide", "multiply".

     A few examples:

     arithmetic(5, 2, "add")      => returns 7
     arithmetic(5, 2, "subtract") => returns 3
     arithmetic(5, 2, "multiply") => returns 10
     arithmetic(5, 2, "divide")   => returns 2.5
     Try to do it without using if statements!
     */

    public static int arithmetic(int a, int b, String operator) {

        int result = 0;

        switch (operator) {
            case "add":
                result = a + b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "divide":
                result = a / b;
                break;
            case "multiply":
                result = a * b;
                break;
        }

        return result;
    }
}
