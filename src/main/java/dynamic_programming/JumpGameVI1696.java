package dynamic_programming;

import java.util.PriorityQueue;

public class JumpGameVI1696 {
    public int maxResult(int[] nums, int k) {
        final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        priorityQueue.offer(new int[]{0, nums[0]});
        for (int i = 1; i < nums.length; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < i - k) {
                priorityQueue.poll();
            }
            if (i == nums.length - 1) {
                return priorityQueue.peek()[1] + nums[i];
            }
            priorityQueue.offer(new int[]{i, priorityQueue.peek()[1] + nums[i]});
        }
        return nums[0];
    }
    /*
    Time Limit Exceeded

    public int maxResult(int[] nums, int k) {
        final int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j < 0) {
                    break;
                }
                dp[i] = Math.max(dp[i - j] + nums[i], dp[i]);
            }
        }
        return dp[nums.length - 1];
    }
     */
}
