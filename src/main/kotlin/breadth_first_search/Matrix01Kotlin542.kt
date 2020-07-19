package breadth_first_search

import java.util.*

class Matrix01Kotlin542 {

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val visited = Array(matrix.size) { BooleanArray(matrix[0].size) }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                when (matrix[i][j]) {
                    0 -> visited[i][j] = true
                    1 -> {
                        var count = 0
                        for (index in 0..3) {
                            val nextX = i + deltaX[index]
                            val nextY = j + deltaY[index]
                            if (inBound(matrix, nextX, nextY) &&
                                matrix[nextX][nextY] == 0
                            ) {
                                ++count
                            }
                        }
                        if (count > 0) {
                            queue.offer(Pair(i, j))
                            visited[i][j] = true
                        }
                    }
                }
            }
        }
        var level = 1
        while (queue.isNotEmpty()) {
            for (time in queue.indices) {
                val current = queue.poll()
                matrix[current.first][current.second] = level
                for (index in 0..3) {
                    val nextX = current.first + deltaX[index]
                    val nextY = current.second + deltaY[index]
                    if (inBound(matrix, nextX, nextY) &&
                        !visited[nextX][nextY]
                    ) {
                        queue.offer(Pair(nextX, nextY))
                        visited[nextX][nextY] = true
                    }
                }
            }
            ++level
        }
        return matrix
    }
}

fun main() {
    val solution = Matrix01Kotlin542()
    val result = solution.updateMatrix(
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
    )
    println(result)
}