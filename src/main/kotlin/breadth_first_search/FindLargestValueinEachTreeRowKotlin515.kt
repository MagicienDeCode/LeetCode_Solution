package breadth_first_search

import java.util.*

class FindLargestValueinEachTreeRowKotlin515 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun largestValues(root: TreeNode?): List<Int> {
        val result: MutableList<Int> = LinkedList()
        if (root == null) {
            return result
        }
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        while (treeNodeQueue.isNotEmpty()) {
            var currentLevel = Int.MIN_VALUE
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                currentLevel = maxOf(currentLevel, current.`val`)
                current.left?.let { treeNodeQueue.offer(it) }
                current.right?.let { treeNodeQueue.offer(it) }
            }
            result.add(currentLevel)
        }
        return result
    }
}