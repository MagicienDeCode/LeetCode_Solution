package breadth_first_search

import java.util.*

class ShortestPathVisitingAllNodesKotlin847 {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        // endKey,visited,queue
        val endKey = 1.shl(graph.size) - 1
        val visited = Array(graph.size) { BooleanArray(1.shl(graph.size)) }
        // node, cover state
        val queue: Queue<IntArray> = LinkedList()
        // put all nodes into the queue
        for (i in graph.indices) {
            val cover = 1.shl(i)
            queue.offer(intArrayOf(i, cover))
            visited[i][cover] = true
        }
        // bfs
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current[1] == endKey) {
                    return level
                }
                graph[current[0]].forEach { next ->
                    val nextState = 1.shl(next).or(current[1])
                    if (!visited[next][nextState]) {
                        queue.offer(intArrayOf(next, nextState))
                        visited[next][nextState] = true
                    }
                }
            }
            ++level
        }
        return -1
    }
}

fun main() {
    val solution = ShortestPathVisitingAllNodesKotlin847()
    println(
        solution.shortestPathLength(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(0),
                intArrayOf(0),
                intArrayOf(0)
            )
        )
    )
}