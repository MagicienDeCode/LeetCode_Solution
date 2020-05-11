package binary_search

class HeatersKotlin475 {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        // nlog(n)
        heaters.sort()
        // mlog(n)
        return houses.fold(0) { acc: Int, i: Int -> maxOf(acc, searchMinDistance(heaters, i)) }
    }

    fun searchMinDistance(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (target <= nums[0]) {
            return nums[0] - target
        }
        if (target >= nums[nums.size - 1]) {
            return target - nums[nums.size - 1]
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return 0
                nums[mid] < target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return minOf(target - nums[left], nums[right] - target)
    }
}

fun main() {
    val solution = HeatersKotlin475()
    println(solution.findRadius(intArrayOf(1, 2, 3, 4), intArrayOf(1, 4)))
    println(solution.findRadius(intArrayOf(1, 2, 3, 4), intArrayOf(100, 400)))
}