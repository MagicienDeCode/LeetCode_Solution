package list_array

class ChampagneTowerKotlin799 {
    fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
        val result = Array(101) { DoubleArray(101) }
        result[0][0] = poured.toDouble()
        for (i in 0..queryRow) {
            for (j in 0..i) {
                val now = (result[i][j] - 1.0) / 2.0
                if (now > 0) {
                    result[i + 1][j] += now
                    result[i + 1][j + 1] += now
                }
            }
        }
        // 2 1 1
        return Math.min(1.0, result[queryRow][queryGlass])
    }
}