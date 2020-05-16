package binary_search

class CountofSmallerNumbersAfterSelfKotlin315 {
    fun countSmaller(nums: IntArray): List<Int> {
        if (nums.isEmpty()) {
            return emptyList()
        }
        val result = IntArray(nums.size)
        result[result.size - 1] = 0
        val sortedList = ArrayList<Int>()
        sortedList.add(nums[nums.size - 1])
        for (index in nums.size - 2 downTo 0) {
            val position = searchInsert(sortedList, nums[index])
            sortedList.add(position, nums[index])
            result[index] = position
        }
        return result.toList()
    }

    fun searchInsert(nums: List<Int>, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        if (right == 0) {
            return when {
                target <= nums[0] -> 0
                else -> 1
            }
        }
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> left = mid
                nums[mid] >= target -> right = mid
            }
        }
        return when {
            target <= nums[left] -> left
            target <= nums[right] -> right
            else -> right + 1
        }
    }
}

fun main() {
    val soluton = CountofSmallerNumbersAfterSelfKotlin315()
    println(soluton.countSmaller(intArrayOf(5, 2, 6, 1)))
    println(
        soluton.countSmaller(
            intArrayOf(
                -3,
                -1,
                -3,
                -3,
                -5
            )
        )
    )
}