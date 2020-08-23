package tree

class ConstructBinaryTreefromPreorderandInorderTraversalKotlin105 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? =
        construct(
            inorder,
            0,
            inorder.size - 1,
            preorder,
            0,
            preorder.size - 1
        )

    private fun construct(
        inorder: IntArray,
        iStart: Int,
        iEnd: Int,
        preorder: IntArray,
        pStart: Int,
        pEnd: Int
    ): TreeNode? {
        if (iStart > iEnd || pStart > pEnd) {
            return null
        }
        val treeNode = TreeNode(preorder[pStart])
        var index = iStart
        while (iStart < preorder.size && inorder[index] != treeNode.`val`) {
            ++index
        }
        treeNode.left = construct(inorder, iStart, index - 1, preorder, pStart + 1, pStart + index - iStart)
        treeNode.right = construct(inorder, index + 1, iEnd, preorder, pStart + index - iStart + 1, pEnd)
        return treeNode
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}