package list_array

import java.util.*

class MinimumNumberofArrowstoBurstBalloonsKotlin452 {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) {
            return 0
        }
        points.sortWith(Comparator { o1, o2 ->
            if (o1[0] == o2[0]) {
                compareValues(o1[1], o2[1])
            } else {
                compareValues(o1[0], o2[0])
            }
        })
        var result = 1
        var endIndex = points[0][1]
        for (point in points) {
            endIndex = if (point[0] <= endIndex) {
                Math.min(endIndex, point[1])
            } else {
                ++result
                point[1]
            }
        }
        return result
    }
}