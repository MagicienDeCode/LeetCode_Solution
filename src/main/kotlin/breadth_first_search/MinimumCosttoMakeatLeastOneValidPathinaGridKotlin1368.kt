package breadth_first_search

import java.util.*

class MinimumCosttoMakeatLeastOneValidPathinaGridKotlin1368 {
    fun minCost(grid: Array<IntArray>): Int {
        val priorityQueue = PriorityQueue { i1: IntArray, i2: IntArray -> compareValues(i1[2], i2[2]) }
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        priorityQueue.offer(intArrayOf(0, 0, 0))
        while (priorityQueue.isNotEmpty()) {
            val current = priorityQueue.poll()
            // end condition
            if (current[0] == grid.size - 1 &&
                current[1] == grid[0].size - 1
            ) {
                return current[2]
            }
            if (visited[current[0]][current[1]]) {
                continue
            }
            visited[current[0]][current[1]] = true
            for (index in 0..3) {
                val nextX = current[0] + deltaX[index]
                val nextY = current[1] + deltaY[index]
                if (inBound(grid, nextX, nextY)) {
                    if (index + 1 == grid[current[0]][current[1]]) {
                        priorityQueue.offer(intArrayOf(nextX, nextY, current[2]))
                    } else {
                        priorityQueue.offer(intArrayOf(nextX, nextY, current[2] + 1))
                    }
                }
            }
        }
        return -1
    }

    // right left down up
    private val deltaX = intArrayOf(0, 0, 1, -1)
    private val deltaY = intArrayOf(1, -1, 0, 0)

    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ): Boolean {
        return x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
    }
}

fun main() {
    val java = MinimumCosttoMakeatLeastOneValidPathinaGrid1368()
    // 3
    println(
        java.minCost(
            arrayOf(
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 2, 2, 2),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 2, 2, 2)
            )
        )
    )
    // 0
    println(
        java.minCost(
            arrayOf(
                intArrayOf(1, 1, 3),
                intArrayOf(3, 2, 2),
                intArrayOf(1, 1, 4)
            )
        )
    )
}