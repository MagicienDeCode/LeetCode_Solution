package breadth_first_search

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class AllNodesDistanceKinBinaryTreeKotlin863 {
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        // build graph
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        val results: MutableList<Int> = LinkedList()
        if (root == null || target == null) {
            return results
        }
        buildGraph(root.left, root, graph)
        buildGraph(root.right, root, graph)

        // visited queue
        val visited: MutableSet<Int> = HashSet()
        val queue: Queue<Int> = LinkedList()
        queue.offer(target.`val`)
        visited.add(target.`val`)
        var level = 0
        while (queue.isNotEmpty()) {
            if (level == K) {
                for (size in queue.indices) {
                    results.add(queue.poll())
                }
                return results
            }
            for (size in queue.indices) {
                val current = queue.poll()
                graph[current]?.forEach {
                    if (!visited.contains(it)) {
                        queue.offer(it)
                        visited.add(it)
                    }
                }
            }
            ++level
        }
        return results
    }

    private fun buildGraph(root: TreeNode?, parent: TreeNode, graph: MutableMap<Int, MutableList<Int>>) {
        if (root == null) {
            return
        }
        graph.computeIfAbsent(root.`val`) { ArrayList() }.add(parent.`val`)
        graph.computeIfAbsent(parent.`val`) { ArrayList() }.add(root.`val`)
        buildGraph(root.left, root, graph)
        buildGraph(root.right, root, graph)
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}