package tree

import java.util.*

class CompleteBinaryTreeInserterKotlin919(root: TreeNode?) {

    private val rootVal: TreeNode? = root
    private val parents: Queue<TreeNode> = LinkedList()

    init {
        // bfs add the last level nodes into parents
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(rootVal)
        while (!queue.isEmpty()) {
            val current = queue.poll()
            if (current.left == null || current.right == null) {
                parents.offer(current)
            }
            if (current.left != null) {
                queue.offer(current.left)
            }
            if (current.right != null) {
                queue.offer(current.right)
            }
        }
    }

    fun insert(v: Int): Int {
        val current = TreeNode(v)
        parents.offer(current)
        val parent = parents.peek()
        if (parent.left == null) {
            parent.left = current
        } else {
            parent.right = current
            parents.poll()
        }
        return parent.`val`
    }

    fun get_root(): TreeNode? = rootVal
}