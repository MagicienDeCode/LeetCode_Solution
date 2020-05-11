package sort_an_array_912

class SelectionSortKotlin {
    fun sortArray(nums: IntArray): IntArray {
        for (index in nums.indices) {
            var minIndex = index
            for (currentIndex in index + 1 until nums.size) {
                if (nums[currentIndex] < nums[minIndex]) {
                    minIndex = currentIndex
                }
            }
            if (minIndex != index) {
                nums[minIndex] = nums[minIndex].xor(nums[index])
                nums[index] = nums[minIndex].xor(nums[index])
                nums[minIndex] = nums[minIndex].xor(nums[index])
            }
        }
        return nums
    }
}
