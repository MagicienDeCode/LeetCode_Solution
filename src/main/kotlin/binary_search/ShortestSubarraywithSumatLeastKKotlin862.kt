package binary_search

import java.util.*

class ShortestSubarraywithSumatLeastKKotlin862 {
    /*
    Time Limit Exceed
    fun shortestSubarray(A: IntArray, K: Int): Int {
        val sums = IntArray(A.size + 1)
        for (index in 1 until sums.size) {
            sums[index] = sums[index - 1] + A[index - 1]
        }
        for (length in 1..A.size) {
            if (isValid(sums, K, length)) {
                return length
            }
        }
        return -1
    }

    private fun isValid(sums: IntArray, K: Int, length: Int): Boolean {
        for (i in 0 until sums.size - length) {
            if (sums[i + length] - sums[i] >= K) {
                return true
            }
        }
        return false
    }
     */

    fun shortestSubarray(A: IntArray, K: Int): Int {
        var result = Int.MAX_VALUE
        val sums = IntArray(A.size + 1)
        for (index in 1 until sums.size) {
            sums[index] = sums[index - 1] + A[index - 1]
        }
        val deque: Deque<Int> = LinkedList()
        deque.offer(0)
        for (index in 1 until sums.size) {
            while (deque.isNotEmpty() && sums[index] - sums[deque.first] >= K) {
                result = minOf(result, index - deque.pollFirst())
            }
            while (deque.isNotEmpty() && sums[index] <= sums[deque.last]) {
                deque.pollLast()
            }
            deque.offer(index)
        }
        return when (result) {
            Int.MAX_VALUE -> -1
            else -> result
        }
    }

    /*
    fun shortestSubarray(A: IntArray, K: Int): Int {
        var result = Int.MAX_VALUE
        val sums = IntArray(A.size + 1)
        for (index in 1 until sums.size) {
            sums[index] = sums[index - 1] + A[index - 1]
        }
        // (sums,index)
        val sortedList: MutableList<Pair<Int, Int>> = ArrayList()
        sortedList.add(Pair(0, 0))
        for (index in 1 until sums.size) {
            val position = findLast(sortedList, sums[index] - K)
            if (position != -1) {
                for (p in 0..position) {
                    result = minOf(result, index - sortedList[p].second)
                }
                for (p in 0 until position) {
                    sortedList.removeAt(0)
                }
            }
            val insertPosition = insertPosition(sortedList, sums[index])
            sortedList.add(insertPosition, Pair(sums[index], index))
        }
        return when (result) {
            Int.MAX_VALUE -> -1
            else -> result
        }
    }

    // binary search last element.first <= target , return position
    private fun findLast(sortedList: List<Pair<Int, Int>>, target: Int): Int {
        var left = 0
        var right = sortedList.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                sortedList[mid].first <= target -> left = mid
                else -> right = mid
            }
        }
        return when {
            sortedList[right].first <= target -> right
            sortedList[left].first <= target -> left
            else -> -1
        }
    }

    // binary search insert position
    private fun insertPosition(sortedList: List<Pair<Int, Int>>, target: Int): Int {
        var left = 0
        var right = sortedList.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                sortedList[mid].first <= target -> left = mid
                else -> right = mid
            }
        }
        return when {
            sortedList[left].first >= target -> left
            sortedList[right].first >= target -> right
            else -> right + 1
        }
    }
     */
}

fun main() {
    val solution = ShortestSubarraywithSumatLeastKKotlin862()
    // 1
    println(solution.shortestSubarray(intArrayOf(44, -25, 75, -50, -38, -42, -32, -6, -40, -47), 19))
    // 2    3   1   -1
    println(solution.shortestSubarray(intArrayOf(56, -21, 56, 35, -9), 61))
    println(solution.shortestSubarray(intArrayOf(2, -1, 2), 3))
    println(solution.shortestSubarray(intArrayOf(1), 1))
    println(solution.shortestSubarray(intArrayOf(1, 2), 4))
}