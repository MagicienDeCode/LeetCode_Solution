package top_interview_easy.array

class MoveZeroesKotlin283 {
    fun moveZeroes(nums: IntArray) {
        var lastNonZeroIndex = 0
        for (index in nums.indices) {
            if (nums[index] != 0) {
                if (index != lastNonZeroIndex) {
                    val temp = nums[index]
                    nums[index] = nums[lastNonZeroIndex]
                    nums[lastNonZeroIndex] = temp
                }
                ++lastNonZeroIndex
            }
        }
    }
}