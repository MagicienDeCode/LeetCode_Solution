package dynamic_programming;

public class TwoCityScheduling1029 {
    public int twoCitySchedCost(int[][] costs) {
        final int half = costs.length >> 1;
        final int[][] dp = new int[half + 1][half + 1];
        for (int index = 1; index < dp.length; index++) {
            dp[0][index] = dp[0][index - 1] + costs[index - 1][0];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][1];
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j] + costs[i + j - 1][1],
                        dp[i][j - 1] + costs[i + j - 1][0]
                );
            }
        }
        return dp[half][half];
    }
    /*
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(ints -> ints[0] - ints[1]));
        int cost = 0;
        final int half = costs.length >> 1;
        for (int index = 0; index < costs.length; index++) {
            if (index < half) {
                cost += costs[index][0];
            } else {
                cost += costs[index][1];
            }
        }
        return cost;
    }
     */
}
