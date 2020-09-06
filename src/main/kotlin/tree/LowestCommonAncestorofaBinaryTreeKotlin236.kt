package tree

class LowestCommonAncestorofaBinaryTreeKotlin236 {
    private var ans: TreeNode? = null

    private fun recurseTree(currentNode: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        val left = if (recurseTree(currentNode.left, p, q)) 1 else 0

        // Right Recursion
        val right = if (recurseTree(currentNode.right, p, q)) 1 else 0

        // If the current node is one of p or q
        val mid = if (currentNode === p || currentNode === q) 1 else 0

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            ans = currentNode
        }

        // Return true if any one of the three bool values is True.
        return mid + left + right > 0
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // Traverse the tree
        recurseTree(root, p, q)
        return ans
    }
}