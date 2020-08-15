package not_categorized

class NonoverlappingIntervalsKotlin435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var result = 0
        var last = 0
        intervals.sortWith(Comparator { int1, int2 -> compareValues(int1[0], int2[0]) })
        for (index in 1 until intervals.size) {
            if (intervals[index][0] < intervals[last][1]) {
                ++result
                if (intervals[index][1] < intervals[last][1]) {
                    last = index
                }
            } else {
                last = index
            }
        }
        return result
    }
}