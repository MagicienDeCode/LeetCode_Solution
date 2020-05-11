package binary_search

import java.util.*
import kotlin.Comparator

class KthSmallestElementinaSortedMatrixKotlin378 {

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        // val descComparator = Comparator<Int> { p0, p1 -> (p1.compareTo(p0)) }
        val result: Queue<Int> = PriorityQueue(Comparator.reverseOrder())
        matrix.forEachIndexed { index, ints ->
            if (index < k) {
                ints.forEach {
                    result.offer(it)
                    if (result.size > k) {
                        result.poll()
                    }
                }
            }
        }
        return result.poll()
    }
    /*
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return 0
        }
        var left = matrix[0][0]
        var right = matrix[matrix.size - 1][matrix[0].size - 1]
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            val count = countNotGreatThanTarget(matrix, mid)
            when {
                count < k -> left = mid
                count >= k -> right = mid
            }
        }
        return when {
            countNotGreatThanTarget(matrix, left) >= k -> left
            countNotGreatThanTarget(matrix, right) >= k -> right
            else -> -1
        }
    }

    private fun countNotGreatThanTarget(matrix: Array<IntArray>, target: Int): Int =
        matrix.fold(0) { acc, ints ->
            acc + searchLastNotGreatThanTarget(ints, target)
        }

    private fun searchLastNotGreatThanTarget(nums: IntArray, target: Int): Int {
        if (nums[nums.size - 1] <= target) {
            return nums.size
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] <= target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when {
            nums[right] <= target -> right + 1
            nums[left] <= target -> right
            else -> 0
        }
    }
     */
}