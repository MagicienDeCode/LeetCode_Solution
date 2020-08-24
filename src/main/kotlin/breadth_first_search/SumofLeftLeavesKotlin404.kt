package breadth_first_search

import java.util.*

class SumofLeftLeavesKotlin404 {

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        var result = 0
        if (root == null) {
            return result
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            current.left?.let {
                if (it.left == null && it.right == null) {
                    result += it.`val`
                }
                queue.offer(it)
            }
            current.right?.let {
                queue.offer(it)
            }
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}