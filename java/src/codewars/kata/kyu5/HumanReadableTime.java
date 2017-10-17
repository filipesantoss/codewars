package codewars.kata.kyu5;

public class HumanReadableTime {

    // https://www.codewars.com/kata/52685f7382004e774f0001f7

    public static String makeReadable(int seconds) {

        int minutes = seconds / 60;
        seconds -= minutes * 60;

        int hours = minutes / 60;
        minutes -= hours * 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
