package binary_search

class KokoEatingBananasKotlin875 {
    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var left = 1
        var right = 1000000000
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                isValidTarget(piles, H, mid) -> right = mid
                else -> left = mid
            }
        }
        return when {
            isValidTarget(piles, H, left) -> left
            else -> right
        }
    }

    private fun isValidTarget(piles: IntArray, H: Int, target: Int): Boolean {
        return piles.fold(0) { acc: Int, i: Int ->
            acc + i / target + if (i % target == 0) 0 else 1
        } <= H
    }
}