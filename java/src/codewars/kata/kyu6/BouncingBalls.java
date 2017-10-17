package codewars.kata.kyu6;

public class BouncingBalls {

    // http://www.codewars.com/kata/5544c7a5cb454edb3c000047

    public static int bouncingBall(double h, double bounce, double window) {

        if (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h) {
            return -1;
        }

        int passedByWindow = 0;

        while (h > window) {
            passedByWindow++;
            h *= bounce;
            if (h >= window) {
                passedByWindow++;
            }
        }

        return passedByWindow;
    }
}