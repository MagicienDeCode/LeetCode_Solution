package breadth_first_search

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class CutOffTreesforGolfEventKotlin675 {
    fun cutOffTree(forest: List<List<Int>>): Int {
        val trees: MutableList<IntArray> = ArrayList()
        for (i in forest.indices) {
            for (j in forest[0].indices) {
                val value = forest[i][j]
                if (value > 1) {
                    trees.add(intArrayOf(value, i, j))
                }
            }
        }
        trees.sortWith(Comparator { ints1, ints2 -> compareValues(ints1[0], ints2[0]) })
        var result = 0
        var srcX = 0
        var srcY = 0
        trees.forEach {
            val distance = bfs(forest, srcX, srcY, it[1], it[2])
            if (distance < 0) {
                return -1
            }
            result += distance
            srcX = it[1]
            srcY = it[2]
        }
        return result
    }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        grid: List<List<Int>>,
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size

    private fun bfs(forest: List<List<Int>>, srcX: Int, srcY: Int, desX: Int, desY: Int): Int {
        val visited = Array(forest.size) { BooleanArray(forest[0].size) }
        val queue: Queue<IntArray> = LinkedList()
        queue.offer(intArrayOf(srcX, srcY))
        visited[srcX][srcY] = true
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in 0 until queue.size) {
                val current = queue.poll()
                if (desX == current[0] && desY == current[1]) {
                    return level
                }
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(forest, nextX, nextY) &&
                        !visited[nextX][nextY] &&
                        forest[nextX][nextY] > 1
                    ) {
                        queue.offer(intArrayOf(nextX, nextY))
                        visited[nextX][nextY] = true
                    }
                }
            }
            ++level
        }
        return -1
    }
}