package dynamic_programming;

public class BurstBalloons312 {
    public int maxCoins(int[] nums) {
        final int[] balloon = new int[nums.length + 2];
        balloon[0] = 1;
        balloon[balloon.length - 1] = 1;
        System.arraycopy(nums, 0, balloon, 1, nums.length);
        final int[][] dp = new int[balloon.length][balloon.length];
        for (int len = 1; len <= nums.length; len++) {
            final int endI = nums.length - len + 1;
            for (int i = 1; i <= endI; i++) {
                final int endJ = i + len - 1;
                for (int k = i; k < endJ; k++) {
                    dp[i][endJ] = Math.max(
                            dp[i][endJ],
                            balloon[i - 1] * nums[k] * nums[endJ + 1] + dp[i][k - 1] + dp[k + 1][endJ]
                    );
                }
            }
        }
        return dp[1][nums.length];
    }
}
