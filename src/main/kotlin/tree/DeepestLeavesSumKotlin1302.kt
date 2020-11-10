package tree

import java.util.*

class DeepestLeavesSumKotlin1302 {
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var sum = 0
        while (queue.isNotEmpty()) {
            var currentSum = 0;
            for (i in queue.indices) {
                val node = queue.poll()
                currentSum += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            sum = currentSum
        }
        return sum
    }
}