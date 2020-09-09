package dynamic_programming;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                rob(nums, 0, nums.length - 1),
                rob(nums, 1, nums.length)
        );
    }

    public int rob(int[] nums, int start, int end) {
        final int[] dp = new int[nums.length];
        dp[start] = nums[start];
        if (start + 1 == end) {
            return dp[start];
        }
        dp[start + 1] = Math.max(nums[start + 1], dp[start]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(
                    // take current + i-2
                    nums[i] + dp[i - 2],
                    // do not take current, previous
                    dp[i - 1]
            );
        }
        return dp[end - 1];
    }
}
