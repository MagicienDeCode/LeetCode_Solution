package tree

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class RedundantConnectionKotlin684 {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray? {
        val graph: Array<MutableList<Int>> = Array(edges.size + 1) { ArrayList<Int>() }
        for (edge in edges) {
            if (graph[edge[0]].isNotEmpty() && graph[edge[1]].isNotEmpty() && bfs(graph, edge[0], edge[1])) {
                return edge
            }
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        return edges[0]
    }

    private fun bfs(graph: Array<MutableList<Int>>, start: Int, end: Int): Boolean {
        val queue: Queue<Int> = LinkedList()
        val set = HashSet<Int>()
        queue.offer(start)
        set.add(start)
        while (queue.isNotEmpty()) {
            for (i in queue.indices) {
                val current = queue.poll()
                if (current == end) {
                    return true
                }
                for (neighbor in graph[current]) {
                    if (!set.contains(neighbor)) {
                        queue.offer(neighbor)
                        set.add(neighbor)
                    }
                }
            }
        }
        return false
    }
}