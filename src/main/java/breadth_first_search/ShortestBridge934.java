package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {
    public int shortestBridge(int[][] a) {
        final boolean[][] visited =
                new boolean[a.length][a[0].length];
        final Queue<int[]> queue = new LinkedList<>();

        // dfs
        for (int i = 0; i < a.length; i++) {
            if (!queue.isEmpty()) {
                break;
            }
            for (int j = 0; j < a[0].length; j++) {
                if (!queue.isEmpty()) {
                    break;
                }
                if (a[i][j] == 1) {
                    dfs(a, visited, queue, i, j);
                }
            }
        }

        // bfs find the minimum distance
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                for (int index = 0; index < 4; index++) {
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    if (inBound(a, nextX, nextY) &&
                            !visited[nextX][nextY]) {
                        if (a[nextX][nextY] == 1) {
                            return level;
                        }
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private void dfs(
            int[][] a,
            boolean[][] visited,
            Queue<int[]> queue,
            int i,
            int j
    ) {
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        for (int index = 0; index < 4; index++) {
            final int nextX = i + deltaX[index];
            final int nextY = j + deltaY[index];
            if (inBound(a, nextX, nextY) &&
                    !visited[nextX][nextY] &&
                    a[nextX][nextY] == 1) {
                dfs(a, visited, queue, nextX, nextY);
            }
        }
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
