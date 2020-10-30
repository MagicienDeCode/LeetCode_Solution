package list_array

class MaximizeDistancetoClosestPersonKotlin849 {
    fun maxDistToClosest(seats: IntArray): Int {
        var start = 0
        var end = 0
        var result = 1
        while (end < seats.size) {
            while (end < seats.size - 1 && seats[end] == 0) {
                ++end
            }
            val currentDistance: Int = if (start == 0 && seats[0] != 1 || end == seats.size - 1 && seats[end] != 1) {
                end - start
            } else {
                end - start shr 1
            }
            result = Math.max(result, currentDistance)
            start = end++
        }
        return result
    }
}