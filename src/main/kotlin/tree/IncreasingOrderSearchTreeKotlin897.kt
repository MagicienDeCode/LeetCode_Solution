package tree

import java.util.*

class IncreasingOrderSearchTreeKotlin897 {
    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val allNodes: MutableList<TreeNode> = ArrayList()
        inorder(root, allNodes)
        for (i in 0 until allNodes.size - 1) {
            val parent = allNodes[i]
            val child = allNodes[i + 1]
            parent.left = null
            parent.right = child
        }
        val lastNode = allNodes[allNodes.size - 1]
        lastNode.right = null
        lastNode.left = null
        return allNodes[0]
    }

    private fun inorder(root: TreeNode?, allNodes: MutableList<TreeNode>) {
        if (root == null) {
            return
        }
        inorder(root.left, allNodes)
        allNodes.add(root)
        inorder(root.right, allNodes)
    }
}