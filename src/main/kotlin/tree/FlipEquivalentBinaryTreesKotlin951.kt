package tree

class FlipEquivalentBinaryTreesKotlin951 {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 === root2) {
            return true
        }
        return if (root1 == null || root2 == null || root1.`val` != root2.`val`) {
            false
        } else flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
    }
}