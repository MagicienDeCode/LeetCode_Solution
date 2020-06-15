package binary_search

import kotlin.random.Random

class RandomPickwithBlacklistKotlin710(
    private val N: Int,
    private val blacklist: IntArray
) {
    init {
        blacklist.sort()
    }

    fun pick(): Int {
        if (blacklist.isEmpty()) {
            return Random.Default.nextInt(N)
        }
        val random = Random.Default.nextInt(N - blacklist.size)
        var left = 0
        var right = blacklist.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                random + mid < blacklist[mid] -> right = mid
                else -> left = mid
            }
        }
        return when {
            left + random < blacklist[left] -> left + random
            right + random < blacklist[right] -> right + random
            else -> random + right + 1
        }
    }

    /*
    val map: MutableMap<Int, Int> = HashMap()

    init {
        blacklist.sort()
        var current = N - 1
        blacklist
            .filter { it < N - blacklist.size }
            .forEach {
                while (binarySearch(current)) {
                    --current
                }
                map[it] = current--
            }
    }

    fun pick(): Int {
        val random = Random.Default.nextInt(N - blacklist.size)
        return map.getOrDefault(random, random)
    }

    private fun binarySearch(target: Int): Boolean {
        if (blacklist.isEmpty()) {
            return false
        }
        var left = 0
        var right = blacklist.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                blacklist[mid] == target -> return true
                blacklist[mid] < target -> left = mid
                else -> right = mid
            }
        }
        return when (target) {
            blacklist[left] -> true
            blacklist[right] -> true
            else -> false
        }
    }
     */
}