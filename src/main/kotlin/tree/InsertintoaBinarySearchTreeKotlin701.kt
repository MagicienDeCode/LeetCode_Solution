package tree

class InsertintoaBinarySearchTreeKotlin701 {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (`val` > root.`val`) {
            root.right = insertIntoBST(root.right, `val`)
        } else {
            root.left = insertIntoBST(root.left, `val`)
        }
        return root
    }
}