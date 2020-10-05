package tree

class LongestUnivaluePathKotlin687 {
    var max = 0

    fun longestUnivaluePath(root: TreeNode?): Int {
        max = 0
        dfs(root)
        return max
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftResult = dfs(root.left)
        val rightResult = dfs(root.right)
        return if (root.left != null && root.right != null && root.`val` == root.left.`val` && root.`val` == root.right.`val`) {
            max = Math.max(max, 2 + leftResult + rightResult)
            1 + Math.max(leftResult, rightResult)
        } else if (root.left != null && root.`val` == root.left.`val`) {
            max = Math.max(max, 1 + leftResult)
            1 + leftResult
        } else if (root.right != null && root.`val` == root.right.`val`) {
            max = Math.max(max, 1 + rightResult)
            1 + rightResult
        } else {
            0
        }
    }
}