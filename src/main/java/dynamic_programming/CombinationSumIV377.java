package dynamic_programming;

public class CombinationSumIV377 {
    public int combinationSum4(int[] nums, int target) {
        final int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int index = 1; index <= target; index++) {
            for (int coin : nums) {
                if (coin <= index) {
                    dp[index] += dp[index - coin];
                }
            }
        }
        return dp[target];
    }
}
