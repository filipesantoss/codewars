package codewars.katas.kyu6;

/**
 * Developed @ <Academia de Código_>
 * Created by
 * <Code Cadet> Filipe Santos Sá
 */

public class MultiplesOfThreeAndFive {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * <p>
     * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
     * <p>
     * Note: If the number is a multiple of both 3 and 5, only count it once.
     */
    public int solution(int number) {

        final int LOW = 3;
        final int HIGH = 5;

        int result = 0;

        for (int i = 0; i < number; i++) {

            if (i % LOW == 0 || i % HIGH == 0) {
                result += i;
            }

        }

        return result;
    }
}
