package tree

import java.util.*

class UnivaluedBinaryTreeKotlin965 {
    fun isUnivalTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val value = root.`val`
        val stack = Stack<TreeNode>()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                // preorder here
                if (current.`val` != value) {
                    return false
                }
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            current = current.right
        }
        return true
    }
}