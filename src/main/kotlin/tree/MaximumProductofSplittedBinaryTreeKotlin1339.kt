package tree

class MaximumProductofSplittedBinaryTreeKotlin1339 {
    private val MOD: Long = 1000000007

    private var max: Long = 0

    private var sum: Long = 0

    fun maxProduct(root: TreeNode?): Int {
        sum = calculateSum(root)
        dfs(root)
        return (max % MOD).toInt()
    }

    private fun dfs(root: TreeNode?): Long {
        if (root == null) {
            return 0
        }
        val currentSum = root.`val` + dfs(root.left) + dfs(root.right)
        max = Math.max(max, currentSum * (sum - currentSum))
        return currentSum
    }

    private fun calculateSum(root: TreeNode?): Long {
        return if (root == null) {
            0
        } else root.`val` + calculateSum(root.left) + calculateSum(root.right)
    }
}