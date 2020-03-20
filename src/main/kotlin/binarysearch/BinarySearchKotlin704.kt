package binarysearch

class BinarySearchKotlin704 {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
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
}
