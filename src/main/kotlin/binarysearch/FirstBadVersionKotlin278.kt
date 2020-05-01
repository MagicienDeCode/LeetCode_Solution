package binarysearch

class FirstBadVersionKotlin278 {
    fun firstBadVersion(n: Int): Int {
        var left = 0
        var right = n
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                isBadVersion(mid) -> right = mid
                else -> left = mid
            }
        }
        return when {
            isBadVersion(left) -> left
            else -> right
        }
    }

    private fun isBadVersion(version: Int) = version > 3
}