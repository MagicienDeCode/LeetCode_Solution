package string_integer

class TeemoAttackingKotlin495 {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if (timeSeries.isEmpty()) {
            return 0
        }
        var result = 0
        for (i in 0..timeSeries.size - 2) {
            result += Math.min(timeSeries[i + 1] - timeSeries[i], duration)
        }
        return result + duration
    }
}