package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible1162 {
    public int maxDistance(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited =
                new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (queue.size() == grid.length * grid[0].length || queue.isEmpty()) {
            return -1;
        }
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                for (int index = 0; index < 4; index++) {
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    if (inBound(grid, nextX, nextY) &&
                            !visited[nextX][nextY] &&
                            grid[nextX][nextY] == 0) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;

                    }
                }
            }
            ++level;
        }
        return level - 1;
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
