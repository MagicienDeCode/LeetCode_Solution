package tree

class MostFrequentSubtreeSumKotlin508 {
    fun findFrequentTreeSum(root: TreeNode?): IntArray? {
        if (root == null) {
            return IntArray(0)
        }
        val results: MutableMap<Int, Int> = HashMap()
        dfs(root, results)
        val maxCount = results.values.max()
        return results.entries
                .filter { it.value == maxCount }
                .map { it.key }
                .toIntArray()
    }

    private fun dfs(root: TreeNode?, results: MutableMap<Int, Int>): Int {
        if (root == null) {
            return 0
        }
        val leftResult = dfs(root.left, results)
        val rightResult = dfs(root.right, results)
        val sum = root.`val` + leftResult + rightResult
        results[sum] = 1 + results.getOrDefault(sum, 0)
        return sum
    }
}