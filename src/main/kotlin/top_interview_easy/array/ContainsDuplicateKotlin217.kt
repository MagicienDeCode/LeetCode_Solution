package top_interview_easy.array

import java.util.HashSet

class ContainsDuplicateKotlin217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set: MutableSet<Int> = HashSet()
        for (n in nums) {
            if (set.contains(n)) {
                return true
            }
            set.add(n)
        }
        return false
    }
}