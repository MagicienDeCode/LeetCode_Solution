package tree

class MaximumBinaryTreeIIKotlin998 {
    fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || `val` > root.`val`) {
            val newRoot = TreeNode(`val`)
            newRoot.left = root
            return newRoot
        }
        root.right = insertIntoMaxTree(root.right, `val`)
        return root
    }
}