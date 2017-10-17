package codewars.kata;

import java.util.LinkedList;
import java.util.List;

public class JohnAndAnnSignUpForCodewars {

    //TODO not very performative

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