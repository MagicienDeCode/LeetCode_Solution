package dynamic_programming

import java.util.*

class LargestSizeOfRussianDollStringKotlin {
    fun largestDivisibleSubset(nums: Array<String>): Int {
        if (nums.isEmpty()) {
            return 0
        }
        nums.sortWith(Comparator.comparing(String::length))
        val dp = IntArray(nums.size) { 1 }
        var max = 1
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j].contains(nums[i]) &&
                    dp[j] < dp[i] + 1
                ) {
                    dp[j] = dp[i] + 1
                    max = maxOf(max, dp[j])
                }
            }
        }
        return max
    }
}

fun main() {
    val solution = LargestSizeOfRussianDollStringKotlin()
    println(solution.largestDivisibleSubset(arrayOf("1", "2")))
    println(solution.largestDivisibleSubset(arrayOf()))
    println(solution.largestDivisibleSubset(arrayOf("anna", "anna2", "anna3", "anna34")))
    println(solution.largestDivisibleSubset(arrayOf("anna34", "anna2", "anna3", "anna")))
}