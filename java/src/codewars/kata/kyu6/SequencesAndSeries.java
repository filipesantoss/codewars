package codewars.kata.kyu6;

public class SequencesAndSeries {

    // https://www.codewars.com/kata/5254bd1357d59fbbe90001ec

    public static long getScore(long n) {

        final int MAGIC_NUMBER = 50;

        long result = 0;

        for (long i = n; n > 0; n--) {
            result += MAGIC_NUMBER * n;
        }

        return result;
    }
}
