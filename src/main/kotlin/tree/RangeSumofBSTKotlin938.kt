package tree

import java.util.*

class RangeSumofBSTKotlin938 {
    fun rangeSumBST(root: TreeNode?, l: Int, r: Int): Int {
        var result = 0
        if (root == null) {
            return 0
        }
        val stack = Stack<TreeNode>()
        var current = root
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                // preorder
                if (current.`val` in l..r) {
                    result += current.`val`
                }
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            current = current.right
        }
        return result
    }
}