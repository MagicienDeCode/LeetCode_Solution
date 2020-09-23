package depth_first_search

import java.util.*

class CombinationSumIIIKotlin216 {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = LinkedList()
        if (k == 0 || n == 0) {
            return results
        }
        val subsets: MutableList<Int> = LinkedList()
        dfs(k, n, 1, subsets, results)
        return results
    }

    private fun dfs(
        k: Int,
        remain: Int,
        start: Int,
        subsets: MutableList<Int>,
        results: MutableList<List<Int>>
    ) {
        if (remain == 0 && k == subsets.size) {
            results.add(ArrayList(subsets))
        }
        if (remain < 0 || k == subsets.size) {
            return
        }
        for (i in start..9) {
            subsets.add(i)
            dfs(k, remain - i, i + 1, subsets, results)
            subsets.removeAt(subsets.size - 1)
        }
    }
}