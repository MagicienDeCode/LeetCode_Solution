package dynamic_programming

class MaximumSubarrayKotlin53 {
    fun maxSubArray(nums: IntArray): Int {
        // Kadane’s Algorithm
        var currentMax = 0
        return nums.fold(Int.MIN_VALUE) { acc: Int, i: Int ->
            currentMax = maxOf(i, i + currentMax)
            maxOf(acc, currentMax)
        }
    }
}