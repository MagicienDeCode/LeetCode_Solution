package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class OpentheLockKotlin752 {

    private val mapNext = mapOf(
        '0' to charArrayOf('1', '9'),
        '1' to charArrayOf('2', '0'),
        '2' to charArrayOf('3', '1'),
        '3' to charArrayOf('4', '2'),
        '4' to charArrayOf('5', '3'),
        '5' to charArrayOf('6', '4'),
        '6' to charArrayOf('7', '5'),
        '7' to charArrayOf('8', '6'),
        '8' to charArrayOf('9', '7'),
        '9' to charArrayOf('0', '8')
    )

    fun openLock(deadEnds: Array<String>, target: String): Int {
        val deadEndsSet = deadEnds.toSet()
        if (deadEndsSet.contains("0000")) {
            return -1
        }
        val targetNextList: MutableList<String> = ArrayList(8)
        for (index in 0..3) {
            val new1 = StringBuilder(target)
            new1.setCharAt(index, mapNext.getValue(target[index])[0])
            val new2 = StringBuilder(target)
            new2.setCharAt(index, mapNext.getValue(target[index])[1])
            targetNextList.add(new1.toString())
            targetNextList.add(new2.toString())
        }
        if (deadEndsSet.size >= 8) {
            val flag = targetNextList.fold(true) { acc, s -> acc.and(deadEndsSet.contains(s)) }
            if (flag) {
                return -1
            }
        }
        val visited: MutableSet<String> = HashSet()
        val queue: Queue<String> = LinkedList()
        queue.offer("0000")
        visited.add("0000")
        var result = 0
        while (queue.isNotEmpty()) {
            for (size in 0 until queue.size) {
                val current = queue.poll()
                if (current == target) {
                    return result
                }
                for (index in 0..3) {
                    val new1 = StringBuilder(current)
                    new1.setCharAt(index, mapNext.getValue(current[index])[0])
                    val new2 = StringBuilder(current)
                    new2.setCharAt(index, mapNext.getValue(current[index])[1])
                    val news = arrayOf(
                        new1.toString(),
                        new2.toString()
                    )
                    news.forEach {
                        if (!visited.contains(it) && !deadEndsSet.contains(it)) {
                            queue.offer(it)
                            visited.add(it)
                        }
                    }
                }
            }
            ++result
        }
        return -1
    }
}

fun main() {
    val solution = OpentheLockKotlin752()
    println(
        solution.openLock(
            arrayOf("0000"),
            "8888"
        )
    )
    // 6
    println(
        solution.openLock(
            arrayOf("0201", "0101", "0102", "1212", "2002"),
            "0202"
        )
    )
    println(
        solution.openLock(
            arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"),
            "8888"
        )
    )
}