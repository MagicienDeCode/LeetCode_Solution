package tree

class ValidateBinarySearchTreeKotlin98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return helper(root, null, null)
    }

    private fun helper(root: TreeNode?, min: Int?, max: Int?): Boolean = when {
        root == null -> true
        min != null && root.`val` <= min -> false
        max != null && root.`val` >= max -> false
        else -> helper(root.left, min, root.`val`) &&
                helper(root.right, root.`val`, max)
    }
}