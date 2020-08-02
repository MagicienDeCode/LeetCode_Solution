package breadth_first_search

import java.util.*

class ShortestPathtoGetAllKeysKotlin864 {
    fun shortestPathAllKeys(grid: Array<String>): Int {
        val myGrid: List<CharArray> = grid.map { it.toCharArray() }
        val keys = setOf('a', 'b', 'c', 'd', 'e', 'f')
        // get count, start x,y , endKey
        var count = 0
        var startX = 0
        var startY = 0
        for (i in myGrid.indices) {
            for (j in myGrid[0].indices) {
                if (keys.contains(myGrid[i][j])) {
                    ++count
                }
                if (myGrid[i][j] == '@') {
                    startX = i
                    startY = j
                }
            }
        }
        if (count == 0) {
            return 0
        }
        val endKey = 1.shl(count) - 1

        // visited, queue
        val visited = Array(myGrid.size) { Array(myGrid[0].size) { BooleanArray(1.shl(count)) } }
        val queue: Queue<IntArray> = LinkedList()
        queue.offer(intArrayOf(startX, startY, 0))
        visited[startX][startY][0] = true

        // bfs
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current[2] == endKey) {
                    return level
                }
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(myGrid, nextX, nextY) && myGrid[nextX][nextY] != '#') {
                        when (val nextChar = myGrid[nextX][nextY]) {
                            in 'a'..'f' -> {
                                val nextState = 1.shl(nextChar - 'a').or(current[2])
                                if (!visited[nextX][nextY][nextState]) {
                                    queue.offer(intArrayOf(nextX, nextY, nextState))
                                    visited[nextX][nextY][nextState] = true
                                }
                            }
                            in 'A'..'F' -> {
                                val currentLockIndex = nextChar - 'A'
                                val unLock = 1.and(current[2].shr(currentLockIndex))
                                if (unLock == 1 && !visited[nextX][nextY][current[2]]) {
                                    queue.offer(intArrayOf(nextX, nextY, current[2]))
                                    visited[nextX][nextY][current[2]] = true
                                }
                            }
                            else -> {
                                if (!visited[nextX][nextY][current[2]]) {
                                    queue.offer(intArrayOf(nextX, nextY, current[2]))
                                    visited[nextX][nextY][current[2]] = true
                                }
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
        grid: List<CharArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = ShortestPathtoGetAllKeysKotlin864()
    // 11
    println(solution.shortestPathAllKeys(arrayOf("@fedcbBCDEFaA")))
    // 8
    println(
        solution.shortestPathAllKeys(
            arrayOf(
                "@.a.#",
                "###.#",
                "b.A.B"
            )
        )
    )
    // 6
    println(
        solution.shortestPathAllKeys(
            arrayOf(
                "@..aA",
                "..B#.",
                "....b"
            )
        )
    )
}