package binary_search

import kotlin.math.log2

class SmallestGoodBaseKotlin483 {
    fun smallestGoodBase(n: String): String {
        val minK = 2
        val maxK = log2(n.toDouble()).toInt() + 1
        val nLong = n.toLong()
        for (k in maxK downTo minK) {
            val base = binarySearchBase(nLong, k)
            if (base != -1L) {
                return base.toString()
            }
        }
        return (nLong - 1).toString()
    }

    // 0 OK || -1 smaller  || 1 greater than n
    private fun isValidBase(n: Long, countOfBase: Int, base: Long): Int {
        var current: Long = 0
        for (times in 0..countOfBase) {
            if ((Long.MAX_VALUE - 1) / base < current) {
                return 1
            }
            current = current * base + 1
        }
        return when {
            current == n -> 0
            current > n -> 1
            else -> -1
        }
    }

    private fun binarySearchBase(n: Long, countOfBase: Int): Long {
        var left = 2L
        // var right = n.toDouble().pow(1 / (countOfBase - 1).toDouble()).toLong()
        var right = n
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when (isValidBase(n, countOfBase, mid)) {
                0 -> return mid
                -1 -> left = mid
                else -> right = mid
            }
        }
        return when {
            isValidBase(n, countOfBase, left) == 0 -> left
            isValidBase(n, countOfBase, right) == 0 -> right
            else -> -1
        }
    }
/*
// Time Limit Exceeded
fun smallestGoodBase(n: String): String {
    val nLong = n.toLong()
    for (index in 2L until nLong) {
        if (checkGoodBase(nLong, index)) {
            return index.toString()
        }
    }
    return (nLong - 1).toString()
}

private fun checkGoodBase(n: Long, base: Long): Boolean {
    var current: Long = 1
    while (current < n) {
        current = current * base + 1
    }
    return current == n
}
 */
}

fun main() {
    // 4
    println(log2(15.toDouble()).toInt() + 1)
    // 52
    println(log2("2251799813685247".toDouble()).toInt() + 1)
    val solution = SmallestGoodBaseKotlin483()
    // 3
    println(solution.smallestGoodBase("13"))
    // 2
    println(solution.smallestGoodBase("2251799813685247"))
}