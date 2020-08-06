package breadth_first_search

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class EscapeaLargeMazeKotlin1036 {
    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        // prepare blockedMap, maxLevel
        val blockedMap: MutableMap<Int, MutableSet<Int>> = HashMap()
        blocked.forEach {
            blockedMap.computeIfAbsent(it[0]) { HashSet() }.add(it[1])
        }
        val maxLevel = blocked.size

        return bfs(blockedMap, maxLevel, source, target) &&
                bfs(blockedMap, maxLevel, target, source)
    }

    private fun bfs(
        blockedMap: Map<Int, Set<Int>>,
        maxLevel: Int,
        start: IntArray,
        end: IntArray
    ): Boolean {
        val queue: Queue<IntArray> = LinkedList()
        val visited: MutableMap<Int, MutableSet<Int>> = HashMap()
        queue.offer(start)
        visited.computeIfAbsent(start[0]) { HashSet() }.add(start[1])

        var level = 0
        while (queue.isNotEmpty()) {
            if (level >= maxLevel) {
                return true
            }
            for (size in queue.indices) {
                val current = queue.poll()
                if (end[0] == current[0] && end[1] == current[1]) {
                    return true
                }
                for (index in 0..3) {
                    val nextX = current[0] + deltaX[index]
                    val nextY = current[1] + deltaY[index]
                    if (inBound(nextX, nextY) &&
                        !exist(visited, nextX, nextY) &&
                        !exist(blockedMap, nextX, nextY)
                    ) {
                        queue.offer(intArrayOf(nextX, nextY))
                        visited.computeIfAbsent(nextX) { HashSet() }.add(nextY)
                    }
                }
            }
            ++level
        }
        return false
    }

    private fun exist(visited: Map<Int, Set<Int>>, x: Int, y: Int): Boolean =
        if (visited.containsKey(x)) {
            visited.getValue(x).contains(y)
        } else {
            false
        }

    private val deltaX = intArrayOf(0, 0, -1, 1)
    private val deltaY = intArrayOf(-1, 1, 0, 0)
    private fun inBound(
        x: Int,
        y: Int
    ) = x >= 0 && y >= 0 && x < 1000000 && y < 1000000
}

fun main() {
    val solution = EscapeaLargeMazeKotlin1036()
    // false
    println(
        solution.isEscapePossible(
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
            intArrayOf(0, 0),
            intArrayOf(0, 2)
        )
    )
    // true
    println(
        solution.isEscapePossible(
            arrayOf(),
            intArrayOf(0, 0),
            intArrayOf(999999, 999999)
        )
    )
    // true
    println(
        solution.isEscapePossible(
            arrayOf(
                intArrayOf(0, 3),
                intArrayOf(1, 0),
                intArrayOf(1, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 3)
            ),
            intArrayOf(0, 0),
            intArrayOf(0, 2)
        )
    )
}