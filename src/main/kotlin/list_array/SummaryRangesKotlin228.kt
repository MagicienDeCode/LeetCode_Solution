package list_array

import java.util.*

class SummaryRangesKotlin228 {
    fun summaryRanges(nums: IntArray): List<String> {
        val results: MutableList<String> = LinkedList()
        if (nums.isEmpty()) {
            return results
        }
        var start = 0
        var end = 0
        while (end < nums.size) {
            while (end <= nums.size - 2 && nums[end] + 1 == nums[end + 1]) {
                ++end
            }
            if (start == end) {
                results.add(nums[start].toString() + "")
            } else {
                results.add(nums[start].toString() + "->" + nums[end])
            }
            start = ++end
        }
        return results
    }
}