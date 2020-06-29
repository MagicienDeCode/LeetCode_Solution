package depth_first_search;

class UniquePathsIII980 {

    int result = 0;

    public int uniquePathsIII(int[][] grid) {
        int totalZero = 0;
        for (int[] gs : grid) {
            for (int g : gs) {
                if (g == 0) {
                    ++totalZero;
                }
            }
        }
        result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, 0, totalZero);
                }
            }
        }
        return result;
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

    private void dfs(
            int[][] grid,
            int x,
            int y,
            int current,
            int totalZero) {
        if (grid[x][y] == 2 && current == totalZero) {
            ++result;
        }
        final int value = grid[x][y];
        final int nextCurrent = value == 0 ? current + 1 : current;
        grid[x][y] = -1;
        for (int index = 0; index < deltaX.length; index++) {
            final int nextX = x + deltaX[index];
            final int nextY = y + deltaY[index];
            if (inBound(grid, nextX, nextY) && grid[nextX][nextY] != -1) {
                dfs(grid, nextX, nextY, nextCurrent, totalZero);
            }
        }
        grid[x][y] = value;
    }
}