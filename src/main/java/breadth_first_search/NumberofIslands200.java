package breadth_first_search;

public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return 0;
        }
        final int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ++count;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, int[][] visited) {
        visited[x][y] = 7;
        for (int index = 0; index < deltaX.length; index++) {
            final int nextX = x + deltaX[index];
            final int nextY = y + deltaY[index];
            if (inBound(grid, nextX, nextY) &&
                    visited[nextX][nextY] == 0 &&
                    grid[nextX][nextY] == '1') {
                visited[nextX][nextY] = 7;
                dfs(grid, nextX, nextY, visited);
            }
        }
    }
    /*
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return 0;
        }
        final int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ++count;
                    final Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair<>(i, j));
                    visited[i][j] = 7;
                    while (!queue.isEmpty()) {
                        final Pair<Integer, Integer> current = queue.poll();
                        final int x = current.getKey();
                        final int y = current.getValue();
                        for (int index = 0; index < deltaX.length; index++) {
                            final int nextX = x + deltaX[index];
                            final int nextY = y + deltaY[index];
                            if (inBound(grid, nextX, nextY) &&
                                    visited[nextX][nextY] == 0 &&
                                    grid[nextX][nextY] == '1') {
                                queue.offer(new Pair<>(nextX, nextY));
                                visited[nextX][nextY] = 7;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
     */

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            char[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
