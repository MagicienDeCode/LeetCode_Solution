package tree

import java.util.*

class PopulatingNextRightPointersinEachNodeIIKotlin117 {

    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        val queue: Queue<Node> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            var previous: Node? = null
            for (size in queue.indices) {
                val current = queue.poll()
                if (previous != null) {
                    previous.next = current
                }
                previous = current
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
            }
        }
        return root
    }

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }
}