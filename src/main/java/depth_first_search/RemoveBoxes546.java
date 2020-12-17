package depth_first_search;

public class RemoveBoxes546 {

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
}
