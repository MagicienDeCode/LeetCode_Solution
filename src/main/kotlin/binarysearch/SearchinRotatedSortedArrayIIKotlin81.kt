package binarysearch

class SearchinRotatedSortedArrayIIKotlin81 {
    fun search(nums: IntArray, target: Int): Boolean {
        if (nums.isEmpty()) {
            return false
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return true
                nums[mid] == nums[left] -> left++
                nums[mid] == nums[right] -> left--
                nums[mid] >= nums[0] -> {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid
                    } else {
                        left = mid
                    }
                }
                nums[mid] <= nums[nums.size - 1] -> {
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid
                    } else {
                        right = mid
                    }
                }
            }
        }
        return target == nums[left] || target == nums[right]
    }
}