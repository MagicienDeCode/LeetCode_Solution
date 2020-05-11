package sort_an_array_912

class MergeSortKotlin {
    fun sortArray(nums: IntArray): IntArray {
        val temps = IntArray(nums.size)
        mergeSort(nums, temps, 0, nums.size - 1)
        return nums
    }

    private fun mergeSort(nums: IntArray, temps: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        // val mid = start + (end - start) / 2
        val mid = start + (end - start).shr(1)
        mergeSort(nums, temps, start, mid)
        mergeSort(nums, temps, mid + 1, end)
        merge(nums, temps, start, end)
    }

    private fun merge(nums: IntArray, temps: IntArray, start: Int, end: Int) {
        val mid = start + (end - start).shr(1)
        var left = start
        var right = mid + 1
        var tempsIndex = start
        while (left <= mid && right <= end) {
            when {
                nums[left] <= nums[right] -> temps[tempsIndex++] = nums[left++]
                else -> temps[tempsIndex++] = nums[right++]
            }
        }
        while (left <= mid) {
            temps[tempsIndex++] = nums[left++]
        }
        while (right <= end) {
            temps[tempsIndex++] = nums[right++]
        }
        for (index in start..end) {
            nums[index] = temps[index]
        }
    }
}
