package tree

class PopulatingNextRightPointersinEachNodeKotlin116 {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        var start: Node? = root
        var current: Node?
        while (start?.left != null) {
            current = start
            while (current != null) {
                current.left?.next = current.right
                if (current.next != null) {
                    current.right?.next = current.next?.left
                }
                current = current.next
            }
            start = start.left
        }
        return root
    }
    /*
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
     */

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }
}