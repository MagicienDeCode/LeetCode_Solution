package dynamic_programming;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        // Kadane’s Algorithm
        int max = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int n : nums) {
            currentMax = Math.max(n, n + currentMax);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
