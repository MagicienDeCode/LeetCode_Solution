package breadth_first_search

import java.util.*

class CheckifThereisaValidPathinaGridKotlin1391 {
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        queue.offer(intArrayOf(0, 0))
        visited[0][0] = true
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current[0] == grid.size - 1 && current[1] == grid[0].size - 1) {
                return true
            }
            when (grid[current[0]][current[1]]) {
                1 -> {
                    val nextX1 = current[0]
                    val nextY1 = current[1] + 1
                    if (inBound(grid, nextX1, nextY1) &&
                        !visited[nextX1][nextY1] &&
                        (grid[nextX1][nextY1] == 3 ||
                                grid[nextX1][nextY1] == 5 ||
                                grid[nextX1][nextY1] == 1)
                    ) {
                        queue.offer(intArrayOf(nextX1, nextY1))
                        visited[nextX1][nextY1] = true
                    }
                    val nextX2 = current[0]
                    val nextY2 = current[1] - 1
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2] &&
                        (grid[nextX2][nextY2] == 4 ||
                                grid[nextX2][nextY2] == 6 ||
                                grid[nextX2][nextY2] == 1)
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2))
                        visited[nextX2][nextY2] = true
                    }
                }
                2 -> {
                    val nextX1 = current[0] + 1
                    val nextY1 = current[1]
                    if (inBound(grid, nextX1, nextY1) &&
                        !visited[nextX1][nextY1] &&
                        (grid[nextX1][nextY1] == 6 ||
                                grid[nextX1][nextY1] == 5 ||
                                grid[nextX1][nextY1] == 2)
                    ) {
                        queue.offer(intArrayOf(nextX1, nextY1))
                        visited[nextX1][nextY1] = true
                    }
                    val nextX2 = current[0] - 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2] &&
                        (grid[nextX2][nextY2] == 4 ||
                                grid[nextX2][nextY2] == 3 ||
                                grid[nextX2][nextY2] == 2)
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2))
                        visited[nextX2][nextY2] = true
                    }
                }
                3 -> {
                    val nextX1 = current[0]
                    val nextY1 = current[1] - 1
                    if (inBound(grid, nextX1, nextY1) &&
                        !visited[nextX1][nextY1] &&
                        (grid[nextX1][nextY1] == 1 ||
                                grid[nextX1][nextY1] == 4 ||
                                grid[nextX1][nextY1] == 6)
                    ) {
                        queue.offer(intArrayOf(nextX1, nextY1))
                        visited[nextX1][nextY1] = true
                    }
                    val nextX2 = current[0] + 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2] &&
                        (grid[nextX2][nextY2] == 2 ||
                                grid[nextX2][nextY2] == 5 ||
                                grid[nextX2][nextY2] == 6)
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2))
                        visited[nextX2][nextY2] = true
                    }
                }
                4 -> {
                    val nextX1 = current[0]
                    val nextY1 = current[1] + 1
                    if (inBound(grid, nextX1, nextY1) &&
                        !visited[nextX1][nextY1] &&
                        (grid[nextX1][nextY1] == 1 ||
                                grid[nextX1][nextY1] == 3 ||
                                grid[nextX1][nextY1] == 5)
                    ) {
                        queue.offer(intArrayOf(nextX1, nextY1))
                        visited[nextX1][nextY1] = true
                    }
                    val nextX2 = current[0] + 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2] &&
                        (grid[nextX2][nextY2] == 2 ||
                                grid[nextX2][nextY2] == 5 ||
                                grid[nextX2][nextY2] == 6)
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2))
                        visited[nextX2][nextY2] = true
                    }
                }
                5 -> {
                    val nextX1 = current[0]
                    val nextY1 = current[1] - 1
                    if (inBound(grid, nextX1, nextY1) &&
                        !visited[nextX1][nextY1] &&
                        (grid[nextX1][nextY1] == 1 ||
                                grid[nextX1][nextY1] == 4 ||
                                grid[nextX1][nextY1] == 6)
                    ) {
                        queue.offer(intArrayOf(nextX1, nextY1))
                        visited[nextX1][nextY1] = true
                    }
                    val nextX2 = current[0] - 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2] &&
                        (grid[nextX2][nextY2] == 2 ||
                                grid[nextX2][nextY2] == 3 ||
                                grid[nextX2][nextY2] == 4)
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2))
                        visited[nextX2][nextY2] = true
                    }
                }
                6 -> {
                    val nextX1 = current[0]
                    val nextY1 = current[1] + 1
                    if (inBound(grid, nextX1, nextY1) &&
                        !visited[nextX1][nextY1] &&
                        (grid[nextX1][nextY1] == 1 ||
                                grid[nextX1][nextY1] == 3 ||
                                grid[nextX1][nextY1] == 5)
                    ) {
                        queue.offer(intArrayOf(nextX1, nextY1))
                        visited[nextX1][nextY1] = true
                    }
                    val nextX2 = current[0] - 1
                    val nextY2 = current[1]
                    if (inBound(grid, nextX2, nextY2) &&
                        !visited[nextX2][nextY2] &&
                        (grid[nextX2][nextY2] == 2 ||
                                grid[nextX2][nextY2] == 3 ||
                                grid[nextX2][nextY2] == 4)
                    ) {
                        queue.offer(intArrayOf(nextX2, nextY2))
                        visited[nextX2][nextY2] = true
                    }
                }
            }
        }
        return false
    }

    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}

fun main() {
    val solution = CheckifThereisaValidPathinaGridKotlin1391()
    // true
    println(
        solution.hasValidPath(
            arrayOf(
                intArrayOf(3, 4, 3, 4, 3, 4, 3),
                intArrayOf(2, 2, 2, 2, 2, 2, 2),
                intArrayOf(2, 2, 2, 2, 2, 2, 2),
                intArrayOf(2, 2, 2, 2, 2, 2, 2),
                intArrayOf(2, 2, 2, 2, 2, 2, 2),
                intArrayOf(6, 5, 6, 5, 6, 5, 6)
            )
        )
    )
    // true
    println(
        solution.hasValidPath(
            arrayOf(
                intArrayOf(1, 1, 1, 1, 1, 1, 3)
            )
        )
    )
    // true false
    println(
        solution.hasValidPath(
            arrayOf(
                intArrayOf(2, 4, 3),
                intArrayOf(6, 5, 2)
            )
        )
    )
    println(
        solution.hasValidPath(
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(1, 2, 1)
            )
        )
    )
}