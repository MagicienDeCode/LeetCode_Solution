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