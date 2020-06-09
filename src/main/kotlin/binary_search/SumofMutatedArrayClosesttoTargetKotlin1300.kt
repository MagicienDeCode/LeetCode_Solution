package binary_search

class SumofMutatedArrayClosesttoTargetKotlin1300 {
    // wrong with valid testcase[2,3,5] target = 11 expected = 5 buy my code return 11
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

fun main() {
    val solution = SumofMutatedArrayClosesttoTargetKotlin1300()
    // 11 but should be 5
    println(solution.findBestValue(intArrayOf(2,3,5),11))
    // 3
    println(solution.findBestValue(intArrayOf(4,3,9),10))
    // 5
    println(solution.findBestValue(intArrayOf(2,3,5),10))
}