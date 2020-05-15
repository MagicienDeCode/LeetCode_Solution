package dynamic_programming;

public class MaximumSumCircularSubarray918 {
    public int maxSubarraySumCircular(int[] arrayA) {
        // Kadane’s Algorithm
        /*
        if maxSum array in [0 until arrayA.size] -> maxSum
        if maxSum array in [..arrayA.size -- 0 ..] -> sumOfArray - minSum
         */
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;
        for (int a : arrayA) {
            currentMax = Math.max(a, a + currentMax);
            maxSum = Math.max(currentMax, maxSum);
            currentMin = Math.min(a, a + currentMin);
            minSum = Math.min(currentMin, minSum);
            sum += a;
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
