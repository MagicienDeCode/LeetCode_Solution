package string_integer;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        final int subSum = sum >> 1;
        final boolean[][] dp = new boolean[nums.length + 1][subSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            final int current = nums[i - 1];
            for (int j = 0; j <= subSum; j++) {
                if (j < current) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - current]);
                }
            }
        }
        return dp[nums.length][subSum];
    }
}
