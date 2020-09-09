package dynamic_programming

class HouseRobberIIKotlin213 {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        return if (nums.size == 1) {
            nums[0]
        } else maxOf(
            rob(nums, 0, nums.size - 1),
            rob(nums, 1, nums.size)
        )
    }

    private fun rob(nums: IntArray, start: Int, end: Int): Int {
        val dp = IntArray(nums.size)
        dp[start] = nums[start]
        if (start + 1 == end) {
            return dp[start]
        }
        dp[start + 1] = maxOf(nums[start + 1], dp[start])
        for (i in start + 2 until end) {
            dp[i] = maxOf(
                // take current + i-2
                nums[i] + dp[i - 2],
                // do not take current, previous
                dp[i - 1]
            )
        }
        return dp[end - 1]
    }
}