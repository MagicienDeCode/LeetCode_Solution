package depth_first_search;

public class RemoveBoxes546 {
    public int removeBoxes(int[] boxes) {
        final int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][i][j] = (1 + j) * (j + 1);
            }
        }

        for (int i = 1; i < boxes.length; i++) {
            for (int j = i; j < boxes.length; j++) {
                final int d = j - i;
                for (int k = 0; k <= d; k++) {
                    int result = (1 + k) * (k + 1) + dp[d + 1][j][0];
                    for (int l = d + 1; l <= j; l++) {
                        if (boxes[l] == boxes[d]) {
                            result = Math.max(result, dp[d + 1][l - 1][0] + dp[l][j][k + 1]);
                        }
                    }
                    dp[d][j][k] = result;
                }
            }
        }
        return boxes.length == 0 ? 0 : dp[0][boxes.length - 1][0];
    }
    /*
    private int[] boxes;
    private int[][][] dp;

    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        this.dp = new int[boxes.length][boxes.length][boxes.length];
        return dfs(0, boxes.length - 1, 0);
    }

    private int dfs(int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right][k] != 0) {
            return dp[left][right][k];
        }
        while (left < right && boxes[left + 1] == boxes[left]) {
            left++;
            k++;
        }
        int result = (k + 1) * (k + 1) + dfs(left + 1, right, 0);
        for (int i = left + 1; i <= right; i++) {
            if (boxes[left] == boxes[i]) {
                result = Math.max(result, dfs(left + 1, i - 1, 0) + dfs(i, right, k + 1));
            }
        }

        dp[left][right][k] = result;
        return result;
    }
     */
}
