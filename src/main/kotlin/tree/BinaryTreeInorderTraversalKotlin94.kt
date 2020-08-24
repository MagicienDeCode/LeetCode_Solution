package tree

import java.util.*

class BinaryTreeInorderTraversalKotlin94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        val stack: Stack<TreeNode> = Stack()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            results.add(current.`val`)
            current = current.right
        }
        return results
    }
    /*
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        if (root == null) {
            return results
        }

        val leftResults = inorderTraversal(root.left)
        val rightResults = inorderTraversal(root.right)

        results.addAll(leftResults)
        results.add(root.`val`)
        results.addAll(rightResults)

        return results
    }
     */
    /*
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        leftRootRight(root,results)
        return results
    }

    private fun leftRootRight(root: TreeNode?, results: MutableList<Int>) {
        if (root == null){
            return
        }
        leftRootRight(root.left,results)
        results.add(root.`val`)
        leftRootRight(root.right,results)
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val node1 = BinaryTreeInorderTraversalKotlin94.TreeNode(1)
    val node2 = BinaryTreeInorderTraversalKotlin94.TreeNode(2)
    val node3 = BinaryTreeInorderTraversalKotlin94.TreeNode(3)
    val node4 = BinaryTreeInorderTraversalKotlin94.TreeNode(4)
    val node5 = BinaryTreeInorderTraversalKotlin94.TreeNode(5)
    val node6 = BinaryTreeInorderTraversalKotlin94.TreeNode(6)
    val node7 = BinaryTreeInorderTraversalKotlin94.TreeNode(7)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    val solution = BinaryTreeInorderTraversalKotlin94()
    solution.inorderTraversal(node1).forEach(::print)
}