package binary_search

class MinimumNumberofDaystoMakemBouquetsKotlin1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        var left = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        bloomDay.forEach {
            left = minOf(left, it)
            right = maxOf(right, it)
        }
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            if (isValid(bloomDay, m, k, mid)) {
                right = mid
            } else {
                left = mid
            }
        }
        return when {
            isValid(bloomDay, m, k, left) -> left
            isValid(bloomDay, m, k, right) -> right
            else -> -1
        }
    }

    private fun isValid(bloomDay: IntArray, m: Int, k: Int, target: Int): Boolean {
        var total = 0
        var current = 0
        bloomDay.forEach {
            if (target >= it) {
                ++current
                if (current == k) {
                    ++total
                    current = 0
                }
            } else {
                current = 0
            }
        }
        return total >= m
    }
}

fun main() {
    val solution = MinimumNumberofDaystoMakemBouquetsKotlin1482()
    // 3
    println(solution.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1))
    // -1
    println(solution.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2))
    // 12
    println(solution.minDays(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3))
    // 9
    println(solution.minDays(intArrayOf(1, 10, 2, 9, 3, 8, 4, 7, 5, 6), 4, 2))
    // 1000
    println(solution.minDays(intArrayOf(1000, 1000), 1, 1))
}