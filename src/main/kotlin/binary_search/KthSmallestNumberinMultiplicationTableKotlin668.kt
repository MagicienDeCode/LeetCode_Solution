package binary_search

class KthSmallestNumberinMultiplicationTableKotlin668 {
    fun findKthNumber(m: Int, n: Int, k: Int): Int {
        var left = 1
        var right = n * m
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                countOfLessEqualThanTarget(m, n, mid) < k -> left = mid
                else -> right = mid
            }
        }
        return when {
            countOfLessEqualThanTarget(m, n, left) >= k -> left
            else -> right
        }
    }

    private fun countOfLessEqualThanTarget(m: Int, n: Int, target: Int): Int {
        var count = 0
        for (index in 1..m) {
            count += when {
                index * n <= target -> n
                else -> target / index
            }
        }
        return count
    }
    /*
    private fun countOfLessEqualThanTarget(m: Int, n: Int, target: Int): Int {
        var count = 0
        for (index in 1..m) {
            if (index <= target) {
                count += binarySearchLessEqualThanTarget(index, n, target)
            }
        }
        return count
    }

    private fun binarySearchLessEqualThanTarget(line: Int, n: Int, target: Int): Int {
        var left = 1
        var right = n
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                mid * line <= target -> left = mid
                else -> right = mid
            }
        }
        return when {
            right * line <= target -> right
            else -> left
        }
    }
     */
}

fun main() {
    val solution = KthSmallestNumberinMultiplicationTableKotlin668()
    // 126
    println(solution.findKthNumber(42, 34, 401))
    // 3
    println(solution.findKthNumber(3, 3, 5))
    // 6
    println(solution.findKthNumber(2, 3, 6))
}
