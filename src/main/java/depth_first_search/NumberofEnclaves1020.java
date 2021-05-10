package depth_first_search;

public class NumberofEnclaves1020 {
    public int numEnclaves(int[][] grid) {
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        final int row = 0;
        final int lastRow = grid.length - 1;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] == 1) {
                dfs(grid, row, i, visited);
            }
            if (grid[lastRow][i] == 1) {
                dfs(grid, lastRow, i, visited);
            }
        }
        final int col = 0;
        final int lastCol = grid[0].length - 1;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                dfs(grid, i, col, visited);
            }
            if (grid[i][lastCol] == 1) {
                dfs(grid, i, lastCol, visited);
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count += dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int count = 1;
        for (int k = 0; k < 4; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            if (inBound(grid, x, y) && grid[x][y] == 1 && !visited[x][y]) {
                count += dfs(grid, x, y, visited);
            }
        }
        return count;
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
