package top_interview_easy.array

class RotateArrayKotlin189 {
    /*
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     */
    fun rotate(nums: IntArray, k: Int) {
        // three steps to reverse
        val kk = k % nums.size
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, kk - 1)
        reverse(nums, kk, nums.size - 1)
    }

    private fun reverse(nums: IntArray, startVal: Int, endVal: Int) {
        var start = startVal
        var end = endVal
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            ++start
            --end
        }
    }
}
