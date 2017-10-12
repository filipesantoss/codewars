package codewars.kata;

import java.util.Arrays;

public class AlphabetWarsReinforcesMassacre {

    /**
     * Write a function that accepts reinforces array of strings and airstrikes array of strings.
     * The reinforces strings consist of only small letters. The size of each string in reinforces array is the same.
     * The airstrikes strings consists of * and white spaces. The size of each airstrike may vary.
     * There may be also no airstrikes at all.
     * <p>
     * The first row in reinforces array is the current battlefield.
     * Whenever some letter is killed by bomb,
     * it's replaced by a letter from next string in reinforces array on the same position.
     * The airstrike always starts from the beginning of the battlefield.
     * The * means a bomb drop place. The each * bomb kills letter only on the battelfield.
     * The bomb kills letter on the same index on battlefield plus the adjacent letters.
     * The letters on the battlefield are replaced after airstrike is finished.
     * Return string of letters left on the battlefield after the last airstrike.
     * In case there is no any letter left in reinforces on specific position, return _.
     */

    public static void main(String[] args) {

        String[] reinforcements = new String[]{
                "abcdefg",
                "hijklmn"
        };

        String[] airstrikes = new String[]{
                "   *   ",
                "*  *   "
        };

        System.out.println(AlphabetWarsReinforcesMassacre.reinforcesMassacre(reinforcements, airstrikes));
    }

    public static String reinforcesMassacre(String[] reinforces, String[] airstrikes) {
        final String BOMB = "*";

        System.out.println("START: " + Arrays.toString(reinforces));

        for (String strike : airstrikes) {

            for (int i = 0; i < strike.length(); i++) {

                if (Character.toString(strike.charAt(i)).equals(BOMB)) {
                    bomb(reinforces, i);
                    System.out.println("TURN: " + Arrays.toString(reinforces));
                }
            }
        }
        return ""; //Arrays.toString(reinforces);
    }

    private static void bomb(String[] reinforces, int position) {

        for (int i = 0; i < reinforces.length; i++) {
            //TODO shift
        }
    }
}
