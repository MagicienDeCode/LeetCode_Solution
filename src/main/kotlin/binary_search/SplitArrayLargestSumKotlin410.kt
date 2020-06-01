package binary_search

class SplitArrayLargestSumKotlin410 {
    /*
    fun splitArray(nums: IntArray, m: Int): Int {
        val sums = IntArray(nums.size + 1)
        val dpMatrix = Array(m + 1) { IntArray(nums.size + 1) { Int.MAX_VALUE } }
        for (index in 1 until sums.size) {
            sums[index] = sums[index - 1] + nums[index - 1]
            dpMatrix[1][index] = sums[index]
        }
        for (i in 1 until dpMatrix.size) {
            for (j in 2 until dpMatrix[0].size) {
                for (p in i - 1 until j) {
                    val max = maxOf(dpMatrix[i - 1][p], sums[j] - sums[p])
                    dpMatrix[i][j] = minOf(dpMatrix[i][j], max)
                }
            }
        }
        return dpMatrix[m][nums.size]
    }
     */
    fun splitArray(nums: IntArray, m: Int): Int {
        var left = 0
        var right = 0
        for (n in nums) {
            left = maxOf(left, n)
            right += n
        }
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                isValid(nums, m, mid) -> right = mid
                else -> left = mid
            }
        }
        return when {
            isValid(nums, m, left) -> left
            else -> right
        }
    }

    private fun isValid(nums: IntArray, m: Int, targetSum: Int): Boolean {
        var count = 1
        var current = 0
        for (n in nums) {
            current += n
            if (current > targetSum) {
                current = n
                if (++count > m) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    val solution = SplitArrayLargestSumKotlin410()
    println(solution.splitArray(intArrayOf(7, 2, 5, 10, 8), 2))
}