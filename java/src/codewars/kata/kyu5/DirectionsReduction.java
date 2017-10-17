package codewars.kata.kyu5;

import java.util.*;

public class DirectionsReduction {

    // https://www.codewars.com/kata/550f22f4d758534c1100025a

    public static String[] dirReduc(String[] arr) {

        Map<String, String> directions = new HashMap<>();
        directions.put("NORTH", "SOUTH");
        directions.put("SOUTH", "NORTH");
        directions.put("EAST", "WEST");
        directions.put("WEST", "EAST");

        Stack<String> stack = new Stack<>();

        for (String d : arr) {
            if (stack.empty()) {
                stack.push(d);
                continue;
            }

            if (stack.peek().equals(directions.get(d))) {
                stack.pop();
                continue;
            }

            stack.push(d);
        }

        return stack.toArray(new String[]{});
    }
}