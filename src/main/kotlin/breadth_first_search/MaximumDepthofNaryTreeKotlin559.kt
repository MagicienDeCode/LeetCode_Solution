package breadth_first_search

import java.util.*

class MaximumDepthofNaryTreeKotlin559 {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun maxDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<Node> = LinkedList()
        queue.offer(root)
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                current.children.forEach { queue.offer(it) }
            }
            ++level
        }
        return level
    }
}