package binarysearch

class TimeBasedKeyValueStoreKotlin981 {
    /** Initialize your data structure here. */
    private val timeBasedKeyValueMap = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        // timeBasedKeyValueMap.getOrDefault(key, mutableListOf()).add(Pair(value, timestamp))  must put it back
        timeBasedKeyValueMap.computeIfAbsent(key) { mutableListOf() }.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        return binarySearch(timeBasedKeyValueMap.getValue(key), timestamp)
    }

    private fun binarySearch(list: List<Pair<String, Int>>, target: Int): String {
        var left = 0
        var right = list.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                list[mid].second == target -> return list[mid].first
                list[mid].second < target -> left = mid
                else -> right = mid
            }
        }
        return when {
            list[right].second <= target -> list[right].first
            list[left].second <= target -> list[left].first
            else -> ""
        }
    }
}