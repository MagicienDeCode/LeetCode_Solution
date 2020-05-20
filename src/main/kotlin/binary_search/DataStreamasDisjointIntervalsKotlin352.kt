package binary_search

import java.util.*

class DataStreamasDisjointIntervalsKotlin352 {

    val intervalsTreeMap: TreeMap<Int, Int> = TreeMap()

    fun addNum(`val`: Int) {
        var key = `val`
        var value = `val`
        // last interval that [0] <= target
        val leftInterval = intervalsTreeMap.floorEntry(key)
        if (leftInterval != null) {
            if (leftInterval.value >= key) {
                return
            }
            if (leftInterval.value + 1 == key) {
                key = leftInterval.key
                intervalsTreeMap.remove(leftInterval.key)
            }
        }
        val rightInterval = intervalsTreeMap.ceilingEntry(value)
        if (rightInterval != null && rightInterval.key - 1 == value) {
            value = rightInterval.value
            intervalsTreeMap.remove(rightInterval.key)
        }
        intervalsTreeMap[key] = value
    }

    fun getIntervals(): Array<IntArray> {
        return intervalsTreeMap.map { intArrayOf(it.key, it.value) }.toTypedArray()
    }

    /*
    /** Initialize your data structure here. */

    // 524 ms
    val intervals: MutableList<IntArray> = ArrayList()
    // 752
    // val intervals: MutableList<IntArray> = LinkedList()

    fun addNum(`val`: Int) {
        when (intervals.size) {
            0 -> intervals.add(intArrayOf(`val`, `val`))
            1 -> {
                val firstInterval = intervals[0]
                when {
                    `val` + 1 < firstInterval[0] -> intervals.add(0, intArrayOf(`val`, `val`))
                    `val` + 1 == firstInterval[0] -> firstInterval[0] = `val`
                    firstInterval[1] + 1 == `val` -> firstInterval[1] = `val`
                    firstInterval[1] + 1 < `val` -> intervals.add(1, intArrayOf(`val`, `val`))
                }
            }
            else -> {
                val targetPosition = binarySearchLastPositionLessThanTarget(intervals, `val`)
                when {
                    targetPosition == 0 && `val` < intervals[0][0] -> {
                        when {
                            `val` + 1 < intervals[0][0] -> intervals.add(0, intArrayOf(`val`, `val`))
                            `val` + 1 == intervals[0][0] -> intervals[0][0] = `val`
                        }
                    }
                    targetPosition == intervals.size - 1 -> {
                        when {
                            intervals[intervals.size - 1][1] + 1 == `val` -> intervals[intervals.size - 1][1] = `val`
                            intervals[intervals.size - 1][1] < `val` -> intervals.add(
                                intervals.size,
                                intArrayOf(`val`, `val`)
                            )
                        }
                    }
                    else -> {
                        val currentInterval = intervals[targetPosition]
                        val nextInterval = intervals[targetPosition + 1]
                        when {
                            `val` - 1 > currentInterval[1] && `val` + 1 < nextInterval[0] -> intervals.add(
                                targetPosition + 1,
                                intArrayOf(`val`, `val`)
                            )
                            `val` - 1 == currentInterval[1] && `val` + 1 < nextInterval[0] -> currentInterval[1] = `val`
                            `val` - 1 > currentInterval[1] && `val` + 1 == nextInterval[0] -> nextInterval[0] = `val`
                            `val` - 1 == currentInterval[1] && `val` + 1 == nextInterval[0] -> {
                                currentInterval[1] = nextInterval[1]
                                intervals.removeAt(targetPosition + 1)
                            }
                        }
                    }
                }
            }
        }
    }

    fun getIntervals(): Array<IntArray> {
        return intervals.toTypedArray()
    }

    private fun binarySearchLastPositionLessThanTarget(intervals: List<IntArray>, target: Int): Int {
        var left = 0
        var right = intervals.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                intervals[mid][0] <= target -> left = mid
                else -> right = mid
            }
        }
        if (intervals[right][0] <= target) {
            return right
        }
        return left
    }
     */
}