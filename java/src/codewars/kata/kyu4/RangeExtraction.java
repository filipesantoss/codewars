package codewars.kata.kyu4;

import java.util.Stack;

public class RangeExtraction {

    // http://www.codewars.com/kata/51ba717bb08c1cd60f00002f

    public static String rangeExtraction(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i : arr) {

            if (stack.empty()) {
                stack.push(i);
                continue;
            }

            if (stack.peek() == i - 1) {
                stack.push(i);
                continue;
            }

            sb.append(buildString(stack));
            stack.clear();
            stack.push(i);
        }

        sb.append(buildString(stack));
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static String buildString(Stack<Integer> stack) {
        if (stack.size() >= 3) {
            return stack.get(0) + "-" + stack.peek() + ",";
        }

        StringBuilder s = new StringBuilder();
        for (Integer i : stack) {
            s.append(i).append(",");
        }

        return s.toString();
    }
}
