package list_array

class MaximumProductSubarrayKotlin152 {
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var result = nums[0]
        var max = nums[0]
        var min = nums[0]
        for (i in 1 until nums.size) {
            val maxCurrent = max
            val minCurrent = min
            max = maxOf(maxOf(nums[i], maxCurrent * nums[i]), minCurrent * nums[i])
            min = minOf(minOf(nums[i], minCurrent * nums[i]), maxCurrent * nums[i])
            result = maxOf(max, result)
        }
        return result
    }
}