package tree

class BinaryTreeMaximumPathSumKotlin124 {
    private var result = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        result = Int.MIN_VALUE
        dfs(root)
        return result
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftResult = maxOf(0, dfs(root.left))
        val rightResult = maxOf(0, dfs(root.right))
        result = maxOf(result, leftResult + rightResult + root.`val`)
        return maxOf(leftResult, rightResult) + root.`val`
    }
}