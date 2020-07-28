package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class BusRoutesKotlin815 {
    fun numBusesToDestination(routes: Array<IntArray>, S: Int, T: Int): Int {
        if (S == T) {
            return 0
        }
        val buses: MutableList<MutableSet<Int>> = ArrayList()
        // bus index => stops HashSet
        routes.forEach {
            val stops: MutableSet<Int> = HashSet()
            it.forEach { s -> stops.add(s) }
            buses.add(stops)
        }
        // build the graph, bus connect bus
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (i in 0..routes.size - 2) {
            for (j in i + 1 until routes.size) {
                if (isConnected(buses[i], buses[j])) {
                    graph.computeIfAbsent(i) { ArrayList() }.add(j)
                    graph.computeIfAbsent(j) { ArrayList() }.add(i)
                }
            }
        }
        // visited, queue, endSet
        // bus not stops
        val visited: MutableSet<Int> = HashSet()
        val queue: Queue<Int> = LinkedList()
        val endSet: MutableSet<Int> = HashSet()

        // add start to queue visited, end to endSet
        buses.forEachIndexed { index, mutableSet ->
            val containsStart = mutableSet.contains(S)
            val containsEnd = mutableSet.contains(T)
            if (containsEnd && containsStart) {
                return 1
            }
            if (containsEnd) {
                endSet.add(index)
            }
            if (containsStart) {
                queue.offer(index)
                visited.add(index)
            }
        }
        // bfs
        var level = 1
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val currentBus = queue.poll()
                if (endSet.contains(currentBus)) {
                    return level
                }
                graph[currentBus]?.let {
                    it.forEach { nextBus ->
                        if (!visited.contains(nextBus)) {
                            queue.offer(nextBus)
                            visited.add(nextBus)
                        }
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun isConnected(stop1: Set<Int>, stop2: Set<Int>): Boolean {
        stop1.forEach {
            if (stop2.contains(it)) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val solution = BusRoutesKotlin815()
    println(
        solution.numBusesToDestination(
            arrayOf(
                intArrayOf(1, 2, 7),
                intArrayOf(3, 6, 7)
            ),
            1,
            6
        )
    )
}