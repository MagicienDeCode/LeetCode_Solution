package binary_search

class PreimageSizeofFactorialZeroesFunctionKotlin793 {
    fun preimageSizeFZF(K: Int): Int {
        var left = 0L
        var right: Long = (K + 1) * 5L
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val numberOfZero = numberOfZero(mid)
            when {
                numberOfZero == K -> return 5
                numberOfZero < K -> left = mid
                else -> right = mid
            }
        }
        return when (K) {
            numberOfZero(left) -> 5
            numberOfZero(right) -> 5
            else -> 0
        }
    }

    private fun numberOfZero(long: Long): Int {
        var count = 0L
        var current = long
        while (current != 0L) {
            count += current / 5
            current /= 5
        }
        return count.toInt()
    }
}
