package tree

class PathSumKotlin112 {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        return helper(root, 0, sum)
    }

    private fun helper(root: TreeNode?, current: Int, sum: Int): Boolean = when {
        root == null -> false
        root.left == null && root.right == null -> current + root.`val` == sum
        else -> helper(root.left, current + root.`val`, sum) ||
                helper(root.right, current + root.`val`, sum)
    }
}