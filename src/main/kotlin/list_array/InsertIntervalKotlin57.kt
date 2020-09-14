package list_array

import java.util.*

class InsertIntervalKotlin57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray?>? {
        val results: MutableList<IntArray> = ArrayList()
        var current = 0
        while (current < intervals.size && intervals[current][1] < newInterval[0]) {
            results.add(intervals[current++])
        }
        while (current < intervals.size && intervals[current][0] <= newInterval[1]) {
            newInterval[0] = minOf(newInterval[0], intervals[current][0])
            newInterval[1] = maxOf(newInterval[1], intervals[current][1])
            ++current
        }
        results.add(newInterval)
        while (current < intervals.size) {
            results.add(intervals[current++])
        }
        return results.toTypedArray()
    }
}