package depth_first_search;

public class MaxAreaofIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int result = 0;
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result = Math.max(result, bfs(i, j, visited, grid));
                }
            }
        }
        return result;
    }

    private int bfs(int i, int j, boolean[][] visited, int[][] grid) {
        visited[i][j] = true;
        int result = 0;
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            final int queueSize = queue.size();
            for (int size = 0; size < queueSize; size++) {
                final int[] coordinate = queue.poll();
                final int x = coordinate[0];
                final int y = coordinate[1];
                result++;
                for (int k = 0; k <= 3; k++) {
                    final int nextX = x + deltaX[k];
                    final int nextY = y + deltaY[k];
                    if (inBound(grid, nextX, nextY) && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return result;
    }

    /*
    private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        visited[i][j] = true;
        int result = 1;
        for (int k = 0; k <= 3; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            if (inBound(grid, x, y) && grid[x][y] == 1 && !visited[x][y]) {
                result += dfs(x, y, visited, grid);
            }
        }
        return result;
    }
     */

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
