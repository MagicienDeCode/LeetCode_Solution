package graph

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class EvaluateDivisionKotlin399 {
    fun calcEquation(
            equations: List<List<String>>,
            values: DoubleArray,
            queries: List<List<String>>
    ): DoubleArray {
        val graph = HashMap<String, MutableList<String>?>()
        val sideValues = HashMap<String, Double>()
        for (i in equations.indices) {
            graph.computeIfAbsent(equations[i][0]) { ArrayList() }!!.add(equations[i][1])
            graph.computeIfAbsent(equations[i][1]) { ArrayList() }!!.add(equations[i][0])
            sideValues[equations[i][0] + equations[i][1]] = values[i]
            sideValues[equations[i][1] + equations[i][0]] = 1.0 / values[i]
        }
        return queries.map { bfs(graph, sideValues, it) }.toDoubleArray()
    }

    private fun bfs(
            graph: HashMap<String, MutableList<String>?>,
            sideValues: HashMap<String, Double>,
            query: List<String>
    ): Double {
        val start = query[0]
        val end = query[1]
        if (!graph.containsKey(start)) {
            return -1.0
        }
        if (start == end) {
            return 1.0
        }
        val queue: Queue<Pair<String, Double>> = LinkedList()
        val visited = HashSet<String>()
        queue.offer(Pair(start, 1.0))
        visited.add(start)
        while (queue.isNotEmpty()) {
            for (i in queue.indices) {
                val current = queue.poll()
                val currentString = current.first
                val currentValue = current.second
                if (currentString == end) {
                    return currentValue
                }
                if (graph.containsKey(currentString)) {
                    for (next in graph[currentString]!!) {
                        if (!visited.contains(next)) {
                            queue.offer(Pair(next, currentValue * sideValues["$currentString$next"]!!))
                            visited.add(next)
                        }
                    }
                }
            }
        }
        return -1.0
    }
}