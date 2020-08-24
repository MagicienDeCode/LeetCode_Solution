package tree

import java.util.*

class BinaryTreePostorderTraversalKotlin145 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        val stack: Stack<TreeNode> = Stack()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                results.add(0, current.`val`)
                current = current.right
            }
            current = stack.pop().left
        }
        return results
    }
    /*
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        if (root == null) {
            return results
        }

        val leftResults = postorderTraversal(root.left)
        val rightResults = postorderTraversal(root.right)

        results.addAll(leftResults)
        results.addAll(rightResults)
        results.add(root.`val`)

        return results
    }
     */
    /*
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        leftRootRight(root,results)
        return results
    }

    private fun leftRootRight(root: TreeNode?, results: MutableList<Int>) {
        if (root == null){
            return
        }
        leftRootRight(root.left,results)
        leftRootRight(root.right,results)
        results.add(root.`val`)
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val node1 = BinaryTreePostorderTraversalKotlin145.TreeNode(1)
    val node2 = BinaryTreePostorderTraversalKotlin145.TreeNode(2)
    val node3 = BinaryTreePostorderTraversalKotlin145.TreeNode(3)
    val node4 = BinaryTreePostorderTraversalKotlin145.TreeNode(4)
    val node5 = BinaryTreePostorderTraversalKotlin145.TreeNode(5)
    val node6 = BinaryTreePostorderTraversalKotlin145.TreeNode(6)
    val node7 = BinaryTreePostorderTraversalKotlin145.TreeNode(7)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    val solution = BinaryTreePostorderTraversalKotlin145()
    solution.postorderTraversal(node1).forEach(::print)
}