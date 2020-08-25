package dynamic_programming;

import java.util.Arrays;

public class MinimumCostForTickets983 {
    public int mincostTickets(int[] days, int[] costs) {
        final int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // we only concern the given days, so mark as 0
        for (int d : days) {
            dp[d] = 0;
        }
        for (int index = 1; index < 366; index++) {
            // if INT.MAX, it's not the given day, just take the previous value
            if (dp[index] == Integer.MAX_VALUE) {
                dp[index] = dp[index - 1];
            } else {
                // dp state function, minOf 3 situations
                dp[index] = Math.min(
                        Math.min(
                                dp[index - 1] + costs[0],
                                dp[Math.max(index - 7, 0)] + costs[1]
                        ),
                        dp[Math.max(index - 30, 0)] + costs[2]
                );
            }
        }
        return dp[days[days.length - 1]];
    }
}
