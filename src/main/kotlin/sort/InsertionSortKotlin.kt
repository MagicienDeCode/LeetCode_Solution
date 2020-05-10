package sort

class InsertionSortKotlin {
    fun sortArray(nums: IntArray): IntArray {
        for (index in 1 until nums.size) {
            var lastPosition = index - 1
            val current = nums[index]
            while (lastPosition >= 0 && nums[lastPosition] > current) {
                nums[lastPosition + 1] = nums[lastPosition]
                --lastPosition
            }
            nums[lastPosition + 1] = current
        }
        return nums
    }
}

