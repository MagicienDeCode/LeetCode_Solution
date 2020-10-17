package list_array

import java.util.*

class RemoveCoveredIntervalsKotlin1288 {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        var result = 1
        intervals.sortWith(Comparator { o1, o2 ->
            if (o1[0] == o2[0]) {
                compareValues(o2[1], o1[1])
            } else {
                compareValues(o1[0], o2[0])
            }
        })
        var minY = intervals[0][1]
        for (interval in intervals) {
            if (interval[1] > minY) {
                ++result
                minY = interval[1]
            }
        }
        return result
    }
}