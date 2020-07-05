package breadth_first_search

import java.util.*

class SymmetricTreeKotlin101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root.left)
        queue.offer(root.right)
        while (queue.isNotEmpty()) {
            val left = queue.poll()
            val right = queue.poll()
            if (left == null && right == null) {
                continue
            }
            if (left == null || right == null || left.`val` != right.`val`) {
                return false
            }
            queue.offer(left.left)
            queue.offer(right.right)
            queue.offer(left.right)
            queue.offer(right.left)
        }
        return true
    }

    /*
    recursively
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isSymmetric(root.left, root.right)
    }

    private fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        return when {
            left == null && right == null -> true
            left != null && right != null ->
                left.`val` == right.`val` &&
                        isSymmetric(left.left, right.right) &&
                        isSymmetric(left.right, right.left)
            else -> false
        }
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    /*
    val node1 = SymmetricTreeKotlin101.TreeNode(1)
    val node21 = SymmetricTreeKotlin101.TreeNode(2)
    val node22 = SymmetricTreeKotlin101.TreeNode(2)
    val node31 = SymmetricTreeKotlin101.TreeNode(3)
    val node32 = SymmetricTreeKotlin101.TreeNode(4)
    node1.left = node21
    node21.right = node31
    node1.right = node22
    node22.right = node32
     */
    val node1 = SymmetricTreeKotlin101.TreeNode(1)
    val node21 = SymmetricTreeKotlin101.TreeNode(2)
    val node22 = SymmetricTreeKotlin101.TreeNode(2)
    val node31 = SymmetricTreeKotlin101.TreeNode(3)
    val node32 = SymmetricTreeKotlin101.TreeNode(3)
    val node41 = SymmetricTreeKotlin101.TreeNode(4)
    val node42 = SymmetricTreeKotlin101.TreeNode(4)
    node1.left = node21
    // node21.right = node41
    node21.left = node31
    node1.right = node22
    // node22.left = node42
    node22.left = node32
    val solution = SymmetricTreeKotlin101()
    println(solution.isSymmetric(node1))
}