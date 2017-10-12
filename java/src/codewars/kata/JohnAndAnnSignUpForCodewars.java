package codewars.kata;

import java.util.LinkedList;
import java.util.List;

public class JohnAndAnnSignUpForCodewars {

    /**
     * John and his wife Ann have decided to go to Codewars.
     * <p>
     * On day 0 Ann will do one kata and John - he wants to know how it is working - 0.
     * <p>
     * Let us call a(n) the number of katas done by Ann at day n we have a(0) = 1 and in the same manner j(0) = 0.
     * <p>
     * They have chosen the following rules:
     * <p>
     * On day n the number of katas done by Ann should be n minus the number of katas done by John at day t,
     * t being equal to the number of katas done by Ann herself at day n - 1.
     * <p>
     * On day n the number of katas done by John should be n minus the number of katas done by Ann at day t,
     * t being equal to the number of katas done by John himself at day n - 1.
     * <p>
     * Whoops! I think they need to lay out a little clearer exactly what there're getting themselves into!
     * <p>
     * Could you write:
     * <p>
     * 1) two functions ann and john (parameter n) giving the list of the numbers of katas Ann and John should take on each day from day 0 to day n - 1
     * 2) The total number of katas taken by ann (function sum_ann(n)) and john (function sum_john(n)) from day 0 (inclusive) to day n (exclusive)?
     */

    //TODO needs to be more efficient

    public static void main(String[] args) {


        long start = System.nanoTime();
        System.out.println(JohnAndAnnSignUpForCodewars.john(11));
        System.out.println(JohnAndAnnSignUpForCodewars.ann(6));
        System.out.println(JohnAndAnnSignUpForCodewars.sumJohn(75));

        System.out.println(JohnAndAnnSignUpForCodewars.testJohn(75));

        System.out.println(JohnAndAnnSignUpForCodewars.sumAnn(150));
        long finish = System.nanoTime();
        System.out.println((finish - start) / Math.pow(1, -9));
    }

    private static List<Long> johnList = new LinkedList<>();
    private static List<Long> annList = new LinkedList<>();

    public static List<Long> john(long n) {

        if (johnList.isEmpty()) {
            johnList.add(johnInDay(0));
        }

        if (n <= johnList.size()) {
            return johnList.subList(0, Math.toIntExact(n));
        }

        for (int i = johnList.size(); i < n; i++) {
            johnList.add(johnInDay(i));
        }

        return johnList;
    }

    public static List<Long> ann(long n) {

        if (annList.isEmpty()) {
            annList.add(annInDay(0));
        }

        if (n <= annList.size()) {
            return annList.subList(0, Math.toIntExact(n));
        }

        for (int i = annList.size(); i < n; i++) {
            annList.add(annInDay(i));
        }

        return annList;
    }

    public static long sumJohn(long n) {
        long total = 0;

        for (Long l : john(n)) {
            total += l;
        }

        return total;
    }

    public static long sumAnn(long n) {
        long total = 0;

        for (Long l : ann(n)) {
            total += l;
        }

        return total;
    }

    private static long testJohn(long n) {

        int result = 0;
        int previousDayKata = 0;
        for (int day = 0; day < n; day++) {
            previousDayKata = day - (day - previousDayKata);
            result += previousDayKata;
        }
        return result;
    }
    private static long johnInDay(long n) {
        if (n == 0) {
            return 0;
        }

        return n - annInDay(johnInDay(n - 1));
    }

    private static long annInDay(long n) {
        if (n == 0) {
            return 1;
        }

        return n - johnInDay(annInDay(n - 1));
    }
}