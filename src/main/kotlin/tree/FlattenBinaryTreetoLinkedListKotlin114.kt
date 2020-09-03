package tree

import java.util.*

class FlattenBinaryTreetoLinkedListKotlin114 {
    fun flatten(root: TreeNode?) {
        val values: MutableList<Int> = ArrayList()
        val nodes: MutableList<TreeNode> = ArrayList()
        var current = root
        val stack = Stack<TreeNode>()
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                values.add(current.`val`)
                nodes.add(current)
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            current = current.right
        }
        for (i in values.indices) {
            val node = nodes[i]
            node.`val` = values[i]
            if (i != values.size - 1) {
                node.left = null
                node.right = nodes[i + 1]
            } else {
                node.right = null
                node.left = null
            }
        }
    }
}