package tree

import kotlin.math.abs

class BalancedBinaryTreeKotlin110 {
    private val notBalanced = -99

    fun isBalanced(root: TreeNode?): Boolean {
        return helper(root) != notBalanced
    }

    private fun helper(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftResult = helper(root.left)
        val rightResult = helper(root.right)

        // 3 situations return NOT_BALANCED
        return if (leftResult == notBalanced || rightResult == notBalanced || abs(leftResult - rightResult) > 1
        ) {
            notBalanced
        } else maxOf(leftResult, rightResult) + 1
    }
    /*
    fun isBalanced(root: TreeNode?): Boolean {
        return helper(root).isBalanced
    }

    fun helper(root: TreeNode?): Result {
        if (root == null) {
            return Result(true, 0)
        }
        val leftResult = helper(root.left)
        val rightResult = helper(root.right)

        // 3 situations return false
        return if (!leftResult.isBalanced ||
            !rightResult.isBalanced || abs(leftResult.height - rightResult.height) > 1
        ) {
            Result(false, -99)
        }
        // return true
        // return new Result(true, 0);
        else Result(true, maxOf(leftResult.height, rightResult.height) + 1)

    }

    data class Result(var isBalanced: Boolean, var height: Int)
     */
}