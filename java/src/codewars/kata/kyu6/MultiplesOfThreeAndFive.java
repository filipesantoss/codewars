package codewars.kata.kyu6;

public class MultiplesOfThreeAndFive {

    // https://www.codewars.com/kata/514b92a657cdc65150000006

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
