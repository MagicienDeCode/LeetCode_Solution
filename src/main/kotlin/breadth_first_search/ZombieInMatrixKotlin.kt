package breadth_first_search

import java.util.*

class ZombieInMatrixKotlin {
    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size

    fun zombie(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        val queue: Queue<IntArray> = LinkedList()
        var peoples = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    ++peoples
                }
                if (grid[i][j] == 1) {
                    queue.offer(intArrayOf(i, j))
                    visited[i][j] = true
                }
            }
        }
        if (peoples == 0) {
            return 0
        }
        var level = 0
        var count = 0
        while (!queue.isEmpty()) {
            for (size in 0 until queue.size) {
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
                        ++count
                    }
                }
            }
            ++level
        }
        return if (count == peoples) --level else -1
    }
}

fun main() {
    val solution = ZombieInMatrixKotlin()
    println(
        solution.zombie(
            arrayOf(
                intArrayOf(0, 1, 2, 0, 0),
                intArrayOf(1, 0, 0, 2, 1),
                intArrayOf(0, 1, 0, 0, 0)
            )
        )
    )
}