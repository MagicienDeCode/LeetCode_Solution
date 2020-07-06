package breadth_first_search

import java.util.*

class MinimumDepthofBinaryTreeKotlin111 {

    fun minDepth(root: TreeNode?): Int {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return 0
        }
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        var count = 1
        while (treeNodeQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                currentLevel.add(current.`val`)
                if (current.left == null && current.right == null) {
                    return count
                }
                current.left?.let { treeNodeQueue.offer(it) }
                current.right?.let { treeNodeQueue.offer(it) }
            }
            result.add(0, currentLevel)
            ++count
        }
        return count
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}