package tree

import java.util.*

class BinaryTreePreorderTraversalKotlin144 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        val stack: Stack<TreeNode> = Stack()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                results.add(current.`val`)
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            current = current.right
        }
        return results
    }
    /*
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        if (root == null) {
            return results
        }

        val leftResults = preorderTraversal(root.left)
        val rightResults = preorderTraversal(root.right)

        results.add(root.`val`)
        results.addAll(leftResults)
        results.addAll(rightResults)

        return results
    }
     */
    /*
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val results: MutableList<Int> = LinkedList()
        leftRootRight(root,results)
        return results
    }

    private fun leftRootRight(root: TreeNode?, results: MutableList<Int>) {
        if (root == null){
            return
        }
        results.add(root.`val`)
        leftRootRight(root.left,results)
        leftRootRight(root.right,results)
    }
     */

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    val node1 = BinaryTreePreorderTraversalKotlin144.TreeNode(1)
    val node2 = BinaryTreePreorderTraversalKotlin144.TreeNode(2)
    val node3 = BinaryTreePreorderTraversalKotlin144.TreeNode(3)
    val node4 = BinaryTreePreorderTraversalKotlin144.TreeNode(4)
    val node5 = BinaryTreePreorderTraversalKotlin144.TreeNode(5)
    val node6 = BinaryTreePreorderTraversalKotlin144.TreeNode(6)
    val node7 = BinaryTreePreorderTraversalKotlin144.TreeNode(7)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    val solution = BinaryTreePreorderTraversalKotlin144()
    solution.preorderTraversal(node1).forEach(::print)
}