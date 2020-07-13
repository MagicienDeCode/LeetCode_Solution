package breadth_first_search

import java.util.*
import kotlin.collections.HashMap

class CourseScheduleIIKotlin210 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val result: MutableList<Int> = LinkedList()
        val indegrees = IntArray(numCourses)
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (pre in prerequisites) {
            graph.computeIfAbsent(pre[1]) { mutableListOf() }.add(pre[0])
            ++indegrees[pre[0]]
        }
        val queue: Queue<Int> = LinkedList()
        indegrees.forEachIndexed { index, i ->
            if (i == 0) {
                queue.offer(index)
            }
        }
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            result.add(current)
            graph[current]?.forEach {
                if (--indegrees[it] == 0) {
                    queue.offer(it)
                }
            }
        }
        return if (result.size == numCourses) {
            result.toIntArray()
        } else {
            intArrayOf()
        }
    }
}

fun main() {
    val solution = CourseScheduleIIKotlin210()
    solution.findOrder(
        4, arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2)
        )
    ).forEach(::print)
}