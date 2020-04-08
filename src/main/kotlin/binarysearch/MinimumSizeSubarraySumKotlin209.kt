package binarysearch

class MinimumSizeSubarraySumKotlin209 {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var minimumSize = Int.MAX_VALUE
        var slow = 0
        var fast = 0
        var sum = nums[0]
        while (fast < nums.size - 1 || slow < nums.size - 1) {
            if (sum < s) {
                if (fast == nums.size - 1) {
                    slow = fast
                } else {
                    sum += nums[++fast]
                }
            } else {
                minimumSize = minOf(minimumSize, fast - slow + 1)
                sum -= nums[slow++]
            }
        }
        return if (minimumSize == Int.MAX_VALUE) 0 else minimumSize
    }
}