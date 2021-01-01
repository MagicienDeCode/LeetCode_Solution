package depth_first_search;

import java.util.Arrays;

public class OutofBoundaryPaths576 {

    private final int MODULO = 1000000007;

    private int m;
    private int n;
    private int[][][] dp;

    public int findPaths(int m, int n, int times, int i, int j) {
        this.m = m;
        this.n = n;
        dp = new int[m][n][times + 1];
        for (int[][] dpmn : dp) {
            for (int[] t : dpmn) {
                Arrays.fill(t, -1);
            }
        }
        return dfs(times, i, j);
    }

    private static final int[] deltaX = {0, 0, 1, -1};
    private static final int[] deltaY = {1, -1, 0, 0};

    private int dfs(int times, int x, int y) {
        if (!inBound(x, y)) {
            return 1;
        }
        if (times == 0) {
            return 0;
        }
        if (dp[x][y][times] >= 0) {
            return dp[x][y][times];
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            final int nX = x + deltaX[i];
            final int nY = y + deltaY[i];
            result = (result + dfs(times - 1, nX, nY)) % MODULO;
        }
        dp[x][y][times] = result;
        return result;
    }

    private boolean inBound(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {
        final OutofBoundaryPaths576 java = new OutofBoundaryPaths576();
        // 6 12
        System.out.println(java.findPaths(2, 2, 2, 0, 0));
        System.out.println(java.findPaths(1, 3, 3, 0, 1));
        // 102984580
        System.out.println(java.findPaths(8, 7, 16, 1, 5));
        //
        System.out.println(java.findPaths(45, 35, 47, 20, 31));
    }
}
