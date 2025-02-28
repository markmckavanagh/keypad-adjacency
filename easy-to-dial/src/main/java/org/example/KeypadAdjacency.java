package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Contains functions used in relation to Keypad Adjacency.
 */
public class KeypadAdjacency {

    private static final int[][] KEYPAD = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
    };

    /**
     * Builds a map of all adjacent digits to each digit on the keypad.
     * @return adjacency map
     */
    public static Map<Integer, Set<Integer>> buildAdjacencyMap() {
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();

        // Iterate over each digit in the keypad
        for (int row = 0; row < KEYPAD.length; row++) {
            for (int col = 0; col < KEYPAD[row].length; col++) {
                int digit = KEYPAD[row][col];

                // Skip empty spaces represented by -1
                if (digit == -1) continue;

                Set<Integer> adjacentDigits = getAdjacentDigits(digit, row, col);
                adjacencyMap.put(digit, adjacentDigits);
            }
        }

        return adjacencyMap;
    }

    private static Set<Integer> getAdjacentDigits(int digit, int row, int col) {
        Set<Integer> adjacentDigits = new HashSet<>();

        // Add the digit itself to the set
        adjacentDigits.add(digit);

        // Iterate over all possible neighbors of the digit including diagonals
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                int newRow = row + y;
                int newCol = col + x;

                // Check if the new position is within bounds and not an empty space (-1)
                if (isValidPosition(newRow, newCol) && KEYPAD[newRow][newCol] != -1) {
                    adjacentDigits.add(KEYPAD[newRow][newCol]);
                }
            }
        }
        return adjacentDigits;
    }

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < KEYPAD.length && col >= 0 && col < KEYPAD[0].length;
    }
}
