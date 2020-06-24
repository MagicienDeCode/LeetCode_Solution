package depth_first_search

class UniqueBinarySearchTreesIIKotlin95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) {
            return emptyList()
        }
        return dfs(1, n)
    }

    private fun dfs(left: Int, right: Int): List<TreeNode?> {
        val result: MutableList<TreeNode?> = ArrayList()
        if (left > right) {
            result.add(null)
            return result
        }
        for (index in left..right) {
            val leftResult: List<TreeNode?> = dfs(left, index - 1)
            val rightResult: List<TreeNode?> = dfs(index + 1, right)
            for (l in leftResult.indices) {
                for (r in rightResult.indices) {
                    val root = TreeNode(index)
                    root.left = leftResult[l]
                    root.right = rightResult[r]
                    result.add(root)
                }
            }
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}