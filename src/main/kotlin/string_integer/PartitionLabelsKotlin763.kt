package string_integer

import java.util.*

class PartitionLabelsKotlin763 {
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26)
        for (i in s.indices) {
            last[s[i] - 'a'] = i
        }
        var end = 0
        var start = 0
        val results: MutableList<Int> = LinkedList()
        for (i in s.indices) {
            end = maxOf(end, last[s[i] - 'a'])
            if (i == end) {
                results.add(end - start + 1)
                start = i + 1
            }
        }
        return results
    }
}