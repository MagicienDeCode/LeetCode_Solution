package breadth_first_search

import java.util.*

class SequentialDigitsKotlin1291 {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val results: MutableList<Int> = LinkedList()
        val queue: Queue<Int> = LinkedList()
        for (i in 1..9) {
            queue.offer(i)
        }
        while (!queue.isEmpty()) {
            val current = queue.poll()
            if (current > high) {
                break
            }
            if (current in low..high) {
                results.add(current)
            }
            // 789 continue
            // 67 -> 678
            if (current % 10 != 9) {
                queue.offer(current * 10 + current % 10 + 1)
            }
        }
        return results
    }
}