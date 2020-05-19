package binary_search

class CountofRangeSumKotlin327 {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val sums = LongArray(nums.size + 1)
        for (index in nums.indices) {
            sums[index + 1] = sums[index] + nums[index]
        }
        val temps = LongArray(sums.size)
        return mergeSort(sums, temps, 0, sums.size - 1, lower, upper)
    }

    private fun mergeSort(
        sums: LongArray,
        temps: LongArray,
        start: Int,
        end: Int,
        lower: Int,
        upper: Int
    ): Int {
        if (start >= end) {
            return 0
        }
        val mid = start + (end - start).shr(1)
        val leftCount = mergeSort(sums, temps, start, mid, lower, upper)
        val rightCount = mergeSort(sums, temps, mid + 1, end, lower, upper)
        return leftCount + rightCount + merge(sums, temps, start, end, lower, upper)
    }

    private fun merge(
        sums: LongArray,
        temps: LongArray,
        start: Int,
        end: Int,
        lower: Int,
        upper: Int
    ): Int {
        val mid = start + (end - start).shr(1)
        var left = start
        var right = mid + 1
        var tempsIndex = start
        var count = 0
        for (index in left..mid) {
            val min = searchFirstPositionGreaterThan(sums, sums[index] + lower, mid + 1, end)
            val max = searchLastPositionLessThan(sums, sums[index] + upper, mid + 1, end)
            if (min != -1 && max != -1) {
                count += max + 1 - min
            }
        }
        while (left <= mid && right <= end) {
            when {
                sums[left] <= sums[right] -> temps[tempsIndex++] = sums[left++]
                else -> temps[tempsIndex++] = sums[right++]
            }
        }
        while (left <= mid) {
            temps[tempsIndex++] = sums[left++]
        }
        while (right <= end) {
            temps[tempsIndex++] = sums[right++]
        }
        for (index in start..end) {
            sums[index] = temps[index]
        }
        return count
    }

    private fun searchFirstPositionGreaterThan(nums: LongArray, target: Long, start: Int, end: Int): Int {
        var left = start
        var right = end
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> left = mid
                nums[mid] >= target -> right = mid
            }
        }
        return when {
            nums[left] >= target -> left
            nums[right] >= target -> right
            else -> -1
        }
    }

    private fun searchLastPositionLessThan(nums: LongArray, target: Long, start: Int, end: Int): Int {
        var left = start
        var right = end
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] <= target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when {
            nums[right] <= target -> right
            nums[left] <= target -> left
            else -> -1
        }
    }

    /*
    S ( n )
    O ( n * log(n) )
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val sums = mutableListOf<Long>()
        sums.add(0)
        var count = 0
        var currentSum: Long = 0
        nums.forEach {
            currentSum += it
            val min = searchFirstPositionGreaterThan(sums, currentSum - upper)
            val max = searchLastPositionLessThan(sums, currentSum - lower)
            if (min != -1 && max != -1) {
                count += max + 1 - min
            }
            sums.add(searchInsert(sums, currentSum), currentSum)
        }
        return count
    }

    private fun searchInsert(nums: List<Long>, target: Long): Int {
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

    private fun searchFirstPositionGreaterThan(nums: List<Long>, target: Long): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> left = mid
                nums[mid] >= target -> right = mid
            }
        }
        return when {
            nums[left] >= target -> left
            nums[right] >= target -> right
            else -> -1
        }
    }

    private fun searchLastPositionLessThan(nums: List<Long>, target: Long): Int {
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
            nums[right] <= target -> right
            nums[left] <= target -> left
            else -> -1
        }
    }
     */
    /*
    S ( n )
    O ( n * n )
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val sums = LongArray(nums.size + 1)
        for (index in nums.indices) {
            sums[index + 1] = sums[index] + nums[index]
        }
        var count = 0
        for (i in nums.indices) {
            for (j in i + 1 until sums.size) {
                val sumOfJtoI = sums[j] - sums[i]
                if (sumOfJtoI in lower..upper) {
                    ++count
                }
            }
        }
        return count
    }
     */
}

fun main() {
    val solution = CountofRangeSumKotlin327()
    println(solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
    println(solution.countRangeSum(intArrayOf(0), 0, 0))
    println(solution.countRangeSum(intArrayOf(0, 1), 0, 0))
}