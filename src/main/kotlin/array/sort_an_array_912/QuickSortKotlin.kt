package array.sort_an_array_912

class QuickSortKotlin {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    private fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val pivot = nums[start + (end - start).shr(1)]
        var left = start
        var right = end
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                ++left
            }
            while (left <= right && nums[right] > pivot) {
                --right
            }
            if (left <= right) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                ++left
                --right
            }
        }
        quickSort(nums, start, right)
        quickSort(nums, left, end)
    }
}
