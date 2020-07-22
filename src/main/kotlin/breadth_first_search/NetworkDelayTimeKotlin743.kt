package breadth_first_search

import java.util.*
import kotlin.collections.HashMap

class NetworkDelayTimeKotlin743 {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val graph: MutableMap<Int, MutableList<IntArray>> = HashMap()
        times.forEach {
            graph.computeIfAbsent(it[0]) { mutableListOf() }.add(it)
        }
        val distanceMap: MutableMap<Int, Int> = HashMap()
        // [0] = distance, [1] = currentNode
        val priorityQueue: PriorityQueue<IntArray> = PriorityQueue(
            kotlin.Comparator { ints1, ints2 -> compareValues(ints1[0], ints2[0]) }
        )
        priorityQueue.add(intArrayOf(0, K))
        while (priorityQueue.isNotEmpty()) {
            val current = priorityQueue.poll()
            if (!distanceMap.containsKey(current[1])) {
                distanceMap[current[1]] = current[0]
                if (graph.containsKey(current[1])) {
                    graph.getValue(current[1]).forEach {
                        if (!distanceMap.containsKey(it[1])) {
                            priorityQueue.offer(intArrayOf(current[0] + it[2], it[1]))
                        }
                    }
                }
            }
        }

        if (distanceMap.size != N) {
            return -1
        }
        return distanceMap.values.reduce { acc, i -> maxOf(acc, i) }
    }
}

fun main() {
    val solution = NetworkDelayTimeKotlin743()
    println(
        solution.networkDelayTime(
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(2, 3, 2),
                intArrayOf(1, 3, 2)
            ),
            3,
            1
        )
    )
    println(
        solution.networkDelayTime(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(2, 3, 1),
                intArrayOf(3, 4, 1)
            ),
            4,
            2
        )
    )
}