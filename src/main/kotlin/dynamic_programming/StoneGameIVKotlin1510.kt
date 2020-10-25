package dynamic_programming

class StoneGameIVKotlin1510 {
    /*
    Let's think in the backtrack way. If we have a state i that we know the current player must lose, what can we infer?
    -- Any other states that can go to i must be True.
    Let's say in another state j the current player in j can go to i by removing stones.
    In this case, the state j is True since the current player must win.
    How to find all the state j? Well, we can iterate over the square numbers and add them to i.
     */
    fun winnerSquareGame(n: Int): Boolean {
        val dp = BooleanArray(n + 1)
        for (i in 0..n) {
            if (dp[i]) {
                continue
            }
            var k = 1
            while (i + k * k <= n) {
                dp[i + k * k] = true
                k++
            }
        }
        return dp[n]
    }
}