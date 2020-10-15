package tree

class SmallestSubtreewithalltheDeepestNodesKotlin865 {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return dfs(root).node
    }

    private fun dfs(root: TreeNode?): Result {
        if (root == null) {
            return Result(null, 0)
        }
        val leftResult = dfs(root.left)
        val rightResult = dfs(root.right)
        return when {
            leftResult.depth == rightResult.depth -> {
                Result(root, leftResult.depth + 1)
            }
            leftResult.depth > rightResult.depth -> {
                Result(leftResult.node, leftResult.depth + 1)
            }
            else -> {
                Result(rightResult.node, rightResult.depth + 1)
            }
        }
    }

    internal class Result(var node: TreeNode?, var depth: Int)
}