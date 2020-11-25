package depth_first_search;

public class LongestIncreasingPathinaMatrix329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        final int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        int current = 0;
        for (int k = 0; k < 4; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            if (inBound(matrix, x, y) && matrix[i][j] < matrix[x][y]) {
                if (dp[x][y] != 0) {
                    current = Math.max(current, dp[x][y]);
                } else {
                    current = Math.max(current, dfs(matrix, x, y, dp));
                }
            }
        }
        dp[i][j] = 1 + current;
        return 1 + current;
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

    public static void main(String[] args) {
        final LongestIncreasingPathinaMatrix329 java = new LongestIncreasingPathinaMatrix329();
        // 4 4 7
        System.out.println(java.longestIncreasingPath(new int[][]{
                {9, 9, 4}, {6, 6, 8}, {2, 1, 1}
        }));
        System.out.println(java.longestIncreasingPath(new int[][]{
                {3, 4, 5}, {3, 2, 6}, {2, 2, 1}
        }));
        System.out.println(java.longestIncreasingPath(new int[][]{
                {7, 7, 1, 1}, {2, 7, 6, 0}, {1, 3, 5, 1}, {6, 6, 3, 2}
        }));
    }
}
