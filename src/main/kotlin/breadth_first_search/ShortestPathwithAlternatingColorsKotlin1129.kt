package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ShortestPathwithAlternatingColorsKotlin1129 {
    private val blue = 0
    private val red = 1

    fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
        val redMap: MutableMap<Int, MutableList<Int>> = HashMap()
        red_edges.forEach { redMap.computeIfAbsent(it[0]) { ArrayList() }.add(it[1]) }
        val blueMap: MutableMap<Int, MutableList<Int>> = HashMap()
        blue_edges.forEach { blueMap.computeIfAbsent(it[0]) { ArrayList() }.add(it[1]) }
        val resultArray = IntArray(n) { -1 }
        bfs(n, redMap, blueMap, resultArray, blue)
        bfs(n, redMap, blueMap, resultArray, red)
        return resultArray
    }

    private fun bfs(
        n: Int,
        redMap: Map<Int, List<Int>>,
        blueMap: Map<Int, List<Int>>,
        resultArray: IntArray,
        color: Int
    ) {
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(n) { BooleanArray(2) }
        queue.offer(intArrayOf(0, color))
        visited[0][color] = true
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                val currentIndex = current[0]
                resultArray[currentIndex] = when {
                    resultArray[currentIndex] == -1 -> level
                    else -> minOf(resultArray[currentIndex], level)
                }
                val currentColor = current[1]
                if (currentColor == red) {
                    redMap[currentIndex]?.forEach {
                        if (!visited[it][blue]) {
                            queue.offer(intArrayOf(it, blue))
                            visited[it][blue] = true
                        }
                    }
                }
                if (currentColor == blue) {
                    blueMap[currentIndex]?.forEach {
                        if (!visited[it][red]) {
                            queue.offer(intArrayOf(it, red))
                            visited[it][red] = true
                        }
                    }
                }
            }
            ++level
        }
    }
}

fun main() {
    val solution = ShortestPathwithAlternatingColorsKotlin1129()
    // 0 1 2 3 7
    solution.shortestAlternatingPaths(
        5,
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)),
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))
    ).forEach(::print)
    println()
    // 0 1 -1
    solution.shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), emptyArray()).forEach(::print)
    println()
    solution.shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(2, 1))).forEach(::print)
    println()
    // 0 1 2
    solution.shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(1, 2))).forEach(::print)
    println()
}