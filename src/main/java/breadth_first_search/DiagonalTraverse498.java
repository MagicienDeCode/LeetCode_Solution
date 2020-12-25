package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        final int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        final List<Integer> levelResults = new ArrayList<>();
        for (int level = 0; level < matrix.length + matrix[0].length - 1; level++) {
            levelResults.clear();
            // find head
            int row = level < matrix[0].length ? 0 : level - matrix[0].length + 1;
            int col = level < matrix[0].length ? level : matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (level % 2 == 0) {
                    levelResults.add(0, matrix[row++][col--]);
                } else {
                    levelResults.add(matrix[row++][col--]);
                }
            }
            for (int lr : levelResults) {
                result[index++] = lr;
            }
        }
        return result;
    }
    /*
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        final int[] result = new int[matrix.length * matrix[0].length];
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.offer(new int[]{0, 0});
        int level = 0;
        int index = 0;
        final List<Integer> levelResults = new ArrayList<>();
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            levelResults.clear();
            for (int i = 0; i < currentSize; i++) {
                final int[] curr = queue.poll();
                final int x = curr[0];
                final int y = curr[1];
                if (level % 2 == 0) {
                    levelResults.add(0, matrix[x][y]);
                } else {
                    levelResults.add(matrix[x][y]);
                }
                // right first
                final int rX = x;
                final int rY = y + 1;
                if (inBound(matrix, rX, rY) && !visited[rX][rY]) {
                    visited[rX][rY] = true;
                    queue.offer(new int[]{rX, rY});
                }
                // down
                final int dX = x + 1;
                final int dY = y;
                if (inBound(matrix, dX, dY) && !visited[dX][dY]) {
                    visited[dX][dY] = true;
                    queue.offer(new int[]{dX, dY});
                }
            }
            for (int lr : levelResults) {
                result[index++] = lr;
            }
            ++level;
        }
        return result;
    }

    private boolean inBound(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
     */
}
