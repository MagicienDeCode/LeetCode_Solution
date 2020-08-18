package breadth_first_search

import java.util.*

class ShortestPathinaGridwithObstaclesEliminationKotlin1293 {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(grid.size) { Array(grid[0].size) { BooleanArray(k + 1) } }
        queue.offer(intArrayOf(0, 0, k))
        visited[0][0][k] = true
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current[0] == grid.size - 1 &&
                    current[1] == grid[0].size - 1
                ) {
                    return level
                }
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(grid, nextX, nextY)) {
                        if (grid[nextX][nextY] == 0) {
                            if (!visited[nextX][nextY][current[2]]) {
                                queue.offer(intArrayOf(nextX, nextY, current[2]))
                                visited[nextX][nextY][current[2]] = true
                            }
                        } else {
                            if (current[2] >= 1 && !visited[nextX][nextY][current[2] - 1]) {
                                queue.offer(intArrayOf(nextX, nextY, current[2] - 1))
                                visited[nextX][nextY][current[2] - 1] = true
                            }
                        }
                    }
                }
            }
            ++level
        }
        return -1
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)

    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ): Boolean {
        return x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
    }
}

fun main() {
    val java = ShortestPathinaGridwithObstaclesElimination1293()
    // 6
    println(
        java.shortestPath(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 0, 0)
            ), 1
        )
    )
    // -1
    println(
        java.shortestPath(
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 0)
            ), 1
        )
    )
}