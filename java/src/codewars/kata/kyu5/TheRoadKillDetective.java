package codewars.kata.kyu5;

import java.util.*;

public class TheRoadKillDetective {

    /**
     * My name is State Trooper Mark ("skidmark") McDingle.
     * My job is maintaining 117 miles of the Interstate, keeping it clean and clear of dead varmints.
     * It is a serious job and I take my job seriously.
     * I am the Road-Kill Detective
     * <p>
     * Every time I find some dead critter I scrape it up and record what type it was in my dead-critter notebook.
     * Mostly I just cruise up and down the interstate and only find a few racoons or the occasional squirrel...
     * But recently the road-kill has become much more exotic.
     * There must be some illegal private zoo back in the woods with major security problem.
     * But that's none of my business... Anything beyond the fog-line is out of my jurisdiction.
     * <p>
     * Evidence
     * Here are some photos of what I came across last week:
     * There was a thing that looked like a hyena
     * ==========h===yyyyyy===eeee=n==a========
     * <p>
     * a long black and white smudge that probably once was a penguin
     * ======pe====nnnnnn=======================n=n=ng====u==iiii=iii==nn========================n=
     * <p>
     * and an unlucky bear that was hit going the other direction
     * =====r=rrr=rra=====eee======bb====b=======
     * <p>
     * Kata Task
     * <p>
     * Even for a professional like me, the identification of flattened exotic animals is not always easy!
     * If it ever happens that I can't find all of the remains,
     * or if there are gaps or other parts that I don't recognise, then I record it as ?? in my dead-critter notebook.
     * <p>
     * What I really need is a program that I can scan my photos into which can give back the correct answer straight away.
     * <p>
     * Something like this:
     * <p>
     * Input
     * <p>
     * photo (not null)
     * Output
     * <p>
     * the detected animal name, or ?? if unknown^
     * ^ Note: An array/list of all "known" animals is preloaded in a variable called ANIMALS (refer to the initial solution)
     */

    public static void main(String[] args) {

        System.out.println(TheRoadKillDetective.roadKill("=====l==l==a=a==ak==k==c==a=jj========X==="));
    }

    public static String roadKill(final String photo) {

        System.out.println(photo);

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
        public static final String[] ANIMALS = {"aardvark", "alligator", "armadillo",
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
