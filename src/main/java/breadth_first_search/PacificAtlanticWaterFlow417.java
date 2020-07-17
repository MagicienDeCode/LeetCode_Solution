package breadth_first_search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow417 {
    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        final List<List<Integer>> result = new LinkedList();
        if (matrix.length == 0) {
            return result;
        }
        final boolean[][] visited1 = new boolean[matrix.length][matrix[0].length];
        final boolean[][] visited2 = new boolean[matrix.length][matrix[0].length];
        final Queue<Pair<Integer, Integer>> queue1 = new LinkedList();
        final Queue<Pair<Integer, Integer>> queue2 = new LinkedList();
        for (int i = 0; i < matrix.length; i++) {
            visited1[i][0] = true;
            queue1.offer(new Pair<>(i, 0));
            visited2[i][matrix[0].length - 1] = true;
            queue2.offer(new Pair<>(i, matrix[0].length - 1));
        }
        for (int j = 0; j < matrix[0].length; j++) {
            visited1[0][j] = true;
            queue1.offer(new Pair<>(0, j));
            visited2[matrix.length - 1][j] = true;
            queue2.offer(new Pair<>(matrix.length - 1, j));
        }
        bfs(queue1, visited1, matrix);
        bfs(queue2, visited2, matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(
            Queue<Pair<Integer, Integer>> queue,
            boolean[][] visited,
            int[][] matrix
    ) {
        while (!queue.isEmpty()) {
            final Pair<Integer, Integer> current = queue.poll();
            final int currentValue = matrix[current.getKey()][current.getValue()];
            for (int index = 0; index < 4; index++) {
                final int nextX = current.getKey() + deltaX[index];
                final int nextY = current.getValue() + deltaY[index];
                if (inBound(matrix, nextX, nextY) &&
                        !visited[nextX][nextY] &&
                        matrix[nextX][nextY] >= currentValue) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Pair<>(nextX, nextY));
                }
            }
        }
    }
}
