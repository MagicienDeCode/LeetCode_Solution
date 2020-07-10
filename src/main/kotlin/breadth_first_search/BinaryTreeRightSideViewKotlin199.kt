package breadth_first_search

import java.util.*

class BinaryTreeRightSideViewKotlin199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result: MutableList<Int> = LinkedList()
        if (root == null) {
            return result
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            var levelValue = 0
            for (time in 0 until queue.size) {
                val current = queue.poll()
                levelValue = current.`val`
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
            }
            result.add(levelValue)
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}