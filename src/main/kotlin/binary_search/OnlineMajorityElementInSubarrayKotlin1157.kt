package binary_search

import kotlin.random.Random

class OnlineMajorityElementInSubarrayKotlin1157(val arr: IntArray) {

    private val map: MutableMap<Int, MutableList<Int>> = HashMap()

    init {
        arr.forEachIndexed { index, i ->
            map.computeIfAbsent(i) { ArrayList() }.add(index)
        }
    }

    fun query(left: Int, right: Int, threshold: Int): Int {
        for (time in 1..7) {
            val random = arr[Random.Default.nextInt(left, right + 1)]
            val list = map[random]!!
            val leftIndex = firstGreaterEqualThanTarget(list, left)
            val rightIndex = lastLessEqualThanTarget(list, right)
            if (rightIndex - leftIndex + 1 >= threshold) {
                return random
            }
        }
        return -1
    }

    private fun firstGreaterEqualThanTarget(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                list[mid] < target -> left = mid
                else -> right = mid
            }
        }
        return when {
            list[left] >= target -> left
            list[right] >= target -> right
            else -> -1
        }
    }

    private fun lastLessEqualThanTarget(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                list[mid] <= target -> left = mid
                else -> right = mid
            }
        }
        return when {
            list[right] <= target -> right
            list[left] <= target -> left
            else -> -1
        }
    }

    /*
    // Boyer–Moore majority vote algorithm
    fun query(left: Int, right: Int, threshold: Int): Int {
        var major = -1
        var count = 0
        for (index in left..right) {
            if (count == 0) {
                major = arr[index]
                ++count
            } else {
                count += if (arr[index] == major) 1 else -1
            }
        }
        count = 0
        for (index in left..right) {
            if (arr[index] == major) {
                ++count
            }
        }
        return if (count >= threshold) major else -1
    }
     */
}