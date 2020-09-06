package tree

class LowestCommonAncestorofaBinarySearchTreeKotlin235 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // Value of current node or parent node.
        val parentVal = root!!.`val`

        // Value of p
        val pVal = p!!.`val`

        // Value of q;
        val qVal = q!!.`val`

        return when {
            // If both p and q are greater than parent
            pVal > parentVal && qVal > parentVal -> lowestCommonAncestor(root.right, p, q)
            // // If both p and q are lesser than parent
            pVal < parentVal && qVal < parentVal -> lowestCommonAncestor(root.left, p, q)
            // We have found the split point, i.e. the LCA node.
            else -> root
        }
    }
}