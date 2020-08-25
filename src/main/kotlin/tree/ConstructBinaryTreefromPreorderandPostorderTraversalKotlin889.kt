package tree

class ConstructBinaryTreefromPreorderandPostorderTraversalKotlin889 {
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        // preorder root left right
        // postorder  left right root
        return construct(
            pre,
            0,
            pre.size - 1,
            post,
            0,
            post.size - 1
        )
    }

    private fun construct(
        preorder: IntArray,
        preStart: Int,
        preEnd: Int,
        postorder: IntArray,
        postStart: Int,
        postEnd: Int
    ): TreeNode? {
        if (preStart > preEnd || postStart > postEnd) {
            return null
        }
        val treeNode = TreeNode(preorder[preStart])
        if (preStart == preEnd) {
            return treeNode
        }
        /*
        preorder = 1 245 367
        postorder = 452 673 1
        root = 1
        leftStartValue = 2
        then just find the 2 in postorder
         */
        var indexInPost = postStart
        val leftStartValue = preorder[preStart + 1]
        while (indexInPost < preorder.size && postorder[indexInPost] != leftStartValue) {
            ++indexInPost
        }
        treeNode.left = construct(
            preorder,
            preStart + 1,
            preStart + 1 + indexInPost - postStart,
            postorder,
            postStart,
            indexInPost
        )
        treeNode.right = construct(
            preorder,
            preStart + 2 + indexInPost - postStart,
            preEnd,
            postorder,
            indexInPost + 1,
            postEnd - 1
        )
        return treeNode
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}