package tree

class ConvertBSTtoGreaterTreeKotlin538 {
    private var sum = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        sum = 0
        inorder(root)
        return root
    }

    // reversed inorder !!
    private fun inorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        // preorder here
        inorder(root.right)
        // inorder here
        sum += root.`val`
        root.`val` = sum
        inorder(root.left)
    }
}