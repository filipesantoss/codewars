package codewars.kata.kyu4;

import codewars.kata.kyu6.DecodeTheMorseCode;

public class DecodeTheMorseCodeAdvanced {

    // https://www.codewars.com/kata/54b72c16cd7f5154e9000457

    private static final String DOT = ".";
    private static final String DASH = "-";
    private static final int INSIDE_CHARACTER_PAUSE = 1;
    private static final int INSIDE_WORD_PAUSE = 3;
    private static final int BETWEEN_WORD_PAUSE = 7;
    private static final String OFF = "0";
    private static final String ON = "1";

    public static String decodeBits(String bits) {

        bits = bits.substring(bits.indexOf(ON), bits.lastIndexOf(ON) + 1);
        System.out.println(bits);

        int length = getLength(bits);
        System.out.println("LEN " + length);

        StringBuilder text = new StringBuilder();

        for (String w : bits.split(OFF + "{" + BETWEEN_WORD_PAUSE * length + "}")) {
            text.append(getWord(w, length));
            text.append("   ");
        }
        return text.toString();
    }

    private static int getLength(String bits) {

        if (!bits.contains(OFF)) {
            return bits.length();
        }

        String off = bits.replaceAll(ON + "+", " ");
        String on = bits.replaceAll(OFF + "+", " ");

        int longest = 0;

        for (String o : off.split(" ")) {
            if (longest == 0) {
                longest = o.length();
            }

            if (o.length() > longest) {
                longest = o.length();
            }
        }

        if (longest > BETWEEN_WORD_PAUSE && longest % BETWEEN_WORD_PAUSE == 0) {
            longest /= BETWEEN_WORD_PAUSE;
        }

        if (longest > INSIDE_WORD_PAUSE && longest % INSIDE_WORD_PAUSE == 0) {
            longest /= INSIDE_WORD_PAUSE;
        }

        for (String s : on.split(" ")) {
            if (s.length() < longest) {
                longest = s.length();
            }
        }

        return longest;
    }

    private static String getWord(String codedWord, int length) {

        StringBuilder word = new StringBuilder();

        for (String c : codedWord.split(OFF + "{" + INSIDE_WORD_PAUSE * length + "}")) {
            word.append(getCharacter(c, length));
            word.append(" ");
        }

        return word.toString().trim();
    }

    private static String getCharacter(String codedCharacter, int length) {
        StringBuilder character = new StringBuilder();

        for (String p : codedCharacter.split(OFF + "{" + INSIDE_CHARACTER_PAUSE * length + "}")) {
            String toAppend = p.length() <= DOT.length() * length ? DOT : DASH;
            character.append(toAppend);
        }

        return character.toString();
    }

    public static String decodeMorse(String morseCode) {
        return DecodeTheMorseCode.decode(morseCode);
    }
}
