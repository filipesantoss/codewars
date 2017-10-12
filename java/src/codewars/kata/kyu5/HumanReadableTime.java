package codewars.kata.kyu5;

public class HumanReadableTime {

    /**
     Write a function, which takes a non-negative integer (seconds) as input
     and returns the time in a human-readable format (HH:MM:SS)

     HH = hours, padded to 2 digits, range: 00 - 99
     MM = minutes, padded to 2 digits, range: 00 - 59
     SS = seconds, padded to 2 digits, range: 00 - 59
     The maximum time never exceeds 359999 (99:59:59)

     You can find some examples in the test fixtures.
     */

    public static void main(String[] args) {

        System.out.println(HumanReadableTime.makeReadable(86));

    }

    public static String makeReadable(int seconds) {

        int minutes = seconds / 60;
        seconds -= minutes * 60;

        int hours = minutes / 60;
        minutes -= hours * 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
