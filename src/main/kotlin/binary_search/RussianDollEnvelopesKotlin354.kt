package binary_search

class RussianDollEnvelopesKotlin354 {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) {
            return 0
        }
        envelopes.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
        val hListGroupByWandSortedByDescending = envelopes.map { it[1] }
        return longestIncreasingSubsequence(hListGroupByWandSortedByDescending)
    }

    private fun longestIncreasingSubsequence(array: List<Int>): Int {
        val result: MutableList<Int> = ArrayList()
        result.add(array[0])
        for (index in 1 until array.size) {
            when (val firstPosition = binarySearchFirstPositionGreaterEqualThanTarget(result, array[index])) {
                -1 -> result.add(array[index])
                else -> result[firstPosition] = array[index]
            }
        }
        return result.size
    }

    private fun binarySearchFirstPositionGreaterEqualThanTarget(array: List<Int>, target: Int): Int {
        var left = 0
        var right = array.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                array[mid] < target -> left = mid
                else -> right = mid
            }
        }
        return when {
            array[left] >= target -> left
            array[right] >= target -> right
            else -> -1
        }
    }
    /*
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) {
            return 0
        }
        // envelopes.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
        envelopes.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        var max = 1
        val dynamicProgramming = IntArray(envelopes.size) { 1 }
        for (i in 1 until envelopes.size) {
            for (j in envelopes.indices) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dynamicProgramming[i] = maxOf(dynamicProgramming[i], dynamicProgramming[j] + 1)
                    max = maxOf(max, dynamicProgramming[i])
                }
            }
        }

        return max
    }
     */
}

fun main() {
    val solution = RussianDollEnvelopesKotlin354()
    // 3
    println(
        solution.maxEnvelopes(
            arrayOf(
                intArrayOf(4, 8),
                intArrayOf(3, 7),
                intArrayOf(3, 4),
                intArrayOf(3, 5),
                intArrayOf(2, 1)
            )
        )
    )
    // 3
    println(
        solution.maxEnvelopes(
            arrayOf(
                intArrayOf(5, 4),
                intArrayOf(6, 4),
                intArrayOf(6, 7),
                intArrayOf(2, 3)
            )
        )
    )
    // 7
    println(
        solution.maxEnvelopes(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(3, 5),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7),
                intArrayOf(7, 8)
            )
        )
    )
}