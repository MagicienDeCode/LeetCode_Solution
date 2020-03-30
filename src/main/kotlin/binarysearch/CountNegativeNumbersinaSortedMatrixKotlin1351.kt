package binarysearch

class CountNegativeNumbersinaSortedMatrixKotlin1351 {
    fun countNegatives(grid: Array<IntArray>): Int {
        // return grid.map(this::search).reduce(Int::plus)
        return grid.map(this::search).sum()
    }

    fun search(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] >= 0 -> left = mid
                nums[mid] < 0 -> right = mid
            }
        }
        return when {
            nums[right] >= 0 -> 0
            nums[left] < 0 -> nums.size
            else -> nums.size - right
        }
    }
}