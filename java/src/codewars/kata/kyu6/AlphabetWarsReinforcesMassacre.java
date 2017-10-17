package codewars.kata.kyu6;

import java.util.LinkedList;
import java.util.List;

public class AlphabetWarsReinforcesMassacre {

    // https://www.codewars.com/kata/593e2077edf0d3e2d500002d

    private static final String DEAD = "_";

    public static String reinforcesMassacre(String[] reinforces, String[] airstrikes) {
        final String BOMB = "*";

        for (String strike : airstrikes) {

            for (int i = 0; i < strike.length(); i++) {

                if (Character.toString(strike.charAt(i)).equals(BOMB)) {
                    reinforces[0] = throwBomb(reinforces[0], i);
                }
            }

            reinforces = reinforce(reinforces);
        }

        return reinforces[0];
    }

    private static String[] reinforce(String[] reinforces) {

        List<Integer> deadList = new LinkedList<>();

        for (int i = 0; i < reinforces.length - 1; i++) {

            for (int j = 0; j < reinforces[i].length(); j++) {

                if (Character.toString(reinforces[i].charAt(j)).equals(DEAD) || deadList.contains(j)) {

                    reinforces[i] = reinforces[i].substring(0, j) +
                            reinforces[i + 1].charAt(j) +
                            reinforces[i].substring(j + 1);

                    deadList.add(j);
                }
            }
        }

        int last = reinforces.length - 1;
        reinforces[last] = clearLastLine(reinforces[last], deadList);

        return reinforces;
    }

    private static String clearLastLine(String last, List<Integer> dead) {

        for (int i = 0; i < last.length(); i++) {

            if (!dead.contains(i)) {
                continue;
            }

            last = last.substring(0, i) +
                    DEAD + last.substring(i + 1);
        }

        return last;
    }

    private static String throwBomb(String line, int position) {

        if (position == 0) {
            return DEAD + DEAD + line.substring(2);
        }

        if (position == line.length() - 1) {
            return line.substring(0, line.length() - 2) + DEAD + DEAD;
        }

        return line.substring(0, position - 1) + DEAD + DEAD + DEAD + line.substring(position + 2);
    }
}