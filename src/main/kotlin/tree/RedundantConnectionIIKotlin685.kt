package tree

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class RedundantConnectionIIKotlin685 {
    fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
        // edge[1] -> edge[0] (parent)
        val parent = HashMap<Int, Int>()
        val candidates: MutableList<IntArray> = LinkedList()
        for (edge in edges) {
            if (parent.containsKey(edge[1])) {
                candidates.add(intArrayOf(parent[edge[1]]!!, edge[1]))
                candidates.add(edge)
            } else {
                parent[edge[1]] = edge[0]
            }
        }
        val root = orbit(1, parent).node
        // if each node has exactly one parent, candidate is empty, so return the last edge that
        // edge[0] && edge[1] are both in seen
        if (candidates.isEmpty()) {
            val cycle = orbit(root, parent).seen
            var ans: IntArray = intArrayOf(0, 0)
            for (edge in edges) {
                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                    ans = edge
                }
            }
            return ans
        }
        // there are two candidates, remove the last edge
        // 1. if can NOT connect all nodes, remove another node, return candidates[0]
        // 2. else, return candidates[1]
        val graph = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            graph.computeIfAbsent(edge[0]) { ArrayList() }.add(edge[1])
        }
        // remove last candidates[1]
        graph[candidates[1][0]]!!.remove(Integer.valueOf(candidates[1][1]))
        // check the rest of graph is connect or not ?
        val visited = BooleanArray(edges.size + 1)
        val queue: Queue<Int> = LinkedList()
        queue.offer(root)
        visited[root] = true
        while (!queue.isEmpty()) {
            val currentSize = queue.size
            for (i in 0 until currentSize) {
                val current = queue.poll()
                if (graph.containsKey(current)) {
                    for (neighbor in graph[current]!!) {
                        if (!visited[neighbor]) {
                            queue.offer(neighbor)
                            visited[neighbor] = true
                        }
                    }
                }
            }
        }
        for (i in 1 until visited.size) {
            if (!visited[i]) {
                return candidates[0]
            }
        }
        return candidates[1]
    }

    /*
    find root!!
    start from node 1, if its parent is exist and not visited, then go next.
     */
    private fun orbit(nodeVal: Int, parent: Map<Int, Int>): OrbitResult {
        var node = nodeVal
        val seen: MutableSet<Int> = HashSet()
        while (parent.containsKey(node) && !seen.contains(node)) {
            seen.add(node)
            node = parent.getValue(node)
        }
        return OrbitResult(node, seen)
    }

    class OrbitResult(var node: Int, var seen: MutableSet<Int>)
}