package tree

import java.util.*

class AddOneRowtoTreeKotlin623 {
    fun addOneRow(root: TreeNode, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            val newRoot = TreeNode(v)
            newRoot.left = root
            return newRoot
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var currentDepth = d
        while (queue.isNotEmpty()) {
            if (--currentDepth == 1) {
                break
            }
            for (size in queue.indices) {
                val node = queue.poll()
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        // now in queue is the level we should handle
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val left = current.left
            val right = current.right
            current.left = TreeNode(v)
            current.right = TreeNode(v)
            current.left.left = left
            current.right.right = right
        }
        return root
    }
}