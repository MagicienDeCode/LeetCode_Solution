package binary_search

class SumofMutatedArrayClosesttoTargetKotlin1300 {
    fun findBestValue(arr: IntArray, target: Int): Int {
        var left = 0
        var right = target
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val sumWithMid = sum(arr, mid)
            when {
                sumWithMid == target -> return mid
                sumWithMid < target -> left = mid
                else -> right = mid
            }
        }
        return when {
            sum(arr, right) - target < target - sum(arr, left) -> right
            else -> left
        }
    }

    private fun sum(arr: IntArray, aim: Int): Int {
        var sum = 0
        for (i in arr) {
            sum += minOf(i, aim)
        }
        return sum
    }
}