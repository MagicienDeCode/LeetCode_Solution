package breadth_first_search

import java.util.*

class SumofRootToLeafBinaryNumbersKotlin1022 {

    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.offer(Pair(root, 0))
        var sum = 0
        while (queue.isNotEmpty()) {
            val currentPair = queue.poll()
            val currentNode = currentPair.first
            val currentString = currentPair.second + currentNode.`val`
            val leftNode = currentNode.left
            val rightNode = currentNode.right

            if (leftNode == null && rightNode == null) {
                sum += currentString
            }
            if (leftNode != null) {
                queue.offer(Pair(leftNode, currentString.shl(1)))
            }
            if (rightNode != null) {
                queue.offer(Pair(rightNode, currentString.shl(1)))
            }
        }
        return sum
    }
    /*
    fun sumRootToLeaf(root: TreeNode?): Int {
        root ?: return 0
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode, value: Int): Int {
        val currentVal = value + node.`val`
        val leftNode = node.left
        val rightNode = node.right

        if (leftNode == null && rightNode == null) {
            return currentVal
        }
        val leftVal = if (leftNode == null) 0 else dfs(leftNode, 2 * currentVal)
        val rightVal = if (rightNode == null) 0 else dfs(rightNode, 2 * currentVal)
        return leftVal + rightVal
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}