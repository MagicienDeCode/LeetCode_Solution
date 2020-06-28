package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

class MaximumProfitinJobScheduling1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int[][] jobs = new int[startTime.length][];
        for (int index = 0; index < startTime.length; index++) {
            jobs[index] = new int[]{startTime[index], endTime[index], profit[index]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(anInt -> anInt[1]));
        final int[] dp = new int[startTime.length + 1];
        for (int index = 1; index < dp.length; index++) {
            final int currentProfit = jobs[index - 1][2];
            final int currentStart = jobs[index - 1][0];
            int previousIndex = -1;
            /*
            for (int previous = index - 1; previous >= 1; previous--) {
                final int previousEnd = jobs[previous - 1][1];
                if (previousEnd <= currentStart) {
                    previousIndex = previous;
                    break;
                }
            }
             */
            previousIndex = lastIndexLessEqualThan(jobs, currentStart, index - 2);
            final int previousProfit = previousIndex == -1 ? 0 : dp[previousIndex];
            dp[index] = Math.max(previousProfit + currentProfit, dp[index - 1]);
        }
        return dp[startTime.length];
    }

    private int lastIndexLessEqualThan(
            int[][] jobs,
            int target,
            int endIndex) {
        if (endIndex < 0) {
            return -1;
        }
        int left = 0;
        int right = endIndex;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (jobs[right][1] <= target) {
            return right + 1;
        }
        if (jobs[left][1] <= target) {
            return left + 1;
        }
        return -1;
    }
}