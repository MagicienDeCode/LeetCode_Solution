package binarysearch

class CapacityToShipPackagesWithinDDaysKotlin1011 {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        var left = 1
        var right = 0
        weights.forEach {
            left = maxOf(left, it)
            right += it
        }
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            if (isValidCapacity(weights, D, mid)) {
                right = mid
            } else {
                left = mid
            }
        }
        if (isValidCapacity(weights, D, left)) {
            return left
        }
        return right
    }

    private fun isValidCapacity(weights: IntArray, D: Int, target: Int): Boolean {
        var days = 1
        var count = target
        weights.forEach {
            count -= it
            if (count < 0) {
                days++
                count = target - it
            }
        }
        return days <= D
    }
}