package top_interview_easy.array

import java.util.*

class PancakeSortingKotlin969 {
    fun pancakeSort(nums: IntArray): List<Int> {
        val result: MutableList<Int> = LinkedList()
        for (valueToSort in nums.size downTo 1) {
            // locate the position for the value to sort in this round
            val index = find(nums, valueToSort)

            // sink the value_to_sort to the bottom,
            // with at most two steps of pancake flipping.
            if (index == valueToSort - 1) continue
            // 1). flip the value to the head if necessary
            if (index != 0) {
                result.add(index + 1)
                reverse(nums, index)
            }
            // 2). now that the value is at the head, flip it to the bottom
            result.add(valueToSort)
            this.reverse(nums, valueToSort - 1)
        }
        return result
    }

    private fun reverse(nums: IntArray, endVal: Int) {
        var end = endVal
        var start = 0
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            ++start
            --end
        }
    }

    private fun find(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            if (nums[i] == target) {
                return i
            }
        }
        return -1
    }
}