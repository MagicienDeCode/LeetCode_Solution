package breadth_first_search

import java.util.*

class FindBottomLeftTreeValueKotlin513 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findBottomLeftValue(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var result = 0
        while (queue.isNotEmpty()) {
            for (time in 0 until queue.size) {
                val current = queue.poll()
                if (time == 0) {
                    result = current.`val`
                }
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
            }
        }
        return result
    }
}