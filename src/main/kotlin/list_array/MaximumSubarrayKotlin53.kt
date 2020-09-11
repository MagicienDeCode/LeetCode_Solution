package list_array

class MaximumSubarrayKotlin53 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var result = Int.MIN_VALUE
        var current = 0
        for (n in nums) {
            current = maxOf(current + n, n)
            result = maxOf(result, current)
        }
        return result
    }
}