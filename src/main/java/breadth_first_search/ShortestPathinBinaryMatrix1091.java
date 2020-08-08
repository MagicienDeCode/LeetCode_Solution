package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited =
                new boolean[grid.length][grid[0].length];
        if (grid[0][0] == 1) {
            return -1;
        }
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int level = 1;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                if (current[0] == grid.length - 1 &&
                        current[1] == grid[0].length - 1) {
                    return level;
                }
                for (int index = 0; index < 8; index++) {
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
        return -1;
    }

    private final int[] deltaX = {0, 0, -1, 1, 1, 1, -1, -1};
    private final int[] deltaY = {-1, 1, 0, 0, -1, 1, -1, 1};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
