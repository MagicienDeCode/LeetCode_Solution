package breadth_first_search

import java.util.*

class TrappingRainWaterIIKotlin407 {

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: Array<IntArray>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size

    fun trapRainWater(heightMap: Array<IntArray>): Int {
        var result = 0
        var currentLevel = 0
        val visited = Array(heightMap.size) { BooleanArray(heightMap[0].size) }
        val priorityQueue: PriorityQueue<Node> = PriorityQueue()
        for (i in heightMap.indices) {
            priorityQueue.offer(Node(i, 0, heightMap[i][0]))
            visited[i][0] = true
            priorityQueue.offer(Node(i, heightMap[0].size - 1, heightMap[i][heightMap[0].size - 1]))
            visited[i][heightMap[0].size - 1] = true
        }
        for (j in heightMap[0].indices) {
            priorityQueue.offer(Node(0, j, heightMap[0][j]))
            visited[0][j] = true
            priorityQueue.offer(Node(heightMap.size - 1, j, heightMap[heightMap.size - 1][j]))
            visited[heightMap.size - 1][j] = true
        }
        while (priorityQueue.isNotEmpty()) {
            val currentNode = priorityQueue.poll()
            currentLevel = maxOf(currentLevel, currentNode.value)
            for (index in 0..3) {
                val nextX = currentNode.x + deltaX[index]
                val nextY = currentNode.y + deltaY[index]
                if (inBound(heightMap, nextX, nextY) &&
                    !visited[nextX][nextY]
                ) {
                    visited[nextX][nextY] = true
                    if (heightMap[nextX][nextY] < currentLevel) {
                        result += currentLevel - heightMap[nextX][nextY]
                    }
                    priorityQueue.offer(Node(nextX, nextY, heightMap[nextX][nextY]))
                }
            }
        }
        return result
    }

    data class Node(
        val x: Int,
        val y: Int,
        val value: Int
    ) : Comparable<Node> {
        /**
         * Compares this object with the specified object for order. Returns zero if this object is equal
         * to the specified [other] object, a negative number if it's less than [other], or a positive number
         * if it's greater than [other].
         */
        override fun compareTo(other: Node): Int =
            compareValues(value, other.value)
    }
}

fun main() {
    val solution = TrappingRainWaterIIKotlin407()

    println(
        solution.trapRainWater(
            arrayOf(
                intArrayOf(1, 4, 3, 1, 3, 2),
                intArrayOf(3, 2, 1, 3, 2, 4),
                intArrayOf(2, 3, 3, 2, 3, 1)
            )
        )
    )
}
