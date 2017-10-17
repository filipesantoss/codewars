package codewars.kata.kyu5;

import java.util.*;

public class TheRoadKillDetective {

    // https://www.codewars.com/kata/58e18c5434a3022d270000f2

    public static String roadKill(final String photo) {

        if (photo.matches("[^a-zA-Z]") || photo.contains(" ") || photo.isEmpty()) {
            return "??";
        }

        String animal = photo.replaceAll("[^a-zA-Z]", "");

        for (String s : Preloaded.ANIMALS) {
            if (compare(animal, s)) {
                return s;
            }
        }

        return "??";
    }

    private static boolean compare(String a, String s) {

        Set<String> aSet = new LinkedHashSet<>();
        Set<String> sSet = new LinkedHashSet<>();
        Collections.addAll(aSet, a.split(""));
        Collections.addAll(sSet, s.split(""));

        if (aSet.size() != sSet.size()) {
            return false;
        }

        String[] temp = new String[0];

        if (!sameOrder(aSet.toArray(temp), sSet.toArray(temp))
                && !reversedOrder(a, sSet.toArray(temp))) {

            return false;
        }

        for (String l : aSet) {

            if (!s.contains(l)) {
                return false;
            }

            if (countLetters(l, a) < countLetters(l, s)) {
                return false;
            }
        }

        return aSet.equals(sSet);
    }

    private static boolean reversedOrder(String a, String[] s) {

        String[] aSplit = a.split("");
        Collections.reverse(Arrays.asList(aSplit));
        Set<String> letters = new LinkedHashSet<>();
        Collections.addAll(letters, aSplit);

        String[] temp = new String[0];

        return sameOrder(letters.toArray(temp), s);
    }

    private static boolean sameOrder(String[] a, String[] s) {

        for (int i = 0; i < a.length; i++) {

            if (!a[i].equals(s[i])) {
                return false;
            }
        }

        return true;
    }


    private static int countLetters(String letter, String word) {
        int sizeWithoutLetter = word.replaceAll(letter, "").length();
        return word.length() - sizeWithoutLetter;
    }

    private static class Preloaded {
        static final String[] ANIMALS = {"aardvark", "alligator", "armadillo",
                "antelope", "baboon", "bear", "bobcat", "butterfly", "cat", "camel", "cow",
                "chameleon", "dog", "dolphin", "duck", "dragonfly", "eagle", "elephant", "emu",
                "echidna", "fish", "frog", "flamingo", "fox", "goat", "giraffe", "gibbon", "gecko",
                "hyena", "hippopotamus", "horse", "hamster", "insect", "impala", "iguana", "ibis",
                "jackal", "jaguar", "jellyfish", "kangaroo", "kiwi", "koala", "killerwhale", "lemur",
                "leopard", "llama", "lion", "monkey", "mouse", "moose", "meercat", "numbat", "newt",
                "ostrich", "otter", "octopus", "orangutan", "penguin", "panther", "parrot", "pig", "quail",
                "quokka", "quoll", "rat", "rhinoceros", "racoon", "reindeer", "rabbit", "snake", "squirrel",
                "sheep", "seal", "turtle", "tiger", "turkey", "tapir", "unicorn", "vampirebat", "vulture",
                "wombat", "walrus", "wildebeast", "wallaby", "yak", "zebra" };
    }
}
