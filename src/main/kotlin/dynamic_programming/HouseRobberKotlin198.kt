package dynamic_programming

class HouseRobberKotlin198 {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[1], dp[0])
        for (i in 2 until nums.size) {
            dp[i] = maxOf(
                // take current + i-2
                nums[i] + dp[i - 2],
                // do not take current, previous
                dp[i - 1]
            )
        }
        return dp[nums.size - 1]
    }
}