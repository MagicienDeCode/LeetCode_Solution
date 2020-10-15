package tree

class BinaryTreePruningKotlin814 {
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        return if (prune(root)) root else null
    }

    private fun prune(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        val leftResult = prune(root.left)
        val rightResult = prune(root.right)
        if (!leftResult) {
            root.left = null
        }
        if (!rightResult) {
            root.right = null
        }
        return root.`val` == 1 || leftResult || rightResult
    }
}