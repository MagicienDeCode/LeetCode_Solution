package breadth_first_search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01542 {
    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int[][] updateMatrix(int[][] matrix) {
        final boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        final Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                }
                if (matrix[i][j] == 1) {
                    int count = 0;
                    for (int index = 0; index < 4; index++) {
                        final int nextX = i + deltaX[index];
                        final int nextY = j + deltaY[index];
                        if (inBound(matrix, nextX, nextY) &&
                                matrix[nextX][nextY] == 0) {
                            ++count;
                        }
                    }
                    if (count > 0) {
                        queue.offer(new Pair<>(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
        int level = 1;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final Pair<Integer, Integer> current = queue.poll();
                matrix[current.getKey()][current.getValue()] = level;
                for (int index = 0; index < 4; index++) {
                    final int nextX = current.getKey() + deltaX[index];
                    final int nextY = current.getValue() + deltaY[index];
                    if (inBound(matrix, nextX, nextY) &&
                            !visited[nextX][nextY]) {
                        queue.offer(new Pair<>(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
            ++level;
        }
        return matrix;
    }
}
