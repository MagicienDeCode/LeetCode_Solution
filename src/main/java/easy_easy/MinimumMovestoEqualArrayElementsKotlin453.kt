package easy_easy

class MinimumMovestoEqualArrayElementsKotlin453 {
    fun minMoves(nums: IntArray): Int {
        val min = nums.min()!!
        return nums.map { it - min }.sum()
    }
}