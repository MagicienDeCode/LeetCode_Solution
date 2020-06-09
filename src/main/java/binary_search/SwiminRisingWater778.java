package binary_search;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class SwiminRisingWater778 {
    /*
    public int swimInWater(int[][] grid) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        final int[][] visited = new int[grid.length][grid[0].length];
        for (int[] gs : grid) {
            for (int g : gs) {
                left = Math.min(left, g);
                right = Math.max(right, g);
            }
        }
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            for (int[] vs : visited) {
                Arrays.fill(vs, 0);
            }
            dfs(grid, visited, 0, 0, mid);
            if (visited[grid.length - 1][grid[0].length - 1] == 1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private void dfs(int[][] grid, int[][] visited, int x, int y, int target) {
        if (
                inGrid(x, y, grid.length, grid[0].length) &&
                        visited[x][y] == 0 &&
                        grid[x][y] <= target
        ) {
            visited[x][y] = 1;
            dfs(grid, visited, x - 1, y, target);
            dfs(grid, visited, x, y - 1, target);
            dfs(grid, visited, x, y + 1, target);
            dfs(grid, visited, x + 1, y, target);
        }
    }
     */
    private boolean inGrid(
            int x,
            int y,
            int boundX,
            int boundY
    ) {
        return x >= 0 && x < boundX && y >= 0 && y < boundY;
    }

    public int swimInWater(int[][] grid) {
        final int[][] visited = new int[grid.length][grid[0].length];
        final PriorityQueue<Grid> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Grid(grid[0][0], 0, 0));
        visited[0][0] = 1;
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        while (!priorityQueue.isEmpty()) {
            final Grid current = priorityQueue.poll();
            if (current.x == grid.length - 1 &&
                    current.y == grid[0].length - 1) {
                return current.value;
            }
            for (int index = 0; index < 4; index++) {
                final int nextX = current.x + dx[index];
                final int nextY = current.y + dy[index];
                if (inGrid(nextX, nextY, grid.length, grid[0].length) &&
                        visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = 1;
                    priorityQueue.offer(new Grid(
                            Math.max(current.value, grid[nextX][nextY]),
                            nextX,
                            nextY
                    ));
                }
            }
        }
        return 0;
    }

    static class Grid implements Comparable<Grid> {
        public int value;
        public int x;
        public int y;

        public Grid(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull Grid grid) {
            return Integer.compare(value, grid.value);
        }
    }
}
