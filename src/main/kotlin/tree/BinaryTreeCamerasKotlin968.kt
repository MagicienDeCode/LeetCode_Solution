package tree

class BinaryTreeCamerasKotlin968 {
    private val MUST_HAVE_CAMERA = 1
    private val MUST_NOT_HAVE_CAMERA = -1
    private val CAMERA = 7

    private var result = 0

    fun minCameraCover(root: TreeNode?): Int {
        val dfs = dfs(root)
        if (dfs == MUST_HAVE_CAMERA) {
            result++
        }
        return result
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return MUST_NOT_HAVE_CAMERA
        }
        val leftResult = dfs(root.left)
        val rightResult = dfs(root.right)
        if (leftResult == MUST_HAVE_CAMERA || rightResult == MUST_HAVE_CAMERA) {
            result++
            return CAMERA
        }
        return if (leftResult == CAMERA || rightResult == CAMERA) {
            MUST_NOT_HAVE_CAMERA
        } else MUST_HAVE_CAMERA
    }
}