package tree

import java.util.*

class BinaryTreePathsKotlin257 {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val results: MutableList<String> = LinkedList()
        val subsets: MutableList<String> = ArrayList()
        dfs(root, subsets, results)
        return results
    }

    private fun dfs(
        root: TreeNode?,
        subsets: MutableList<String>,
        results: MutableList<String>
    ) {
        if (root == null) {
            return
        }
        if (root.left == null && root.right == null) {
            subsets.add(root.`val`.toString())
            results.add(subsets.joinToString(separator = ""))
        } else {
            subsets.add(root.`val`.toString() + "->")
            dfs(root.left, subsets, results)
            dfs(root.right, subsets, results)
        }
        subsets.removeAt(subsets.size - 1)
    }
}