package binary_search

class CarPoolingKotlin1094 {

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val timeArray = IntArray(1001)
        for (trip in trips) {
            timeArray[trip[1]] += trip[0]
            timeArray[trip[2]] -= trip[0]
        }
        var current = 0
        for (t in timeArray) {
            current += t
            if (current > capacity) {
                return false
            }
        }
        return true
    }
}