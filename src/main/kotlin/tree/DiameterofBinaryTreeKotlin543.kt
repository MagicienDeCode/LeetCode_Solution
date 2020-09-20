package tree

class DiameterofBinaryTreeKotlin543 {
    private var max = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return if (max == 0) 0 else max - 1
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftResult = dfs(root.left)
        val rightResult = dfs(root.right)
        max = maxOf(max, leftResult + rightResult + 1)
        return maxOf(leftResult, rightResult) + 1
    }
}