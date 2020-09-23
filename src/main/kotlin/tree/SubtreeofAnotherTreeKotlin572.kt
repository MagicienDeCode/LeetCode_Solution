package tree

import java.util.*

class SubtreeofAnotherTreeKotlin572 {
    fun isSubtree(s: TreeNode?, t: TreeNode): Boolean {
        val stack = Stack<TreeNode>()
        var current = s
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            if (current.`val` == t.`val`) {
                if (isSameTree(current, t)) {
                    return true
                }
            }
            current = current.right
        }
        return false
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        return if (p == null || q == null || p.`val` != q.`val`) {
            false
        } else isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}