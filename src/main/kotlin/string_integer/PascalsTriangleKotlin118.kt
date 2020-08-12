package string_integer

class PascalsTriangleKotlin118 {
    fun generate(numRows: Int): List<List<Int>> {
        val results: MutableList<MutableList<Int>> = ArrayList()
        if (numRows == 0) {
            return results
        }
        var preRow: MutableList<Int> = ArrayList()
        results.add(mutableListOf(1))
        for (rows in 1 until numRows) {
            val currentLevel: MutableList<Int> = ArrayList()
            currentLevel.add(1)

            for (index in 1 until rows) {
                currentLevel.add(preRow[index] + preRow[index - 1])
            }

            currentLevel.add(1)

            results.add(currentLevel)
            preRow = currentLevel
        }
        return results
    }
}