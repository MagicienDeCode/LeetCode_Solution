package tree

import java.util.*

class NaryTreePostorderTraversalKotlin590 {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun postorder(root: Node?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        if (root == null) {
            return results
        }
        for (child in root.children) {
            results.addAll(postorder(child)!!)
        }
        results.add(root.`val`)
        return results
    }
}