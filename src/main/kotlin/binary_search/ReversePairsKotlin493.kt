package binary_search

class ReversePairsKotlin493 {
    fun reversePairs(nums: IntArray): Int {
        val temp = IntArray(nums.size)
        return mergeSort(nums, temp, 0, nums.size - 1)
    }

    private fun mergeSort(nums: IntArray, temps: IntArray, start: Int, end: Int): Int {
        if (start >= end) {
            return 0
        }
        // val mid = start + (end - start) / 2
        val mid = start + (end - start).shr(1)
        val leftCount = mergeSort(nums, temps, start, mid)
        val rightCount = mergeSort(nums, temps, mid + 1, end)
        return leftCount + rightCount + merge(nums, temps, start, end)
    }

    private fun merge(nums: IntArray, temps: IntArray, start: Int, end: Int): Int {
        val mid = start + (end - start).shr(1)
        var left = start
        var right = mid + 1
        var tempsIndex = start
        var count = 0
        for (index in start..mid) {
            val position = binarySearchTargetGreaterThanTwoTimesLastPosition(nums, nums[index], mid + 1, end)
            if (position != -1) {
                count += position
            }
        }
        while (left <= mid && right <= end) {
            when {
                nums[left] <= nums[right] -> temps[tempsIndex++] = nums[left++]
                else -> temps[tempsIndex++] = nums[right++]
            }
        }
        while (left <= mid) {
            temps[tempsIndex++] = nums[left++]
        }
        while (right <= end) {
            temps[tempsIndex++] = nums[right++]
        }
        for (index in start..end) {
            nums[index] = temps[index]
        }
        return count
    }

    private fun binarySearchTargetGreaterThanTwoTimesLastPosition(
        intArray: IntArray,
        target: Int,
        start: Int,
        end: Int
    ): Int {
        var left = start
        var right = end
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                target > intArray[mid].toLong().times(2) -> left = mid
                else -> right = mid
            }
        }
        return when {
            target > intArray[right].toLong().times(2) -> right + 1 - start
            target > intArray[left].toLong().times(2) -> left + 1 - start
            else -> -1
        }
    }
    /*
    fun reversePairs(nums: IntArray): Int {
        var count = 0
        val sortedList: MutableList<Int> = ArrayList()
        for (index in nums.size - 1 downTo 0) {
            val position = binarySearchTargetGreaterThanTwoTimesLastPosition(sortedList, nums[index])
            if (position != -1) {
                count += position
            }
            sortedList.add(searchInsertPosition(sortedList, nums[index]), nums[index])
        }
        return count
    }

    private fun searchInsertPosition(nums: List<Int>, target: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] <= target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when {
            target <= nums[left] -> left
            target <= nums[right] -> right
            else -> right + 1
        }
    }

    private fun binarySearchTargetGreaterThanTwoTimesLastPosition(sortedList: List<Int>, target: Int): Int {
        if (sortedList.isEmpty()) {
            return -1
        }
        var left = 0
        var right = sortedList.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                target > sortedList[mid].toLong().times(2) -> left = mid
                else -> right = mid
            }
        }
        return when {
            target > sortedList[right].toLong().times(2) -> right + 1
            target > sortedList[left].toLong().times(2) -> left + 1
            else -> -1
        }
    }
     */
    /*
    Time Limit Exceeded
    fun reversePairs(nums: IntArray): Int {
        var count = 0
        for (i in 0..nums.size - 2) {
            for (j in i + 1 until nums.size) {
                if (nums[i] - nums[j] > nums[j]) {
                    ++count
                }
                /*
                if (nums[i].toLong() > 2L * nums[j]) {
                    ++count
                }
                 */
            }
        }
        return count
    }
     */
}

fun main() {
    val solution = ReversePairsKotlin493()
    // 4
    println(solution.reversePairs(intArrayOf(5, 4, 3, 2, 1)))
    // 2
    println(solution.reversePairs(intArrayOf(1, 3, 2, 3, 1)))
    // 3
    println(solution.reversePairs(intArrayOf(2, 4, 3, 5, 1)))
    // 0
    println(solution.reversePairs(intArrayOf(2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647)))
}