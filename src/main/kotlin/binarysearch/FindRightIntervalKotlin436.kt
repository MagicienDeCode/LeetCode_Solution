package binarysearch

class FindRightIntervalKotlin436 {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        // O(n) find the smallest start point and the max of end point
        intervals.forEach {
            max = maxOf(max, it[it.size - 1])
            min = minOf(min, it[0])
        }
        // S(max-min+1)
        val rangeArrayOfIndex = IntArray(max - min + 1) { -1 }
        // O(n)
        intervals.forEachIndexed { index, ints ->
            rangeArrayOfIndex[ints[0] - min] = index
        }
        // O(max-min) to fill the range with index
        for (index in rangeArrayOfIndex.size - 2 downTo 0) {
            if (rangeArrayOfIndex[index] == -1) {
                rangeArrayOfIndex[index] = rangeArrayOfIndex[index + 1]
            }
        }
        // O(n)
        return intervals.map { rangeArrayOfIndex[it[it.size - 1] - min] }.toIntArray()
    }
    /*
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val listOfPairIndexAndStart =
            intervals.mapIndexed { index, ints -> Pair(index, ints[0]) }.sortedBy { it.second }
        return intervals.map { search(listOfPairIndexAndStart, it[it.size - 1]) }.toIntArray()
    }
     */
    /*
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        // S(n) first is index, seconed is the START ELEMENT
        val pairIndexAndStartList = mutableListOf<Pair<Int, Int>>()
        // O(n)
        intervals.forEachIndexed { index, ints -> pairIndexAndStartList.add(Pair(index, ints[0])) }
        // O( nlog(n) )
        pairIndexAndStartList.sortBy { it.second }
        // O( nlog(n) )
        return intervals.map { search(pairIndexAndStartList, it[it.size - 1]) }.toIntArray()
    }


    fun search(nums: List<Pair<Int, Int>>, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid].second == target -> return nums[mid].first
                nums[mid].second < target -> left = mid
                nums[mid].second > target -> right = mid
            }
        }
        return when {
            nums[left].second >= target -> nums[left].first
            nums[right].second >= target -> nums[right].first
            else -> -1
        }
    }
     */
    /*
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        return intervals.map { ints ->
            var result = -1
            var minStartAndCurrentEnd = Int.MAX_VALUE
            intervals.forEachIndexed { index2, ints2 ->
                val diff = ints2[0] - ints[ints.size - 1]
                if (diff in 0 until minStartAndCurrentEnd) {
                    minStartAndCurrentEnd = diff
                    result = index2
                }
            }
            result
        }.toIntArray()
    }
     */
}

fun main() {
    val solution = FindRightIntervalKotlin436()
    solution.findRightInterval(arrayOf(intArrayOf(3, 4), intArrayOf(2, 3), intArrayOf(1, 2))).forEach(::println)
}