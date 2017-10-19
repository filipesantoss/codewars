package codewars.kata.kyu6;

import codewars.kata.utils.MorseCode;

public class DecodeTheMorseCode {

    // https://www.codewars.com/kata/54b724efac3d5402db00065e

    public static String decode(String morseCode) {

        morseCode = morseCode.trim();
        StringBuilder sb = new StringBuilder();

        for (String w : morseCode.split(" {3}")) {

            for (String l : w.split(" ")) {
                sb.append(MorseCode.get(l));
            }

            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
