package tree

class MaximumDifferenceBetweenNodeandAncestorKotlin1026 {
    var result = 0

    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        result = 0
        dfs(root)
        return result
    }

    private fun dfs(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf(-1, -1)
        }
        val leftResult = dfs(root.left)
        val rightResult = dfs(root.right)
        val max = Math.max(leftResult[1], rightResult[1])
        if (max != -1) {
            result = Math.max(result, Math.abs(max - root.`val`))
        }
        val min = when {
            leftResult[0] == -1 -> {
                rightResult[0]
            }
            rightResult[0] == -1 -> {
                leftResult[0]
            }
            else -> {
                Math.min(leftResult[0], rightResult[0])
            }
        }
        if (min != -1) {
            result = Math.max(result, Math.abs(min - root.`val`))
        }
        return intArrayOf(if (min == -1) root.`val` else Math.min(root.`val`, min), Math.max(root.`val`, max))
    }
}