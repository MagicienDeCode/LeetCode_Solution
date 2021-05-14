package depth_first_search;

public class NumberofClosedIslands1254 {
    public int closedIsland(int[][] grid) {
        int count = 0;
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, visited, i, j)) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    /*
    closed islands: all 4 directional neighbor squares of all connected squares 0 should in bound, (in grid).
     */
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        boolean flag = true;
        for (int k = 0; k < 4; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            if (inBound(grid, x, y) && grid[x][y] == 0 && !visited[x][y]) {
                flag = dfs(grid, visited, x, y) && flag;
            }
            if (!inBound(grid, x, y)) {
                flag = false;
            }
        }
        return flag;
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
