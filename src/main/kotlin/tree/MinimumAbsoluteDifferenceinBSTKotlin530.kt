package tree

class MinimumAbsoluteDifferenceinBSTKotlin530 {
    var min = Int.MAX_VALUE
    var previous: TreeNode? = null

    fun getMinimumDifference(root: TreeNode?): Int {
        min = Int.MAX_VALUE
        inorder(root)
        return min
    }

    private fun inorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        // preorder here
        inorder(root.left)
        // inorder here
        if (previous != null) {
            min = Math.min(min, root.`val` - previous!!.`val`)
        }
        previous = root
        inorder(root.right)
    }
}