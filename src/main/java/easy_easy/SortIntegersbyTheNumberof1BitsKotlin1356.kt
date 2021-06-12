package easy_easy

class SortIntegersbyTheNumberof1BitsKotlin1356 {
    fun sortByBits(arr: IntArray): IntArray =
            arr.sortedWith(Comparator { o1, o2 ->
                val compareCount = compareValues(count1(o1), count1(o2))
                if (compareCount == 0) {
                    compareValues(o1, o2)
                } else {
                    compareCount
                }
            }).toIntArray()

    private fun count1(n: Int): Int {
        var result = 0
        for (i in 0 until 32) {
            if (n.and(1.shl(i)) != 0) {
                ++result
            }
        }
        return result
    }

}