package binary_tree

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