package top_interview_easy.array

class RemoveDuplicatesfromSortedArrayKotlin26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var current = 0
        for (index in 1 until nums.size) {
            if (nums[current] != nums[index]) {
                ++current
                nums[current] = nums[index]
            }
        }
        return current + 1
    }
}