package breadth_first_search

import java.util.*
import kotlin.collections.HashSet

class SlidingPuzzleKotlin773 {

    private val endString = "123450"

    private val swapIndexMap = mapOf(
        0 to listOf(
            arrayOf(0, 1),
            arrayOf(0, 3)
        ),
        1 to listOf(
            arrayOf(0, 1),
            arrayOf(1, 2),
            arrayOf(1, 4)
        ),
        2 to listOf(
            arrayOf(1, 2),
            arrayOf(2, 5)
        ),
        3 to listOf(
            arrayOf(3, 4),
            arrayOf(0, 3)
        ),
        4 to listOf(
            arrayOf(5, 4),
            arrayOf(3, 4),
            arrayOf(1, 4)
        ),
        5 to listOf(
            arrayOf(4, 5),
            arrayOf(2, 5)
        )
    )

    fun slidingPuzzle(board: Array<IntArray>): Int {
        val visited: MutableSet<String> = HashSet()
        val queue: Queue<String> = LinkedList()
        val startSb = StringBuilder()
        board.forEach {
            it.forEach { i -> startSb.append(i) }
        }
        queue.offer(startSb.toString())
        visited.add(startSb.toString())
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current == endString) {
                    return level
                }
                val zeroIndex = current.indexOf("0")
                swapIndexMap.getValue(zeroIndex).forEach {
                    val newSb = StringBuilder(current)
                    val temp = newSb[it[0]]
                    newSb.setCharAt(it[0], newSb[it[1]])
                    newSb.setCharAt(it[1], temp)
                    val newString = newSb.toString()
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
}

fun main() {
    val solution = SlidingPuzzleKotlin773()
    // -1
    println(
        solution.slidingPuzzle(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(5, 4, 0)
            )
        )
    )
    // 14
    println(
        solution.slidingPuzzle(
            arrayOf(
                intArrayOf(3, 2, 4),
                intArrayOf(1, 5, 0)
            )
        )
    )
    // 5
    println(
        solution.slidingPuzzle(
            arrayOf(
                intArrayOf(4, 1, 2),
                intArrayOf(5, 0, 3)
            )
        )
    )
}