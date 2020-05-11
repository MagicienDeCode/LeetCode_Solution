package binary_search

class SqrtKotlin69 {
    fun mySqrt(x: Int): Int {
        var left = 0
        //  sqrt (Int.MAX_VALUE) = 46340.95
        var right = 46340
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                mid * mid == x -> return mid
                mid * mid < x -> left = mid
                mid * mid > x -> right = mid
            }
        }
        return when {
            right * right <= x -> right
            else -> left
        }
    }
}