package dynamic_programming;

import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int index = 1; index <= amount; index++) {
            for (int coin : coins) {
                if (coin <= index) {
                    dp[index] = Math.min(dp[index], dp[index - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
