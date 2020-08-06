package breadth_first_search

import java.util.*

class AsFarfromLandasPossibleKotlin1162 {
    fun maxDistance(grid: Array<IntArray>): Int {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    queue.offer(intArrayOf(i, j))
                    visited[i][j] = true
                }
            }
        }

        if (queue.size == grid.size * grid[0].size || queue.isEmpty()) {
            return -1
        }

        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(grid, nextX, nextY) &&
                        !visited[nextX][nextY] &&
                        grid[nextX][nextY] == 0
                    ) {
                        queue.offer(intArrayOf(nextX, nextY))
                        visited[nextX][nextY] = true
                    }
                }
            }
            ++level
        }
        return level - 1
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = AsFarfromLandasPossibleKotlin1162()
    // 2
    println(
        solution.maxDistance(
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(0, 0, 0),
                intArrayOf(1, 0, 1)
            )
        )
    )
    // 4
    println(
        solution.maxDistance(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}