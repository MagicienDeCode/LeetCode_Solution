package breadth_first_search

import java.util.*

class NaryTreeLevelOrderTraversalKotlin429 {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun levelOrder(root: Node?): List<List<Int>> {
        val results: MutableList<MutableList<Int>> = LinkedList()
        if (root == null) {
            return results
        }
        val queue: Queue<Node> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val levelResults: MutableList<Int> = LinkedList()
            for (size in queue.indices) {
                val current = queue.poll()
                levelResults.add(current.`val`)
                current.children.forEach { queue.offer(it) }
            }
            results.add(levelResults)
        }
        return results
    }
}