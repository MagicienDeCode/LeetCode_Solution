package binary_search

import java.util.*

class SwiminRisingWaterKotlin778 {
    fun swimInWater(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) }
        var left = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        grid.forEach {
            it.forEach { g ->
                left = minOf(left, g)
                right = maxOf(right, g)
            }
        }
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            visited.forEach { Arrays.fill(it, 0) }
            dfs(grid, visited, 0, 0, mid)
            if (visited[grid.size - 1][grid[0].size - 1] == 1) {
                right = mid
            } else {
                left = mid
            }
        }
        return right
    }

    private fun dfs(
        grid: Array<IntArray>,
        visited: Array<IntArray>,
        x: Int,
        y: Int,
        target: Int
    ) {
        if (inGrid(x, y, grid.size, grid[0].size) &&
            visited[x][y] == 0 &&
            grid[x][y] <= target
        ) {
            visited[x][y] = 1
            dfs(grid, visited, x - 1, y, target)
            dfs(grid, visited, x, y - 1, target)
            dfs(grid, visited, x + 1, y, target)
            dfs(grid, visited, x, y + 1, target)
        }
    }

    private fun inGrid(
        x: Int,
        y: Int,
        boundX: Int,
        boundY: Int
    ): Boolean = x in 0 until boundX && y in 0 until boundY
    /*
    fun swimInWater(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) }
        val priorityQueue: PriorityQueue<Grid> = PriorityQueue()
        val start = Grid(grid[0][0], 0, 0)
        priorityQueue.offer(start)
        visited[0][0] = 1
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        while (priorityQueue.isNotEmpty()) {
            val currentGrid = priorityQueue.poll()
            if (currentGrid.x == grid.size - 1 && currentGrid.y == grid[0].size - 1) {
                return currentGrid.value
            }
            for (index in dx.indices) {
                val nextX = currentGrid.x + dx[index]
                val nextY = currentGrid.y + dy[index]
                if (inGrid(nextX, nextY, grid.size, grid[0].size) && visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = 1
                    priorityQueue.offer(Grid(maxOf(grid[nextX][nextY], currentGrid.value), nextX, nextY))
                }
            }
        }
        return 0
    }

    private fun inGrid(
        x: Int,
        y: Int,
        boundX: Int,
        boundY: Int
    ): Boolean = x in 0 until boundX && y in 0 until boundY

    data class Grid(
        val value: Int,
        val x: Int,
        val y: Int
    ) : Comparable<Grid> {
        override fun compareTo(other: Grid): Int = compareValues(value, other.value)
    }
     */
}

fun main() {
    val solution = SwiminRisingWaterKotlin778()
    println(
        solution.swimInWater(
            arrayOf(
                intArrayOf(0, 1, 2, 3, 4),
                intArrayOf(24, 23, 22, 21, 5),
                intArrayOf(12, 13, 14, 15, 16),
                intArrayOf(11, 17, 18, 19, 20),
                intArrayOf(10, 9, 8, 7, 6)
            )
        )
    )
    println(solution.swimInWater(arrayOf(intArrayOf(0, 2), intArrayOf(1, 3))))
}