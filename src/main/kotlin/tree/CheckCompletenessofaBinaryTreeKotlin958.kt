package tree

import java.util.*


class CheckCompletenessofaBinaryTreeKotlin958 {
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        var count = 0
        var lastNodeValue = 1
        queue.offer(Pair(root, 1))
        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            val currentNode: TreeNode = pair.first
            val value: Int = pair.second
            count += 1
            lastNodeValue = value
            if (currentNode.left != null) {
                queue.offer(Pair(currentNode.left, value * 2))
            }
            if (currentNode.right != null) {
                queue.offer(Pair(currentNode.right, value * 2 + 1))
            }
        }
        return count == lastNodeValue
    }
}