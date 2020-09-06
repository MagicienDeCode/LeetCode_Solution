package list_array

class ImageOverlapKotlin835 {
    fun largestOverlap(a: Array<IntArray>, b: Array<IntArray>): Int {
        var results = 0
        for (i in a.indices) {
            for (j in b.indices) {
                results = maxOf(results, shiftAndCount(i, j, a, b))
                results = maxOf(results, shiftAndCount(i, j, b, a))
            }
        }
        return results
    }

    private fun shiftAndCount(i: Int, j: Int, a: Array<IntArray>, b: Array<IntArray>): Int {
        var count = 0
        for ((bRow, aRow) in (j until a.size).withIndex()) {
            for ((bCol, aCol) in (i until b.size).withIndex()) {
                if (a[aRow][aCol] == 1 && b[bRow][bCol] == 1) {
                    ++count
                }
            }
        }
        return count
    }
}