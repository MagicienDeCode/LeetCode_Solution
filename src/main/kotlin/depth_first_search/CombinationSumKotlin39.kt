package depth_first_search

import java.util.*

class CombinationSumKotlin39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = LinkedList()
        val subsets: MutableList<Int> = LinkedList()
        dfs(candidates, 0, target, subsets, results)
        return results
    }

    private fun dfs(candidates: IntArray, start: Int, target: Int, subsets: MutableList<Int>, results: MutableList<List<Int>>) {
        if (target == 0) {
            results.add(ArrayList(subsets))
            return
        }
        if (target < 0) {
            return
        }
        for (i in start until candidates.size) {
            subsets.add(candidates[i])
            dfs(candidates, i, target - candidates[i], subsets, results)
            subsets.removeAt(subsets.size - 1)
        }
    }
}