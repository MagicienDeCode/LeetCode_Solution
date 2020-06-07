package dynamic_programming

class CoinChangeKotlin322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        for (index in 1..amount) {
            for (coin in coins) {
                if (coin <= index) {
                    dp[index] = minOf(dp[index], dp[index - coin] + 1)
                }
            }
        }
        return when {
            dp[amount] > amount -> -1
            else -> dp[amount]
        }
    }
}

fun main() {
    val solution = CoinChangeKotlin322()
    // 20
    println(solution.coinChange(intArrayOf(186, 419, 83, 408), 6249))
    // 4
    println(solution.coinChange(intArrayOf(5, 3, 2), 14))
    // 3
    println(solution.coinChange(intArrayOf(1, 2, 5), 11))
    // -1
    println(solution.coinChange(intArrayOf(2), 3))
}