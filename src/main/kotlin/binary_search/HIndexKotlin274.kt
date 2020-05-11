package binary_search

class HIndexKotlin274 {
    fun hIndex(citations: IntArray): Int {
        var left = 0
        var right = citations.size
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                isValidH(citations, mid) -> left = mid
                else -> right = mid
            }
        }
        return when {
            isValidH(citations, right) -> right
            isValidH(citations, left) -> left
            else -> -1
        }
    }

    private fun isValidH(citations: IntArray, target: Int): Boolean =
        citations.filter { it >= target }.size >= target
}