package tree

class SecondMinimumNodeInaBinaryTreeKotlin671 {
    var min1 = 0
    var ans = Long.MAX_VALUE

    fun dfs(root: TreeNode?) {
        if (root != null) {
            if (root.`val` in (min1 + 1) until ans) {
                ans = root.`val`.toLong()
            } else if (min1 == root.`val`) {
                dfs(root.left)
                dfs(root.right)
            }
        }
    }

    fun findSecondMinimumValue(root: TreeNode): Int {
        min1 = root.`val`
        dfs(root)
        return if (ans < Long.MAX_VALUE) ans.toInt() else -1
    }
}
