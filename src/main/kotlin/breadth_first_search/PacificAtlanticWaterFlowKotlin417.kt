package breadth_first_search

import java.util.*

class PacificAtlanticWaterFlowKotlin417 {
    fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int>> {
        val result: MutableList<List<Int>> = LinkedList()
        if (matrix.isEmpty()) {
            return result
        }
        val visited1 = Array(matrix.size) { BooleanArray(matrix[0].size) }
        val visited2 = Array(matrix.size) { BooleanArray(matrix[0].size) }
        val queue1: Queue<Pair<Int, Int>> = LinkedList()
        val queue2: Queue<Pair<Int, Int>> = LinkedList()
        for (i in matrix.indices) {
            queue1.offer(Pair(i, 0))
            visited1[i][0] = true
            queue2.offer(Pair(i, matrix[0].size - 1))
            visited2[i][matrix[0].size - 1] = true
        }
        for (j in matrix[0].indices) {
            queue1.offer(Pair(0, j))
            visited1[0][j] = true
            queue2.offer(Pair(matrix.size - 1, j))
            visited2[matrix.size - 1][j] = true
        }
        bfs(queue1, visited1, matrix)
        bfs(queue2, visited2, matrix)
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (visited1[i][j] && visited2[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }
        return result
    }

    private fun bfs(
        queue: Queue<Pair<Int, Int>>,
        visited: Array<BooleanArray>,
        matrix: Array<IntArray>
    ) {
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val currentValue = matrix[current.first][current.second]
            for (index in 0..3) {
                val nextX = current.first + deltaX[index]
                val nextY = current.second + deltaY[index]
                if (inBound(matrix, nextX, nextY) &&
                    !visited[nextX][nextY] &&
                    matrix[nextX][nextY] >= currentValue
                ) {
                    visited[nextX][nextY] = true
                    queue.offer(Pair(nextX, nextY))
                }
            }
        }
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}