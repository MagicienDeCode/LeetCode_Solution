package binarysearch

class OnlineElectionKotlin911(persons: IntArray, val times: IntArray) {
    // at i, time[i]'s leader
    private val leaders: IntArray = IntArray(times.size)

    init {
        val counts = IntArray(persons.size)
        // at i, person[i]'s count
        counts[persons[0]] = 1
        leaders[0] = persons[0]
        var maxPerson = persons[0]
        for (index in 1 until times.size) {
            counts[persons[index]]++
            if (counts[persons[index]] >= counts[maxPerson]) {
                maxPerson = persons[index]
                leaders[index] = maxPerson
            } else {
                leaders[index] = leaders[index - 1]
            }
        }
    }

    fun q(t: Int): Int {
        var left = 0
        var right = times.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                times[mid] == t -> return leaders[mid]
                times[mid] < t -> left = mid
                times[mid] > t -> right = mid
            }
        }
        return when {
            times[right] <= t -> leaders[right]
            times[left] <= t -> leaders[left]
            else -> -1
        }
    }
}