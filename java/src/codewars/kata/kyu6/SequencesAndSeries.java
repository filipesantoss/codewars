package codewars.kata.kyu6;

public class SequencesAndSeries {

    /**
     * Have a look at the following numbers.

     n | score
     ---+-------
     1 |  50
     2 |  150
     3 |  300
     4 |  500
     5 |  750

     Can you find a pattern in it?
     If so, then write a function getScore(n) which returns the score for any positive number n:
     */

    public static void main(String[] args) {

        System.out.println(SequencesAndSeries.getScore(13124));

    }

    public static long getScore(long n) {

        final int MAGIC_NUMBER = 50;

        long result = 0;

        for (long i = n; n > 0; n--) {
            result += MAGIC_NUMBER * n;
        }

        return result;
    }
}
