package dynamic_programming

class MinimumCostForTicketsKotlin983 {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val dp = IntArray(366) { Int.MAX_VALUE }
        dp[0] = 0
        for (d in days) {
            dp[d] = 0
        }
        for (index in 1..365) {
            if (dp[index] == Int.MAX_VALUE) {
                dp[index] = dp[index - 1]
            } else {
                dp[index] = minOf(
                    dp[index - 1] + costs[0],
                    dp[maxOf(index - 7, 0)] + costs[1],
                    dp[maxOf(index - 30, 0)] + costs[2]
                )
            }
        }
        return dp[days[days.size - 1]]
    }
}