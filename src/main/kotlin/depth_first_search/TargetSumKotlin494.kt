package depth_first_search

class TargetSumKotlin494 {
    // Time Limit Exceeded
    fun findTargetSumWays(nums: IntArray, sum: Int): Int =
            nums.map { listOf(it, -it) }.reduce { acc, list ->
                acc.flatMap { accItem -> list.map { listItem -> accItem + listItem } }
            }.count { it == sum }
}