package depth_first_search

class UniquePathsIIIKotlin980 {

    var result = 0

    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var totalZero = 0
        grid.forEach {
            it.forEach { g ->
                if (g == 0) {
                    ++totalZero
                }
            }
        }
        result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, 0, totalZero)
                }
            }
        }
        return result
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)

    private fun dfs(
        grid: Array<IntArray>,
        x: Int,
        y: Int,
        current: Int,
        totalZero: Int
    ) {
        if (grid[x][y] == 2 && current == totalZero) {
            ++result
        }
        val value = grid[x][y]
        val nextCurrent = if (value == 0) current + 1 else current
        grid[x][y] = -1
        for (index in deltaX.indices) {
            val nextX = x + deltaX[index]
            val nextY = y + deltaY[index]
            if (inBound(grid, nextX, nextY) && grid[nextX][nextY] != -1) {
                dfs(grid, nextX, nextY, nextCurrent, totalZero)
            }
        }
        grid[x][y] = value
    }

    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = UniquePathsIIIKotlin980()
    val java = UniquePathsIII980()
    println(
        solution.uniquePathsIII(
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 2, -1)
            )
        )
    )
    println(
        solution.uniquePathsIII(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
            )
        )
    )
    println(
        java.uniquePathsIII(
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 2, -1)
            )
        )
    )
    println(
        java.uniquePathsIII(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
            )
        )
    )
}