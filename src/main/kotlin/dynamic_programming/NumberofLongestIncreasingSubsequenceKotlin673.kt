package dynamic_programming

import java.util.*

class NumberofLongestIncreasingSubsequenceKotlin673 {
    fun findNumberOfLIS(nums: IntArray): Int {
        if (nums.size <= 1) {
            return nums.size
        }
        val lengthsLIS = IntArray(nums.size)
        val count = IntArray(nums.size)
        Arrays.fill(count, 1)
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    if (lengthsLIS[j] >= lengthsLIS[i]) {
                        lengthsLIS[i] = lengthsLIS[j] + 1
                        count[i] = count[j]
                    } else if (lengthsLIS[j] + 1 == lengthsLIS[i]) {
                        count[i] += count[j]
                    }
                }
            }
        }
        var longest = 0
        var result = 0
        for (len in lengthsLIS) {
            longest = Math.max(len, longest)
        }
        for (i in nums.indices) {
            if (lengthsLIS[i] == longest) {
                result += count[i]
            }
        }
        return result
    }
}