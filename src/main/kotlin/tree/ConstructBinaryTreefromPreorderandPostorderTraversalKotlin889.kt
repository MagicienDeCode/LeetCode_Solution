package tree

class ConstructBinaryTreefromPreorderandPostorderTraversalKotlin889 {
    var rootIndex = 0

    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        rootIndex = 0
        return construct(
            pre,
            post,
            0,
            post.size - 1
        )
    }

    private fun construct(
        pre: IntArray,
        post: IntArray,
        pStart: Int,
        pEnd: Int
    ): TreeNode? {
        if (pStart > pEnd) {
            return null
        }
        val treeNode = TreeNode(pre[rootIndex++])
        if (pStart == pEnd) {
            return treeNode
        }
        var index = pStart
        while (index < post.size && post[index] != pre[rootIndex]) {
            ++index
        }
        treeNode.left = construct(pre, post, pStart, index)
        treeNode.right = construct(pre, post, index + 1, pEnd - 1)
        return treeNode
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}