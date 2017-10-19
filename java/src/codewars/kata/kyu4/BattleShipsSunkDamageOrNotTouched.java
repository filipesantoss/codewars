package codewars.kata.kyu4;

import java.util.*;

public class BattleShipsSunkDamageOrNotTouched {

    // https://www.codewars.com/kata/58d06bfbc43d20767e000074

    public static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {

        Map<Integer, Integer> ships = getShipsSize(board);
        Map<Integer, Integer> hits = getHits(board, attacks);

        return compare(ships, hits);
    }

    private static Map<String, Double> compare(Map<Integer, Integer> ships, Map<Integer, Integer> hits) {

        final String SUNK = "sunk";
        final String DAMAGED = "damaged";
        final String NOT_TOUCHED = "notTouched";
        final String POINTS = "points";

        Map<String, Double> state = new LinkedHashMap<>();
        state.put(SUNK, 0d);
        state.put(DAMAGED, 0d);
        state.put(NOT_TOUCHED, 0d);
        state.put(POINTS, 0d);

        for (Integer ship : ships.keySet()) {

            if (!hits.containsKey(ship)) {
                state.put(NOT_TOUCHED, state.get(NOT_TOUCHED) + 1d);
                state.put(POINTS, state.get(POINTS) - 1d);
                continue;
            }

            if (ships.get(ship) > hits.get(ship)) {
                state.put(DAMAGED, state.get(DAMAGED) + 1d);
                state.put(POINTS, state.get(POINTS) + 0.5d);
                continue;
            }

            state.put(SUNK, state.get(SUNK) + 1d);
            state.put(POINTS, state.get(POINTS) + 1d);
        }

        return state;
    }

    private static Map<Integer, Integer> getHits(int[][] board, int[][] attacks) {
        Map<Integer, Integer> hits = new HashMap<>();
        Map<Integer, Integer> hit = new HashMap<>();

        for (int[] a : attacks) {

            int x = board.length - a[1];
            int y = a[0] - 1;
            int value = board[x][y];

            if (value == 0) {
                continue;
            }

            if (hit.containsKey(a[0]) && hit.get(a[0]) == a[1]) {
                continue;
            }

            hit.put(a[0], a[1]);

            if (hits.containsKey(value)) {
                hits.put(value, hits.get(value) + 1);
                continue;
            }

            hits.put(value, 1);
        }

        return hits;
    }

    private static Map<Integer, Integer> getShipsSize(int[][] board) {
        Map<Integer, Integer> ships = new HashMap<>();

        for (int[] row : board) {

            for (int value : row) {

                if (value == 0) {
                    continue;
                }

                if (ships.containsKey(value)) {
                    ships.put(value, ships.get(value) + 1);
                    continue;
                }

                ships.put(value, 1);
            }
        }

        return ships;
    }
}
