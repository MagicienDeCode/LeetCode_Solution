package depth_first_search;

public class ColoringABorder1034 {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        dfs(grid, r0, c0, new boolean[grid.length][grid[0].length], color);
        return grid;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int color) {
        visited[i][j] = true;
        int flag = 0;
        // 4 directions dfs
        for (int k = 0; k < 4; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            // if in grid && connected squares && not visited
            if (inBound(grid, x, y) && grid[x][y] == grid[i][j] && !visited[x][y]) {
                dfs(grid, x, y, visited, color);
            }
            // if it's surrounded with connected squares
            if (inBound(grid, x, y) && visited[x][y]) {
                ++flag;
            }
        }
        // if it's border
        if (flag != 4) {
            grid[i][j] = color;
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
