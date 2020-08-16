package breadth_first_search

import java.util.*

class MinimumMovestoMoveaBoxtoTheirTargetLocationKotlin1263 {
    fun minPushBox(grid: Array<CharArray>): Int {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(grid.size) { Array(grid[0].size) { BooleanArray(4) } }
        val target = IntArray(2)
        val player = IntArray(2)
        val box = IntArray(2)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 'T') {
                    target[0] = i
                    target[1] = j
                    grid[i][j] = '.'
                }
                if (grid[i][j] == 'S') {
                    player[0] = i
                    player[1] = j
                    grid[i][j] = '.'
                }
                if (grid[i][j] == 'B') {
                    box[0] = i
                    box[1] = j
                    grid[i][j] = '.'
                }
            }
        }
        queue.offer(intArrayOf(box[0], box[1], player[0], player[1]))
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current[0] == target[0] &&
                    current[1] == target[1]
                ) {
                    return level
                }
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]

                    val playX = current[0] - deltaX[index]
                    val playY = current[1] - deltaY[index]
                    if (inBound(grid, nextX, nextY) &&
                        inBound(grid, playX, playY) &&
                        !visited[nextX][nextY][index] &&
                        grid[nextX][nextY] == '.' &&
                        grid[playX][playY] == '.' &&
                        canPush(grid, playX, playY, current[2], current[3], current[0], current[1])
                    ) {
                        queue.offer(intArrayOf(nextX, nextY, playX, playY))
                        visited[nextX][nextY][index] = true
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun canPush(
        grid: Array<CharArray>,
        targetX: Int,
        targetY: Int,
        x: Int,
        y: Int,
        boxX: Int,
        boxY: Int
    ): Boolean {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        queue.offer(intArrayOf(x, y))
        visited[x][y] = true
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current[0] == targetX && current[1] == targetY) {
                return true
            }
            for (index in 0..3) {
                val nextX = current[0] + deltaX[index]
                val nextY = current[1] + deltaY[index]
                if (inBound(grid, nextX, nextY) &&
                    !visited[nextX][nextY] &&
                    grid[nextX][nextY] == '.' &&
                    (nextX != boxX || nextY != boxY)
                ) {
                    queue.offer(intArrayOf(nextX, nextY))
                    visited[nextX][nextY] = true
                }
            }
        }
        return false
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = MinimumMovestoMoveaBoxtoTheirTargetLocationKotlin1263()
    // 8
    println(
        solution.minPushBox(
            arrayOf(
                charArrayOf('#', '.', '.', '#', 'T', '#', '#', '#', '#'),
                charArrayOf('#', '.', '.', '#', '.', '#', '.', '.', '#'),
                charArrayOf('#', '.', '.', '#', '.', '#', 'B', '.', '#'),
                charArrayOf('#', '.', '.', '.', '.', '.', '.', '.', '#'),
                charArrayOf('#', '.', '.', '.', '.', '#', '.', 'S', '#'),
                charArrayOf('#', '.', '.', '#', '.', '#', '#', '#', '#')
            )
        )
    )
    // 7
    println(
        solution.minPushBox(
            arrayOf(
                charArrayOf('#', '.', '.', '#', '#', '#', '#', '#'),
                charArrayOf('#', '.', '.', 'T', '#', '.', '.', '#'),
                charArrayOf('#', '.', '.', '.', '#', 'B', '.', '#'),
                charArrayOf('#', '.', '.', '.', '.', '.', '.', '#'),
                charArrayOf('#', '.', '.', '.', '#', '.', 'S', '#'),
                charArrayOf('#', '.', '.', '#', '#', '#', '#', '#')
            )
        )
    )
    // 3
    println(
        solution.minPushBox(
            arrayOf(
                charArrayOf('#', '#', '#', '#', '#', '#'),
                charArrayOf('#', 'T', '#', '#', '#', '#'),
                charArrayOf('#', '.', '.', 'B', '.', '#'),
                charArrayOf('#', '.', '#', '#', '.', '#'),
                charArrayOf('#', '.', '.', '.', 'S', '#'),
                charArrayOf('#', '#', '#', '#', '#', '#')
            )
        )
    )
}