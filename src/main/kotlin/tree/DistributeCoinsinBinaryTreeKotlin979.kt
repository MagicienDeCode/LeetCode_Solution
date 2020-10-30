package tree

class DistributeCoinsinBinaryTreeKotlin979 {
    var result = 0

    fun distributeCoins(root: TreeNode?): Int {
        result = 0
        dfs(root)
        return result
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val leftResult = dfs(node.left)
        val rightResult = dfs(node.right)
        result += Math.abs(leftResult) + Math.abs(rightResult)
        return node.`val` + leftResult + rightResult - 1
    }
}