package top_interview_easy.array

import java.util.HashMap

class ContainsDuplicateIIKotlin219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map: MutableMap<Int, Int?> = HashMap()
        for (index in nums.indices) {
            if (map.containsKey(nums[index])) {
                val old = map[nums[index]]!!
                if (index - old <= k) {
                    return true
                }
            }
            map[nums[index]] = index
        }
        return false
    }
}