package tree

import java.util.*

class TwoSumIVInputisaBSTKotlin653 {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val set = java.util.HashSet<Int>()
        val stack = Stack<TreeNode>()
        var current = root
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // preorder here
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            // BST / inorder here
            if (set.contains(k - current.`val`)) {
                return true
            }
            set.add(current.`val`)
            current = current.right
        }
        return false
    }
}