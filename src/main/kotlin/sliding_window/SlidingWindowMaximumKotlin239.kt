package sliding_window

import java.util.*

class SlidingWindowMaximumKotlin239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(0)
        }
        val resultArray = IntArray(nums.size - k + 1)
        // store index of nums
        val deque: Deque<Int> = LinkedList()
        // deque:   offerFirst ==>           <== offerLast
        //          <== pollFirst            pollLast ==>
        for (i in nums.indices) {
            // if deque.first is left of window, remove it
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst()
            }
            // remove from last if last < current
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast()
            }
            // add current
            deque.offerLast(i)
            if (i + 1 >= k) {
                resultArray[i - k + 1] = nums[deque.peekFirst()]
            }
        }
        return resultArray
    }
}