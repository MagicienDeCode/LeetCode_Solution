package string_integer

import java.util.*

class PermutationsIIKotlin47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = LinkedList()
        Arrays.sort(nums)
        permutate(nums, 0, results)
        return results
    }

    private fun permutate(nums: IntArray, start: Int, results: MutableList<List<Int>>) {
        if (start == nums.size) {
            results.add(nums.toList())
        } else {
            for (i in start until nums.size) {
                var j = i - 1
                while (j >= start && nums[j] != nums[i]) {
                    --j
                }
                if (j != start - 1) {
                    continue
                }
                swap(nums, i, start)
                permutate(nums, start + 1, results)
                swap(nums, i, start)
            }
        }
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        if (i != j) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }
}