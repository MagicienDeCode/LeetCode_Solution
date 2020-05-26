package binary_search

import java.util.*
import kotlin.collections.ArrayList

class MaxSumofRectangleNoLargerThanKKotlin363 {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        var max = Int.MIN_VALUE
        val rowSum = IntArray(matrix.size)
        val sortedSum: MutableList<Int> = ArrayList()
        for (col in matrix[0].indices) {
            Arrays.fill(rowSum, 0)
            for (currentCol in col downTo 0) {
                sortedSum.clear()
                sortedSum.add(0)
                var currentSum = 0
                for (row in matrix.indices) {
                    rowSum[row] += matrix[row][currentCol]
                    currentSum += rowSum[row]
                    binarySearchFirstElementGreaterEqualThanTarget(sortedSum, currentSum - k)?.let {
                        max = maxOf(max, currentSum - it)
                        if (max == k) {
                            return k
                        }
                    }
                    binarySearchInsertPosition(sortedSum, currentSum)?.let {
                        sortedSum.add(it, currentSum)
                    }
                }
            }
        }
        return max
    }

    private fun binarySearchInsertPosition(nums: List<Int>, target: Int): Int? {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                nums[mid] == target -> return null
                nums[mid] < target -> left = mid
                else -> right = mid
            }
        }
        return when {
            nums[left] == target || nums[right] == target -> null
            nums[left] > target -> left
            nums[right] > target -> right
            else -> right + 1
        }
    }

    private fun binarySearchFirstElementGreaterEqualThanTarget(nums: List<Int>, target: Int): Int? {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                nums[mid] < target -> left = mid
                else -> right = mid
            }
        }
        return when {
            nums[left] >= target -> nums[left]
            nums[right] >= target -> nums[right]
            else -> null
        }
    }
    /*
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        val dpMatrix = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
        for (i in 1..matrix.size) {
            for (j in 1..matrix[0].size) {
                dpMatrix[i][j] = matrix[i - 1][j - 1] +
                        dpMatrix[i - 1][j] +
                        dpMatrix[i][j - 1] -
                        dpMatrix[i - 1][j - 1]
            }
        }
        var count = Int.MIN_VALUE
        for (row in 1..matrix.size) {
            for (col in 1..matrix[0].size) {
                for (i in row until dpMatrix.size) {
                    for (j in col until dpMatrix[0].size) {
                        val currentSum = dpMatrix[i][j] -
                                dpMatrix[i - row][j] -
                                dpMatrix[i][j - col] +
                                dpMatrix[i - row][j - col]
                        if (currentSum <= k) {
                            count = maxOf(currentSum, count)
                        }
                    }
                }
            }
        }
        return count
    }
     */
}

fun main() {
    val solution = MaxSumofRectangleNoLargerThanKKotlin363()
    // 2
    println(solution.maxSumSubmatrix(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, 3)), 2))
    // 3
    println(solution.maxSumSubmatrix(arrayOf(intArrayOf(2, 2, -1)), 3))
    // 10
    println(
        solution.maxSumSubmatrix(
            arrayOf(
                intArrayOf(5, -4, -3, 4),
                intArrayOf(-3, -4, 4, 5),
                intArrayOf(5, 1, 5, -4)
            ), 10
        )
    )
    // -2
    println(
        solution.maxSumSubmatrix(
            arrayOf(
                intArrayOf(5, -4, -3, 4),
                intArrayOf(-3, -4, 4, 5),
                intArrayOf(5, 1, 5, -4)
            ), -2
        )
    )
}