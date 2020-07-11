package depth_first_search

import java.util.*
import kotlin.collections.ArrayList

class SubsetsIIKotlin90 {

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val results: MutableList<MutableList<Int>> = LinkedList()
        if (nums.isEmpty()) {
            return results
        }
        nums.sort()
        val subSet: MutableList<Int> = LinkedList()
        dfs(nums, 0, subSet, results)
        return results
    }

    private fun dfs(
        nums: IntArray,
        startIndex: Int,
        subSet: MutableList<Int>,
        results: MutableList<MutableList<Int>>
    ) {
        results.add(ArrayList(subSet))
        for (i in startIndex until nums.size) {
            if (i != 0 && i > startIndex && nums[i] == nums[i - 1]) {
                continue
            }
            subSet.add(nums[i])
            dfs(nums, i + 1, subSet, results)
            subSet.removeAt(subSet.size - 1)
        }
    }
}

fun main() {
    val solution = SubsetsIIKotlin90()
    val r = solution.subsetsWithDup(intArrayOf(1, 2, 2))
    println(r)
}