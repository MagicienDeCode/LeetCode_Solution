package binary_search

class FindKthSmallestPairDistanceKotlin719 {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = nums[nums.size - 1] - nums[0]
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val count = countLessThanTarget(nums, mid)
            when {
                count < k -> left = mid
                else -> right = mid
            }
        }
        if (countLessThanTarget(nums, left) >= k) {
            return left
        }
        return right
    }

    private fun countLessThanTarget(nums: IntArray, target: Int): Int {
        var count = 0
        var start = 0
        for (index in nums.indices) {
            while (start < nums.size && nums[index] - nums[start] > target) {
                ++start
            }
            count += index - start
        }
        return count
    }
    /*
    Memory Limit Exceeded
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        val queue: PriorityQueue<Int> = PriorityQueue(
            k,
            Comparator { i1: Int, i2: Int -> compareValues(i2, i1) })
        for (i in 0..nums.size - 2) {
            for (j in i + 1 until nums.size) {
                val distance = abs(nums[i] - nums[j])
                queue.offer(distance)
                if (queue.size > k) {
                    queue.poll()
                }
            }
        }
        return queue.poll()
    }
     */
}

fun main() {
    val solution = FindKthSmallestPairDistanceKotlin719()
    println(solution.smallestDistancePair(intArrayOf(2, 2, 0, 1, 1, 0, 0, 1, 2, 0), 1))
    println(solution.smallestDistancePair(intArrayOf(1, 3, 1), 1))
}