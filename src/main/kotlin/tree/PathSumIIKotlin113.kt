package tree

import java.util.*

class PathSumIIKotlin113 {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = LinkedList()
        val subsets: MutableList<Int> = LinkedList()
        helperDfs(root, 0, sum, subsets, results)
        return results
    }

    private fun helperDfs(
        root: TreeNode?,
        current: Int,
        sum: Int,
        subsets: MutableList<Int>,
        results: MutableList<List<Int>>
    ) {
        if (root == null) {
            return
        }
        subsets.add(root.`val`)
        val currentSum = current + root.`val`
        if (root.left == null && root.right == null) {
            if (currentSum == sum) {
                results.add(ArrayList(subsets))
            }
            subsets.removeAt(subsets.size - 1)
            return
        }
        helperDfs(root.left, currentSum, sum, subsets, results)
        helperDfs(root.right, currentSum, sum, subsets, results)
        subsets.removeAt(subsets.size - 1)
    }
}