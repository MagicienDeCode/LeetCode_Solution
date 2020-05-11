package binary_search

class GuessNumberHigherorLowerKotlin374 {

    fun guessNumber(n: Int): Int {
        var left = 0
        var right = n
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                guess(mid) == 0 -> return mid
                guess(mid) <= 0 -> left = mid
                guess(mid) >= 0 -> right = mid
            }
        }
        return when {
            guess(left) == 0 -> left
            guess(right) == 0 -> right
            else -> -1
        }
    }

    private fun guess(num: Int) = compareValues(num, 6)
}