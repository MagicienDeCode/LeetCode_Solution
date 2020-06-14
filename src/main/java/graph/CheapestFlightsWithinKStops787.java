package graph;

import java.util.Arrays;

public class CheapestFlightsWithinKStops787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1000000);
        dp[src] = 0;
        for (int time = 0; time <= k; time++) {
            final int[] newDp = Arrays.copyOf(dp, dp.length);
            for (int[] f : flights) {
                newDp[f[1]] = Math.min(newDp[f[1]], dp[f[0]] + f[2]);
            }
            dp = newDp;
        }
        return dp[dst] >= 1000000 ? -1 : dp[dst];
    }
}
