package string_integer

import kotlin.math.abs

class ThreeSumClosestKotlin16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var diff = Int.MAX_VALUE
        if (nums.isEmpty()) {
            return 0
        }
        nums.sort()
        for (i in 0..nums.size - 3) {
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                val current = abs(target - sum)
                when {
                    current == 0 -> return sum
                    current < abs(diff) -> diff = target - sum
                }
                when {
                    sum < target -> ++j
                    else -> --k
                }
            }
        }
        // sum = 6 target = 2 diff =4
        return target - diff
    }
}

fun main() {
    val solution = ThreeSumClosestKotlin16()
    // 2
    println(solution.threeSumClosest(intArrayOf(-1, 2, 1, -4), 2))
}