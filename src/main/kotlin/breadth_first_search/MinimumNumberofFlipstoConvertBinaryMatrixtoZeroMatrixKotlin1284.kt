package breadth_first_search

import java.util.*
import kotlin.collections.HashSet

class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrixKotlin1284 {
    /*
    0 1 2
    3 4 5
    6 7 8
     */
    fun minFlips(mat: Array<IntArray>): Int {
        if (mat.isEmpty()) {
            return 0
        }
        val n = mat[0].size
        val endString = "0".repeat(mat.size * n)
        val startStringBuilder = StringBuilder()
        mat.forEach { ints ->
            ints.forEach {
                startStringBuilder.append(it)
            }
        }
        val startString = startStringBuilder.toString()
        if (endString == startString) {
            return 0
        }
        val queue: Queue<String> = LinkedList()
        val visited: MutableSet<String> = HashSet()
        queue.offer(startString)
        visited.add(startString)
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in 0 until queue.size) {
                val current = queue.poll()
                if (endString == current) {
                    return level
                }
                for (aimIndex in current.indices) {
                    val currentX = aimIndex / n
                    val currentY = aimIndex % n
                    val newStringBuild = StringBuilder(current)
                    change(newStringBuild, aimIndex)
                    for (index in 0..3) {
                        val nextX = currentX + deltaX[index]
                        val nextY = currentY + deltaY[index]
                        if (inBound(mat, nextX, nextY)) {
                            change(newStringBuild, nextX * n + nextY)
                        }
                    }
                    val newString = newStringBuild.toString()
                    if (!visited.contains(newString)) {
                        queue.offer(newString)
                        visited.add(newString)
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun change(stringBuilder: StringBuilder, index: Int) {
        if (stringBuilder[index] == '0') {
            stringBuilder.setCharAt(index, '1')
        } else {
            stringBuilder.setCharAt(index, '0')
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
    val solution = MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrixKotlin1284()
    // 3
    println(
        solution.minFlips(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1)
            )
        )
    )
    // 0
    println(
        solution.minFlips(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 0)
            )
        )
    )
    // 6
    println(
        solution.minFlips(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(0, 0, 0)
            )
        )
    )
}