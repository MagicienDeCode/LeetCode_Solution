package breadth_first_search

import java.util.*

class MinimumMovestoReachTargetwithRotationsKotlin1210 {
    private val vertical = 0
    private val horizontal = 1

    fun minimumMoves(grid: Array<IntArray>): Int {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(grid.size) { Array(grid[0].size) { BooleanArray(2) } }
        queue.offer(intArrayOf(0, 1, horizontal))
        visited[0][1][horizontal] = true
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current[0] == grid.size - 1 &&
                    current[1] == grid[0].size - 1 &&
                    current[2] == horizontal
                ) {
                    return level
                }
                if (current[2] == horizontal) {
                    // go horizon next
                    val nextX = current[0]
                    val nextY = current[1] + 1
                    if (inBound(grid, nextX, nextY) &&
                        !visited[nextX][nextY][horizontal] &&
                        grid[nextX][nextY] == 0
                    ) {
                        queue.offer(intArrayOf(nextX, nextY, horizontal))
                        visited[nextX][nextY][horizontal] = true
                    }
                    // go vertical next
                    val nextX2 = current[0] + 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2][horizontal] &&
                        grid[nextX2][nextY2 - 1] == 0 &&
                        grid[nextX2][nextY2] == 0
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2, horizontal))
                        visited[nextX2][nextY2][horizontal] = true
                    }
                    // rotate clockwise
                    val nextX3 = current[0] + 1
                    val nextY3 = current[1] - 1
                    if (inBound(grid, nextX3, nextY3) &&
                        !visited[nextX3][nextY3][vertical] &&
                        grid[nextX3][nextY3 + 1] == 0 &&
                        grid[nextX3][nextY3] == 0
                    ) {
                        queue.offer(intArrayOf(nextX3, nextY3, vertical))
                        visited[nextX3][nextY3][vertical] = true
                    }
                } else {
                    // go horizon next
                    val nextX = current[0]
                    val nextY = current[1] + 1
                    if (inBound(grid, nextX, nextY) &&
                        !visited[nextX][nextY][vertical] &&
                        grid[nextX - 1][nextY] == 0 &&
                        grid[nextX][nextY] == 0
                    ) {
                        queue.offer(intArrayOf(nextX, nextY, vertical))
                        visited[nextX][nextY][vertical] = true
                    }
                    // go vertical next
                    val nextX2 = current[0] + 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2][vertical] &&
                        grid[nextX2][nextY2] == 0
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2, vertical))
                        visited[nextX2][nextY2][vertical] = true
                    }
                    // rotate counterclockwise
                    val nextX3 = current[0] - 1
                    val nextY3 = current[1] + 1
                    if (inBound(grid, nextX3, nextY3) &&
                        !visited[nextX3][nextY3][horizontal] &&
                        grid[nextX3 + 1][nextY3] == 0 &&
                        grid[nextX3][nextY3] == 0
                    ) {
                        queue.offer(intArrayOf(nextX3, nextY3, horizontal))
                        visited[nextX3][nextY3][horizontal] = true
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = MinimumMovestoReachTargetwithRotationsKotlin1210()
    // 11
    println(
        solution.minimumMoves(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 1),
                intArrayOf(1, 1, 0, 0, 1, 0),
                intArrayOf(0, 0, 0, 0, 1, 1),
                intArrayOf(0, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 0, 0),
                intArrayOf(0, 1, 1, 0, 0, 0)
            )
        )
    )
}