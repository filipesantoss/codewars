package codewars.kata.kyu6;

public class FindTheParityOutlier {

    // https://www.codewars.com/kata/5526fc09a1bbd946250002dc

    static int find(int[] integers) {

        if (isEven(integers)) {
            return findEven(true, integers);
        }
        return findEven(false, integers);
    }

    private static int findEven(boolean even, final int[] integers) {

        for (int i : integers) {

            if (Math.abs(i % 2) == 0 && even) {
                return i;
            }

            if (Math.abs(i % 2) == 1 && !even) {
                return i;
            }

        }

        throw new IndexOutOfBoundsException();
    }

    private static boolean isEven(int[] integers) {

        int even = 0;

        for (int i = 0; i < 3; i++) {

            if (integers[i] % 2 == 0) {
                even++;
            }
        }

        return even < 2;
    }
}
