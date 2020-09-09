package tree

class HouseRobberIIIKotlin337 {
    fun rob(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val results = dfs(root)
        return maxOf(results[0], results[1])
    }

    /*
    results[0] : take current node value
    results[1] : do not take current, but take child nodes' values
     */
    private fun dfs(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf(0, 0)
        }
        if (root.left == null && root.right == null) {
            return intArrayOf(root.`val`, 0)
        }
        val leftResults = dfs(root.left)
        val rightResults = dfs(root.right)
        val results = IntArray(2)
        // take current, so we can't take child nodes' values
        results[0] = root.`val` + leftResults[1] + rightResults[1]
        // do not take current, take max of left/right
        results[1] = maxOf(leftResults[0], leftResults[1]) +
                maxOf(rightResults[0], rightResults[1])
        return results
    }
}