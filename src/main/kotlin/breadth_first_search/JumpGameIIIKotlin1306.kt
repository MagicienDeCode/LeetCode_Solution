package breadth_first_search

import java.util.*

class JumpGameIIIKotlin1306 {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val queue: Queue<Int> = LinkedList()
        queue.offer(start)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (arr[current] == 0) {
                return true
            }
            val nextIndex1 = current + arr[current]
            val nextIndex2 = current - arr[current]
            arr[current] = -arr[current]
            if (inBound(arr, nextIndex1) && arr[nextIndex1] >= 0) {
                queue.offer(nextIndex1)
            }
            if (inBound(arr, nextIndex2) && arr[nextIndex2] >= 0) {
                queue.offer(nextIndex2)
            }
        }
        return false
    }

    private fun inBound(arr: IntArray, index: Int): Boolean = index >= 0 && index < arr.size
}

fun main() {
    val solution = JumpGameIIIKotlin1306()
    // true
    println(solution.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
}