package binarysearch

class FindtheSmallestDivisorGivenaThresholdKotlin1283 {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var left = 1
        var right = nums.max()!!
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val sumMid = calculateSum(nums, mid)
            when {
                sumMid > threshold -> left = mid
                else -> right = mid
            }
        }
        return when {
            calculateSum(nums, left) > threshold -> right
            else -> left
        }
    }

    private fun calculateSum(nums: IntArray, target: Int): Int =
        nums.fold(0) { acc, i -> acc + i / target + if (i % target == 0) 0 else 1 }
}