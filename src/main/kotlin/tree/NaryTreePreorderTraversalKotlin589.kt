package tree

import java.util.*

class NaryTreePreorderTraversalKotlin589 {
    fun preorder(root: Node?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        if (root == null) {
            return results
        }
        val stack = Stack<Node>()
        stack.push(root)
        while (!stack.isEmpty()) {
            val current = stack.pop()
            results.add(current.`val`)
            for (i in current.children.indices.reversed()) {
                stack.push(current.children[i])
            }
        }
        return results
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}