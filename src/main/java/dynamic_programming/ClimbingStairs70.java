package dynamic_programming;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int i1 = 1;
        int i2 = 2;
        for (int index = 3; index <= n; index++) {
            final int sum = i1 + i2;
            i1 = i2;
            i2 = sum;
        }
        return i2;
    }
    /*
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        final int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int index = 3; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }
     */
}
