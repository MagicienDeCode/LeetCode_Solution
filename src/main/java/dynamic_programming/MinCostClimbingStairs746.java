package dynamic_programming;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;
        for (int i = 2; i <= cost.length; i++) {
            final int temp = one;
            one = Math.min(one + cost[i - 1], two + cost[i - 2]);
            two = temp;
        }
        return one;
    }

    /*
    public int minCostClimbingStairs(int[] cost) {
        final int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            final int takeOne = dp[i - 1] + cost[i - 1];
            final int takeTwo = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOne, takeTwo);
        }
        return dp[cost.length];
    }
     */
}
