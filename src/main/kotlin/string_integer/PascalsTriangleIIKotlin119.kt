package string_integer

class PascalsTriangleIIKotlin119 {
    fun getRow(rowIndex: Int): List<Int> {
        val results = IntArray(rowIndex + 1)
        results[0] = 1
        for (row in 1..rowIndex) {
            for (index in row downTo 1) {
                results[index] += results[index - 1]
            }
        }
        return results.toList()
    }
}