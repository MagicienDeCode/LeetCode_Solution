package dynamic_programming

class MaximumProfitinJobSchedulingKotlin1235 {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs = Array(startTime.size) { IntArray(3) }
        for (index in startTime.indices) {
            jobs[index] = intArrayOf(startTime[index], endTime[index], profit[index])
        }
        jobs.sortWith(Comparator { ints1, ints2 -> compareValues(ints1[1], ints2[1]) })
        val dp = IntArray(startTime.size + 1)
        for (index in 1 until dp.size) {
            val currentProfit = jobs[index - 1][2]
            val currentStart = jobs[index - 1][0]
            /*
            var previousIndex = -1
            for (previous in index - 1 downTo 1) {
                val previousEnd = jobs[previous - 1][1]
                if (previousEnd <= currentStart) {
                    previousIndex = previous
                    break
                }
            }
             */
            val previousIndex = lastIndexLessEqualThan(jobs, currentStart, index - 2)
            val previousProfit = if (previousIndex == -1) 0 else dp[previousIndex]
            dp[index] = maxOf(previousProfit + currentProfit, dp[index - 1])
        }
        return dp[startTime.size]
    }

    private fun lastIndexLessEqualThan(jobs: Array<IntArray>, target: Int, endIndex: Int): Int {
        if (endIndex < 0) {
            return -1
        }
        var left = 0
        var right = endIndex
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val end = jobs[mid][1]
            if (end <= target) {
                left = mid
            } else {
                right = mid
            }
        }
        if (jobs[right][1] <= target) {
            return right + 1
        }
        if (jobs[left][1] <= target) {
            return left + 1
        }
        return -1
    }
}

fun main() {
    val solution = MaximumProfitinJobSchedulingKotlin1235()
    println(
        solution.jobScheduling(
            intArrayOf(1, 2, 3, 3),
            intArrayOf(3, 4, 5, 6),
            intArrayOf(50, 10, 40, 70)
        )
    )
    println(
        solution.jobScheduling(
            intArrayOf(1, 2, 3, 4, 6),
            intArrayOf(3, 5, 10, 6, 9),
            intArrayOf(20, 20, 100, 70, 60)
        )
    )
    println(
        solution.jobScheduling(
            intArrayOf(1, 1, 1),
            intArrayOf(2, 3, 4),
            intArrayOf(5, 6, 4)
        )
    )
}