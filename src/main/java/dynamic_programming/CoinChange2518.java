package dynamic_programming;

public class CoinChange2518 {
    public int change(int amount, int[] coins) {
        final int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int index = coin; index <= amount; index++) {
                dp[index] += dp[index - coin];
            }
        }
        return dp[amount];
    }
}
