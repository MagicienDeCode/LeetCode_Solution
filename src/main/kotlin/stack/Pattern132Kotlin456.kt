package stack

import java.util.*

class Pattern132Kotlin456 {
    /*
    fun find132pattern(nums: IntArray): Boolean {
        var minI = nums[0]
        for (j in 1 until nums.size - 1) {
            minI = Math.min(minI, nums[j])
            for (k in j + 1 until nums.size) {
                if (nums[k] > minI && nums[j] > nums[k]) {
                    return true
                }
            }
        }
        return false
    }
     */
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }
        val stack = Stack<Int>()
        val min = IntArray(nums.size)
        min[0] = nums[0]
        for (i in 1 until nums.size) {
            min[i] = Math.min(min[i - 1], nums[i])
        }
        for (j in nums.indices.reversed()) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop()
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true
                }
                stack.push(nums[j])
            }
        }
        return false
    }
}