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