package depth_first_search

import java.util.*

class NumbersWithSameConsecutiveDifferencesKotlin967 {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        if (n == 1) {
            return intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
        var queue = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (level in 1 until n) {
            val nextLevel: MutableList<Int> = ArrayList()
            for (i in queue) {
                val remainder = i % 10
                val next = remainder + k
                val previous = remainder - k
                val newBase = i * 10
                if (next <= 9) {
                    nextLevel.add(newBase + next)
                }
                if (previous >= 0 && previous != next) {
                    nextLevel.add(newBase + previous)
                }
            }
            queue = nextLevel
        }
        return queue.toIntArray()
    }
    /*
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        if (n == 1) {
            return intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
        val results: MutableList<Int> = ArrayList()
        for (i in 1..9) {
            dfs(n - 1, i, k, results)
        }
        return results.toIntArray()
    }

    private fun dfs(n: Int, i: Int, k: Int, results: MutableList<Int>) {
        if (n == 0) {
            results.add(i)
            return
        }
        val remainder = i % 10
        val next = remainder + k
        val previous = remainder - k
        val newBase = i * 10
        if (next <= 9) {
            dfs(n - 1, newBase + next, k, results)
        }
        if (previous >= 0 && previous != next) {
            dfs(n - 1, newBase + previous, k, results)
        }
    }
     */
}