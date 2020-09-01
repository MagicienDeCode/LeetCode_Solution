package string_integer

import java.util.*
import java.util.stream.Collectors

class PermutationsKotlin46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = LinkedList()
        permutate(nums, 0, results)
        return results
    }

    private fun permutate(nums: IntArray, start: Int, results: MutableList<List<Int>>) {
        if (start == nums.size) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()))
        } else {
            for (i in start until nums.size) {
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