package top_interview_easy.array

class ContainsDuplicateIIIKotlin220 {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (nums.isEmpty() || k == 0) {
            return false
        }
        var start = 0
        var end = 0
        while (start < nums.size - 1) {
            if (end - start == k || end == nums.size - 1) {
                end = ++start
                continue
            }
            ++end
            if (Math.abs(nums[start].toLong() - nums[end].toLong()) <= t) {
                return true
            }
        }
        return false
    }
}