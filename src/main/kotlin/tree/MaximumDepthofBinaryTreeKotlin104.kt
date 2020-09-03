package tree

import java.util.*

class MaximumDepthofBinaryTreeKotlin104 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
            }
            ++level
        }
        return level
    }
}