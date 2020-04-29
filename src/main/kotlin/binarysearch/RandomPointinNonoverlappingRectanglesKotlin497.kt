package binarysearch

import kotlin.random.Random

class RandomPointinNonoverlappingRectanglesKotlin497(rects: Array<IntArray>) {
    private val accumulateSum: IntArray = IntArray(rects.size)
    private val rects: Array<IntArray> = rects

    init {
        accumulateSum[0] = calculateSum(rects[0])
        for (index in 1 until rects.size) {
            accumulateSum[index] = accumulateSum[index - 1] + calculateSum(rects[index])
        }
    }

    private fun calculateSum(ints: IntArray): Int {
        val x1 = ints[0]
        val y1 = ints[1]
        val x2 = ints[2]
        val y2 = ints[3]
        return (x2 - x1 + 1) * (y2 - y1 + 1)
    }

    fun pick(): IntArray {
        val rect = rects[binarySearch()]
        val x = rect[0] + Random.Default.nextInt(rect[2] - rect[0] + 1)
        val y = rect[1] + Random.Default.nextInt(rect[3] - rect[1] + 1)
        return intArrayOf(x, y)
    }

    private fun binarySearch(): Int {
        val target = Random.Default.nextInt(accumulateSum[accumulateSum.size - 1]) + 1
        var left = 0
        var right = accumulateSum.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                accumulateSum[mid] == target -> return mid
                accumulateSum[mid] < target -> left = mid
                accumulateSum[mid] > target -> right = mid
            }
        }
        return when {
            accumulateSum[left] >= target -> left
            accumulateSum[right] >= target -> right
            else -> -1
        }
    }
}