package binary_search

import java.util.*

class LongestIncreasingSubsequenceKotlin300 {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val maxLISTree: TreeSet<Int> = TreeSet()
        nums.forEach {
            val result = maxLISTree.ceiling(it)
            if (result != null) {
                maxLISTree.remove(result)
            }
            maxLISTree.add(it)
        }
        return maxLISTree.size
    }
    /*
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val maxLIS: MutableList<Int> = mutableListOf()
        maxLIS.add(nums[0])
        for (index in 1 until nums.size) {
            when (val result = binarySearchFirstIndexOfElementNotLessThanTarget(maxLIS, nums[index])) {
                -1 -> maxLIS.add(nums[index])
                else -> maxLIS[result] = nums[index]
            }
        }
        return maxLIS.size
    }

    fun binarySearchFirstIndexOfElementNotLessThanTarget(nums: List<Int>, target: Int): Int {
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
        return when {
            nums[left] >= target -> left
            nums[right] >= target -> right
            else -> -1
        }
    }

    private fun findFirstIndexOfElementNotLessThanTarget(nums: List<Int>, target: Int): Int {
        nums.forEachIndexed { index, i ->
            if (i >= target) {
                return index
            }
        }
        return -1
    }
     */
}