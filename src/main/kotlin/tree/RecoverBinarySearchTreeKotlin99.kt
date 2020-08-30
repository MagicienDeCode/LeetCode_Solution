package tree

class RecoverBinarySearchTreeKotlin99 {
    fun recoverTree(root: TreeNode?) {
        var previous: TreeNode? = null
        var first: TreeNode? = null
        var second: TreeNode? = null
        // binary tree inorder traversal iteratively
        var parent: TreeNode?
        var current = root
        while (current != null) {
            if (current.left != null) {
                parent = current.left
                while (parent!!.right != null && parent.right !== current) {
                    parent = parent.right
                }
                if (parent.right == null) {
                    parent.right = current
                    current = current.left
                    continue
                } else {
                    parent.right = null
                }
            }
            if (previous != null) {
                if (previous.`val` > current.`val`) {
                    if (first == null) {
                        first = previous
                    }
                    second = current
                }
            }
            previous = current
            current = current.right
        }
        // swap value
        val temp = first!!.`val`
        first.`val` = second!!.`val`
        second.`val` = temp
    }
}