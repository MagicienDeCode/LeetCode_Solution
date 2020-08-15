package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovestoReachTargetwithRotations1210 {
    private static final int VERTICAL = 0;
    private static final int HORIZONTAL = 1;

    public int minimumMoves(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][][] visited =
                new boolean[grid.length][grid[0].length][2];
        queue.offer(new int[]{0, 1, HORIZONTAL});
        visited[0][1][HORIZONTAL] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                if (current[0] == grid.length - 1 &&
                        current[1] == grid[0].length - 1 &&
                        current[2] == HORIZONTAL
                ) {
                    return level;
                }
                if (current[2] == HORIZONTAL) {
                    // go horizon next
                    final int nextX = current[0];
                    final int nextY = current[1] + 1;
                    if (inBound(grid, nextX, nextY) &&
                            !visited[nextX][nextY][HORIZONTAL] &&
                            grid[nextX][nextY] == 0
                    ) {
                        queue.offer(new int[]{nextX, nextY, HORIZONTAL});
                        visited[nextX][nextY][HORIZONTAL] = true;
                    }
                    // go VERTICAL next
                    final int nextX2 = current[0] + 1;
                    final int nextY2 = current[1];
                    if (inBound(grid, nextX2, nextY2) &&
                            !visited[nextX2][nextY2][HORIZONTAL] &&
                            grid[nextX2][nextY2 - 1] == 0 &&
                            grid[nextX2][nextY2] == 0
                    ) {
                        queue.offer(new int[]{nextX2, nextY2, HORIZONTAL});
                        visited[nextX2][nextY2][HORIZONTAL] = true;
                    }
                    // rotate clockwise
                    final int nextX3 = current[0] + 1;
                    final int nextY3 = current[1] - 1;
                    if (inBound(grid, nextX3, nextY3) &&
                            !visited[nextX3][nextY3][VERTICAL] &&
                            grid[nextX3][nextY3 + 1] == 0 &&
                            grid[nextX3][nextY3] == 0
                    ) {
                        queue.offer(new int[]{nextX3, nextY3, VERTICAL});
                        visited[nextX3][nextY3][VERTICAL] = true;
                    }
                } else {
                    // go horizon next
                    final int nextX = current[0];
                    final int nextY = current[1] + 1;
                    if (inBound(grid, nextX, nextY) &&
                            !visited[nextX][nextY][VERTICAL] &&
                            grid[nextX - 1][nextY] == 0 &&
                            grid[nextX][nextY] == 0
                    ) {
                        queue.offer(new int[]{nextX, nextY, VERTICAL});
                        visited[nextX][nextY][VERTICAL] = true;
                    }
                    // go VERTICAL next
                    final int nextX2 = current[0] + 1;
                    final int nextY2 = current[1];
                    if (inBound(grid, nextX2, nextY2) &&
                            !visited[nextX2][nextY2][VERTICAL] &&
                            grid[nextX2][nextY2] == 0
                    ) {
                        queue.offer(new int[]{nextX2, nextY2, VERTICAL});
                        visited[nextX2][nextY2][VERTICAL] = true;
                    }
                    // rotate counterclockwise
                    final int nextX3 = current[0] - 1;
                    final int nextY3 = current[1] + 1;
                    if (inBound(grid, nextX3, nextY3) &&
                            !visited[nextX3][nextY3][HORIZONTAL] &&
                            grid[nextX3 + 1][nextY3] == 0 &&
                            grid[nextX3][nextY3] == 0
                    ) {
                        queue.offer(new int[]{nextX3, nextY3, HORIZONTAL});
                        visited[nextX3][nextY3][HORIZONTAL] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
