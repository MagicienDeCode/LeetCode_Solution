package tree

class BinaryTreeTiltKotlin563 {
    private var sum = 0

    fun findTilt(root: TreeNode?): Int {
        dfs(root)
        return sum
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftVal = dfs(root.left)
        val rightVal = dfs(root.right)
        sum += Math.abs(leftVal - rightVal)
        return leftVal + rightVal + root.`val`
    }
}