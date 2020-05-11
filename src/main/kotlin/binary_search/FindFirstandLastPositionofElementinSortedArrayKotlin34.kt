package binary_search

class FindFirstandLastPositionofElementinSortedArrayKotlin34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(searchFirstPosition(nums, target), searchLastPosition(nums, target))
    }

    fun searchFirstPosition(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> right = mid
                nums[mid] < target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when (target) {
            nums[left] -> left
            nums[right] -> right
            else -> -1
        }
    }

    fun searchLastPosition(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> left = mid
                nums[mid] < target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when (target) {
            nums[right] -> right
            nums[left] -> left
            else -> -1
        }
    }
}