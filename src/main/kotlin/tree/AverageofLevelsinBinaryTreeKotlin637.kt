package tree

import java.util.*

class AverageofLevelsinBinaryTreeKotlin637 {
    fun averageOfLevels(root: TreeNode?): List<Double> {
        val results: MutableList<Double> = LinkedList()
        if (root == null) {
            return results
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val levelValues: MutableList<Int> = ArrayList()
            val currentSize = queue.size
            for (size in 0 until currentSize) {
                val node = queue.poll()
                levelValues.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            results.add(levelValues.map { it.toDouble() }.average())
        }
        return results
    }
}