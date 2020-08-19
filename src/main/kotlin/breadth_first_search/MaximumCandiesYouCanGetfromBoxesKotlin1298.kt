package breadth_first_search

import java.util.*

class MaximumCandiesYouCanGetfromBoxesKotlin1298 {
    fun maxCandies(
        status: IntArray,
        candies: IntArray,
        keys: Array<IntArray>,
        containedBoxes: Array<IntArray>,
        initialBoxes: IntArray
    ): Int {
        if (initialBoxes.isEmpty()) {
            return 0
        }

        val unVisitedBox: MutableList<Int> = ArrayList()
        val myKeys = BooleanArray(status.size)

        val queue: Queue<Int> = LinkedList()
        val visited = BooleanArray(status.size)

        for (i in initialBoxes) {
            if (status[i] == 1) {
                queue.offer(i)
                visited[i] = true
            } else {
                unVisitedBox.add(i)
            }
        }

        var result = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            result += candies[current]
            for (nextInContainer in containedBoxes[current]) {
                if (!visited[nextInContainer]) {
                    if (status[nextInContainer] == 1 || myKeys[nextInContainer]) {
                        queue.offer(nextInContainer)
                        visited[nextInContainer] = true
                    } else {
                        unVisitedBox.add(nextInContainer)
                    }
                }
            }
            for (key in keys[current]) {
                myKeys[key] = true
            }
            for (i in unVisitedBox) {
                if (!visited[i] && myKeys[i]) {
                    queue.offer(i)
                    visited[i] = true
                }
            }
        }
        return result
    }
}

fun main() {
    val java = MaximumCandiesYouCanGetfromBoxes1298()
    // 16
    println(
        java.maxCandies(
            intArrayOf(1, 0, 1, 0),
            intArrayOf(7, 5, 4, 100),
            arrayOf(intArrayOf(), intArrayOf(), intArrayOf(1), intArrayOf()),
            arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(), intArrayOf()),
            intArrayOf(0)
        )
    )
}