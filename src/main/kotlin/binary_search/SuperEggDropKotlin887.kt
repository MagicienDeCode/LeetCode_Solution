package binary_search

class SuperEggDropKotlin887 {
    fun superEggDrop(K: Int, N: Int): Int {
        var left = 1
        var right = N
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            if (test(mid, K, N)) {
                right = mid
            } else {
                left = mid
            }
        }
        if (test(left, K, N)) {
            return left
        }
        return right
    }

    private fun test(target: Int, k: Int, n: Int): Boolean {
        var result = 0
        var temp = 1
        for (index in 1..k) {
            temp *= target - index + 1
            temp /= index
            result += temp
            if (result >= n) {
                return true
            }
        }
        return result >= n
    }
    /*
    fun superEggDrop(K: Int, N: Int): Int {
        val dp = Array(N + 1) { IntArray(K + 1) }
        for (time in 1..N) {
            dp[time][0] = 0
            for (egg in 1..K) {
                dp[time][egg] = dp[time - 1][egg - 1] + dp[time - 1][egg] + 1
                if (dp[time][egg] >= N) {
                    return time
                }
            }
        }
        return N
    }
     */
    /*
    fun superEggDrop(K: Int, N: Int): Int {
        val dp = Array(N + 1) { IntArray(K + 1) { 1 } }
        for (floor in 2..N) {
            dp[floor][1] = floor
            for (egg in 2..K) {
                dp[floor][egg] = binarySearch(dp, floor, egg) + 1
            }
        }
        return dp[N][K]
    }

    private fun binarySearch(dp: Array<IntArray>, floor: Int, egg: Int): Int {
        var left = 2
        var right = floor
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val broken = dp[mid - 1][egg - 1]
            val notBroken = dp[floor - mid][egg]
            when {
                broken == notBroken -> return broken
                broken < notBroken -> left = mid
                else -> right = mid
            }
        }
        val leftVal = maxOf(dp[left - 1][egg - 1], dp[floor - left][egg])
        val rightVal = maxOf(dp[right - 1][egg - 1], dp[floor - right][egg])
        return minOf(leftVal, rightVal)
    }
     */
    /*
    // Time Limit Exceeded
    private fun binarySearch(dp: Array<IntArray>, floor: Int, egg: Int): Int {
        var left = 2
        var right = floor
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            var midMinus1 = getValue(dp, floor, egg, mid - 1)
            val midVal = getValue(dp, floor, egg, mid)
            var midPlus1 = getValue(dp, floor, egg, mid + 1)
            var current = 2
            while (midMinus1 == midVal && midVal == midPlus1) {
                if (mid - current >= 2) {
                    midMinus1 = getValue(dp, floor, egg, mid - current)
                }
                if (mid + current <= floor) {
                    midPlus1 = getValue(dp, floor, egg, mid + current)
                }
                if (mid - current < 2 || mid + current > floor) {
                    return midVal
                }
                current++
            }
            when {
                midMinus1 > midVal && midVal < midPlus1 -> return midVal
                midVal in midPlus1..midMinus1 -> left = mid
                midVal in midMinus1..midPlus1 -> right = mid
            }
        }
        val leftVal = getValue(dp, floor, egg, left)
        val rightVal = getValue(dp, floor, egg, right)
        return minOf(leftVal, rightVal)
    }

    private fun getValue(dp: Array<IntArray>, floor: Int, egg: Int, target: Int): Int =
        maxOf(dp[target - 1][egg - 1], dp[floor - target][egg])
     */
    /*
    // Time Limit Exceeded
    fun superEggDrop(K: Int, N: Int): Int {
        val dp = Array(N + 1) { IntArray(K + 1) { 1 } }
        for (floor in 2..N) {
            dp[floor][1] = floor
            for (egg in 2..K) {
                dp[floor][egg] = floor
                for (f in 2..floor) {
                    dp[floor][egg] = minOf(
                        dp[floor][egg],
                        1 + maxOf(dp[f - 1][egg - 1], dp[floor - f][egg])
                    )
                }
            }
        }
        return dp[N][K]
    }
     */
}

fun main() {
    val solution = SuperEggDropKotlin887()
    // 4
    println(solution.superEggDrop(3, 14))
    // 3
    println(solution.superEggDrop(2, 6))
    // 9
    println(solution.superEggDrop(2, 45))
    // 14
    println(solution.superEggDrop(9, 10000))
}