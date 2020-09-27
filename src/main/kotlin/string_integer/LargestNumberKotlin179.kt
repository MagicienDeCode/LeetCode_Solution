package string_integer

import java.util.*

class LargestNumberKotlin179 {
    fun largestNumber(nums: IntArray): String {
        var strings = nums.map { it.toString() }
        strings = strings.sortedWith(Comparator { s1: String, s2: String ->
            val order1 = s1 + s2
            val order2 = s2 + s1
            order2.compareTo(order1)
        })

        if (strings[0] == "0") {
            return "0"
        }

        val result = StringBuilder()
        for (s in strings) {
            result.append(s)
        }
        return result.toString()
    }
}