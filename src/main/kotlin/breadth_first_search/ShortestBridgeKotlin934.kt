package breadth_first_search

import java.util.*

class ShortestBridgeKotlin934 {
    fun shortestBridge(A: Array<IntArray>): Int {
        val visited = Array(A.size) { BooleanArray(A[0].size) }
        val queue: Queue<IntArray> = LinkedList()

        // dfs get one island
        for (i in A.indices) {
            if (queue.isNotEmpty()) {
                break
            }
            for (j in A[0].indices) {
                if (queue.isNotEmpty()) {
                    break
                }
                if (A[i][j] == 1) {
                    dfs(A, visited, queue, i, j)
                }
            }
        }

        // bfs find the minimum distance
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(A, nextX, nextY) &&
                        !visited[nextX][nextY]
                    ) {
                        if (A[nextX][nextY] == 1) {
                            return level
                        }
                        queue.offer(intArrayOf(nextX, nextY))
                        visited[nextX][nextY] = true
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun dfs(
        A: Array<IntArray>,
        visited: Array<BooleanArray>,
        queue: Queue<IntArray>,
        i: Int,
        j: Int
    ) {
        queue.offer(intArrayOf(i, j))
        visited[i][j] = true
        for (index in 0..3) {
            val nextX = i + deltaX[index]
            val nextY = j + deltaY[index]
            if (inBound(A, nextX, nextY) &&
                !visited[nextX][nextY] &&
                A[nextX][nextY] == 1
            ) {
                dfs(A, visited, queue, nextX, nextY)
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

fun main() {
    val solution = ShortestBridgeKotlin934()
    // 2
    println(
        solution.shortestBridge(
            arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 1)
            )
        )
    )
    // 3
    println(
        solution.shortestBridge(
            arrayOf(
                intArrayOf(1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(1, 1, 0, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 0, 0, 0, 1, 1, 1),
                intArrayOf(1, 1, 0, 0, 0, 1, 1, 0),
                intArrayOf(1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(1, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(1, 1, 0, 0, 0, 0, 0, 0)
            )
        )
    )
}